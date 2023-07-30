package com.structure.test

import io.mockk.MockKAnnotations
import org.junit.After
import org.junit.Before
import org.junit.Rule

abstract class BaseTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Before
    open fun setup() {
        MockKAnnotations.init(this, relaxed = true)
    }

    @After
    open fun tearDown() {
    }
}