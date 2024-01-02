package com.example.foxminded_mapsvslists_kotlin

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithText
import com.example.foxminded_mapsvslists_kotlin.ui.compose_funs.collection.CollectionResult
import com.example.foxminded_mapsvslists_kotlin.ui.compose_funs.maps.MapResult
import org.junit.Rule
import org.junit.Test

class CollectionResultTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun should_ProgressBar_Displayed() {
        val testMap = HashMap<Int, Int>()
        for (i in 0 until 30) {
            testMap[i] = i
        }
        rule.setContent { CollectionResult(onBackClick = {}, result = testMap) }

        rule.onNodeWithText("0").assertIsDisplayed()
        rule.onNodeWithText("1").assertIsDisplayed()
        rule.onNodeWithText("2").assertIsDisplayed()
        rule.onNodeWithText("3").assertIsDisplayed()
        rule.onNodeWithText("4").assertIsDisplayed()
        rule.onNodeWithText("5").assertIsDisplayed()
        rule.onNodeWithText("6").assertIsDisplayed()
        rule.onNodeWithText("7").assertIsDisplayed()
        rule.onNodeWithText("8").assertIsDisplayed()
        rule.onNodeWithText("9").assertIsDisplayed()
        rule.onNodeWithText("10").assertIsDisplayed()
        rule.onNodeWithText("11").assertIsDisplayed()
        rule.onNodeWithText("12").assertIsDisplayed()
        rule.onNodeWithText("13").assertIsDisplayed()
        rule.onNodeWithText("14").assertIsDisplayed()
        rule.onNodeWithText("15").assertIsDisplayed()
        rule.onNodeWithText("16").assertIsDisplayed()
        rule.onNodeWithText("17").assertIsDisplayed()
        rule.onNodeWithText("18").assertIsDisplayed()
        rule.onNodeWithText("19").assertIsDisplayed()
        rule.onNodeWithText("20").assertIsDisplayed()

        rule.onAllNodesWithTag("ResultItemCircularProgressIndicator").assertCountEquals(0)

        rule.onNodeWithText("Clean").assertHasClickAction()
        rule.onNodeWithText("Clean").assertIsDisplayed()
    }

    @Test
    fun should_ProgressBar_NotDisplayed() {
        val testMap = HashMap<Int, Int>()
        for (i in 0 until 30) {
            testMap[i] = i
        }
        rule.setContent { MapResult(onBackClick = {}, result = testMap) }

        rule.onNodeWithText("0").assertIsNotDisplayed()
        rule.onNodeWithText("1").assertIsNotDisplayed()
        rule.onNodeWithText("2").assertIsNotDisplayed()
        rule.onNodeWithText("3").assertIsNotDisplayed()
        rule.onNodeWithText("4").assertIsNotDisplayed()
        rule.onNodeWithText("5").assertIsNotDisplayed()
        rule.onNodeWithText("6").assertIsNotDisplayed()
        rule.onNodeWithText("7").assertIsNotDisplayed()
        rule.onNodeWithText("8").assertIsNotDisplayed()
        rule.onNodeWithText("9").assertIsNotDisplayed()
        rule.onNodeWithText("10").assertIsNotDisplayed()
        rule.onNodeWithText("11").assertIsNotDisplayed()
        rule.onNodeWithText("12").assertIsNotDisplayed()
        rule.onNodeWithText("13").assertIsNotDisplayed()
        rule.onNodeWithText("14").assertIsNotDisplayed()
        rule.onNodeWithText("15").assertIsNotDisplayed()
        rule.onNodeWithText("16").assertIsNotDisplayed()
        rule.onNodeWithText("17").assertIsNotDisplayed()
        rule.onNodeWithText("18").assertIsNotDisplayed()
        rule.onNodeWithText("19").assertIsNotDisplayed()
        rule.onNodeWithText("20").assertIsNotDisplayed()

        rule.onAllNodesWithTag("ResultItemCircularProgressIndicator").assertCountEquals(0)

        rule.onNodeWithText("Clean").assertHasClickAction()
        rule.onNodeWithText("Clean").assertIsDisplayed()
    }
}