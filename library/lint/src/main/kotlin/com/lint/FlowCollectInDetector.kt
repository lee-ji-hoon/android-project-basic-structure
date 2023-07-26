@file:Suppress("UnstableApiUsage")

package com.example.checks

import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import com.android.tools.lint.detector.api.LintFix
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity
import com.android.tools.lint.detector.api.SourceCodeScanner
import com.android.tools.lint.detector.api.isKotlin
import com.example.checks.FlowCollectInDetector.Issues.FLOW_ISSUES
import com.intellij.psi.PsiMethod
import com.intellij.psi.util.PsiTypesUtil
import org.jetbrains.uast.UCallExpression
import org.jetbrains.uast.UClass
import org.jetbrains.uast.UMethod
import org.jetbrains.uast.UastFacade
import org.jetbrains.uast.getContainingUClass
import org.jetbrains.uast.visitor.AbstractUastVisitor

class FlowCollectInDetector : Detector(), SourceCodeScanner {
    companion object Issues {
        val FLOW_ISSUES = Issue.create(
            id = "FlowCollectInDetector",
            briefDescription = "Fragment에서 flow를 collect할때는 viewLifecycleOwner를 사용해주세요.",
            explanation = "Fragment에서 flow를 collect 할 때는 viewLifecycleOwner를 사용해야 view가 destroy 됐음에도 collect 하는 일이 없습니다.",
            category = Category.CORRECTNESS,
            severity = Severity.ERROR,
            implementation = Implementation(
                FlowCollectInDetector::class.java, Scope.JAVA_FILE_SCOPE
            ),
            androidSpecific = true
        )
    }

    private val lifecycleMethods = setOf(
        "onCreateView", "onViewCreated", "onActivityCreated", "onViewStateRestored"
    )

    override fun applicableSuperClasses(): List<String> = listOf(FRAGMENT_CLASS)

    override fun visitClass(context: JavaContext, declaration: UClass) {
        declaration.methods.forEach {
            if (lifecycleMethods.contains(it.name)) {
                val visitor = RecursiveMethodVisitor(context, declaration.name, it.name)
                it.uastBody?.accept(visitor)
            }
        }
    }
}

private class RecursiveMethodVisitor(
    private val context: JavaContext,
    private val originFragmentName: String?,
    private val lifecycleMethod: String
) : AbstractUastVisitor() {
    private val visitedMethods = mutableSetOf<UCallExpression>()
    override fun visitCallExpression(node: UCallExpression): Boolean {
        if (visitedMethods.contains(node)) {
            return super.visitCallExpression(node)
        }
        val psiMethod = node.resolve() ?: return super.visitCallExpression(node)
        if (!checkCall(node, psiMethod) && node.isInteresting(context)) {
            val uastNode = UastFacade.convertElementWithParent(
                psiMethod,
                UMethod::class.java
            ) as? UMethod
            visitedMethods.add(node)
            uastNode?.uastBody?.accept(this)
            visitedMethods.remove(node)
        }
        return super.visitCallExpression(node)
    }

    private fun checkCall(call: UCallExpression, psiMethod: PsiMethod): Boolean {
        val issue = findIssueForMethod(psiMethod) ?: return false
        val argMap = context.evaluator.computeArgumentMapping(call, psiMethod)
        argMap.forEach { (arg, param) ->
            if (arg.getExpressionType().extends(context, FRAGMENT_CLASS) &&
                !arg.getExpressionType().extends(context, DIALOG_FRAGMENT_CLASS) &&
                param.type.extends(context, "androidx.lifecycle.LifecycleOwner")
            ) {
                val argType = PsiTypesUtil.getPsiClass(arg.getExpressionType())
                if (argType == call.getContainingUClass()?.javaPsi) {
                    val methodFix = if (isKotlin(context.psiFile)) {
                        "viewLifecycleOwner"
                    } else {
                        "getViewLifecycleOwner()"
                    }
                    context.report(
                        issue, context.getLocation(arg),
                        "$methodFix 이 메서드를 사용해주세요.",
                        LintFix.create()
                            .replace()
                            .with(methodFix)
                            .build()
                    )
                } else {
                    context.report(
                        issue, context.getLocation(call),
                        "${call.methodName}에 Fragment 인스턴스를 'LifecycleOwner'로 사용하는 것은 안전하지 않습니다. " +
                                "이는 ${originFragmentName}.${lifecycleMethod}에서 발생했습니다."
                    )
                }
                return true
            }
        }
        return false
    }

    private fun findIssueForMethod(psiMethod: PsiMethod): Issue? {
        UNSAFE_METHODS.keys.forEach { base ->
            if (context.evaluator.extendsClass(psiMethod.containingClass, base.cls!!) &&
                psiMethod.name == base.name
            ) {
                return UNSAFE_METHODS[base]
            }
        }
        return null
    }
}

internal fun UCallExpression.isInteresting(context: JavaContext): Boolean {
    if (PsiTypesUtil.getPsiClass(receiverType) == this.getContainingUClass()?.javaPsi) {
        return true
    }
    if (valueArgumentCount > 0) {
        valueArguments.forEach {
            if (it.getExpressionType().extends(context, FRAGMENT_CLASS)) {
                return true
            }
        }
    }
    return false
}

internal data class Method(val cls: String?, val name: String)

internal val UNSAFE_METHODS = mapOf(
    // TODO cls 부분 나중에 정해지면 바꿔야 함
    Method(
        cls = "com.example.test.app.FlowExtensions",
        name = "collectIn"
    ) to FLOW_ISSUES,
    Method(
        cls = "com.example.test.app.FlowExtensionsKt",
        name = "collectIn"
    ) to FLOW_ISSUES,
)
private const val FRAGMENT_CLASS = "androidx.fragment.app.Fragment"
private const val DIALOG_FRAGMENT_CLASS = "androidx.fragment.app.DialogFragment"