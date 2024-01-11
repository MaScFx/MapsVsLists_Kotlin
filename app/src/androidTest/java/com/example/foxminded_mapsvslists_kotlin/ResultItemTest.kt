package com.example.foxminded_mapsvslists_kotlin

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.example.foxminded_mapsvslists_kotlin.ui.ResultItem
import org.junit.Rule
import org.junit.Test

class ResultItemTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun should_ProgressBarDisplayed() {
        rule.setContent { ResultItem(title = "title", result = -1) }

        rule.onNodeWithText("title").assertIsDisplayed()
        rule.onNodeWithTag("ResultItemCircularProgressIndicator").assertIsDisplayed()
    }

    @Test
    fun should_ProgressBarNotDisplayed() {
        rule.setContent { ResultItem(title = "title", result = 0) }

        rule.onNodeWithText("title").assertIsDisplayed()
        rule.onNodeWithTag("ResultItemCircularProgressIndicator").assertIsNotDisplayed()
    }
}