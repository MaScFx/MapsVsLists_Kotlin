package com.example.foxminded_mapsvslists_kotlin

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.Matchers
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.foxminded_mapsvslists_kotlin", appContext.packageName)
    }

//    @Rule
//    var mActivityScenarioRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule<Any?>(
//        MainActivity::class.java
//    )

    @Test
    fun collectionFragmentTest() {
//        checkingStartCollectionScreen()
        Espresso.onView(withText("enter value")).perform(ViewActions.typeText("10"))
        Espresso.onView(withText("CALCULATE")).perform(ViewActions.click())
//        Espresso.onView(withId(R.id.et_collectionSize))
//            .check(ViewAssertions.matches(Matchers.not<View>(ViewMatchers.isDisplayed())))
//        Espresso.onView(withId(R.id.btn_calculate_list))
//            .check(ViewAssertions.matches(Matchers.not<View>(ViewMatchers.isDisplayed())))
//        Espresso.onView(withId(R.id.tv_addingBeginning))
//            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//        Espresso.pressBack()
//        Espresso.onView(withId(R.id.btn_clear_list)).perform(ViewActions.click())
//        checkingStartCollectionScreen()
    }

//    fun checkingStartCollectionScreen() {
//        Espresso.onView(withTe(R.id.btn_clear_list)).check(
//            ViewAssertions
//                .matches(Matchers.not<View>(ViewMatchers.isDisplayed()))
//        )
//        Espresso.onView(withId(R.id.et_collectionSize))
//            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//        Espresso.onView(withId(R.id.btn_calculate_list))
//            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//    }
}