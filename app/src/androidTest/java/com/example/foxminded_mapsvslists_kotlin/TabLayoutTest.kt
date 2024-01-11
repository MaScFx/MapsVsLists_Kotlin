package com.example.foxminded_mapsvslists_kotlin

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import com.example.foxminded_mapsvslists_kotlin.ui.EnterSizeScreen
import org.junit.Rule
import org.junit.Test

class TabLayoutTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun enterCountInEditText_and_allItemsIsDisplayed() {
        rule.setContent {
            EnterSizeScreen(
                title = "Test title",
                textFieldValue = "enter value",
                onClickButton = {},
                numberInTextField = 10_000,
                onChangeInputCount = {}
            )
        }

        rule.onNodeWithText("10000").assertIsDisplayed()
        rule.onNodeWithText("Test title").assertIsDisplayed()
        rule.onNodeWithText("enter value").assertIsDisplayed()
        rule.onNodeWithText("CALCULATE").assertIsDisplayed()

        rule.onNodeWithText("enter value").performTextClearance()
        rule.onNodeWithText("enter value").performTextInput("12345")
        rule.onNodeWithText("CALCULATE").performClick()
    }
}