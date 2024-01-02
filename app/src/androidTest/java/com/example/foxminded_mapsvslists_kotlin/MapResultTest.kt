package com.example.foxminded_mapsvslists_kotlin

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithText
import com.example.foxminded_mapsvslists_kotlin.ui.compose_funs.maps.MapResult
import org.junit.Rule
import org.junit.Test

class MapResultTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun should_ProgressBar_Displayed() {
        val testMap = HashMap<Int, Int>()
        for (i in 0 until 30) {
            testMap[i] = i
        }
        rule.setContent { MapResult(onBackClick = {}, result = testMap) }

        rule.onNodeWithText("22").assertIsDisplayed()
        rule.onNodeWithText("23").assertIsDisplayed()
        rule.onNodeWithText("24").assertIsDisplayed()
        rule.onNodeWithText("25").assertIsDisplayed()
        rule.onNodeWithText("26").assertIsDisplayed()

        rule.onAllNodesWithTag("ResultItemCircularProgressIndicator").assertCountEquals(0)

        rule.onNodeWithText("Clean").assertHasClickAction()
        rule.onNodeWithText("Clean").assertIsDisplayed()
    }

    @Test
    fun should_ProgressBar_NotDisplayed() {
        val testMap = HashMap<Int, Int>()
        for (i in 0 until 30) {
            testMap[i] = -1
        }
        rule.setContent { MapResult(onBackClick = {}, result = testMap) }

        rule.onNodeWithText("22").assertIsNotDisplayed()
        rule.onNodeWithText("23").assertIsNotDisplayed()
        rule.onNodeWithText("24").assertIsNotDisplayed()
        rule.onNodeWithText("25").assertIsNotDisplayed()
        rule.onNodeWithText("26").assertIsNotDisplayed()

        rule.onAllNodesWithTag("ResultItemCircularProgressIndicator").assertCountEquals(6)

        rule.onNodeWithText("Clean").assertHasClickAction()
        rule.onNodeWithText("Clean").assertIsDisplayed()
    }
}