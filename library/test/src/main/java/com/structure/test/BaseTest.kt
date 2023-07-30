package com.structure.test

import io.mockk.MockKAnnotations
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule

@OptIn(ExperimentalCoroutinesApi::class)
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