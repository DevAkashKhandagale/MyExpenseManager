package com.devakashk.myexpensemanager

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class DemoPageTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun demoPageTest() {
        composeTestRule.setContent {
            DemoPage()
        }

        composeTestRule.onNodeWithText("Button1").assertExists()
        composeTestRule.onNodeWithText("test").assertExists()
        composeTestRule.onNodeWithText("Button1").performClick()

        composeTestRule.onNodeWithText("Akash").assertExists()

    }
}