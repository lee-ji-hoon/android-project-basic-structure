package com.lint

import com.android.tools.lint.detector.api.JavaContext
import com.intellij.psi.PsiType
import com.intellij.psi.util.PsiTypesUtil

/**
 * [PsiType]이 [superName]에 대한 정규화된 클래스 이름의 하위 클래스인지 확인합니다.
 * @param context lint 요청의 컨텍스트입니다.
 * @param superName [PsiType]이 하위 클래스인지 확인할 정규화된 클래스 이름입니다.
 * @param strict [superName]이 포함되는지 여부를 나타냅니다.
 */
internal fun PsiType?.extends(
    context: JavaContext,
    superName: String,
    strict: Boolean = false
): Boolean = context.evaluator.extendsClass(PsiTypesUtil.getPsiClass(this), superName, strict)