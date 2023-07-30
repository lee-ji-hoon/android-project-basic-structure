package com.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue

@Suppress("unused")
class IssueRegistry : IssueRegistry() {

    override val api: Int = CURRENT_API

    override val issues: List<Issue> = listOf(
        FlowCollectInDetector.FLOW_ISSUES
    )
}
