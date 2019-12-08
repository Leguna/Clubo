package com.arksana.clubo.main

import android.view.KeyEvent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.arksana.clubo.R
import com.arksana.clubo.utils.EspressoIdlingResource
import org.hamcrest.core.AllOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ActivityTest {

    @get:Rule
    val mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @Test
    fun testSearch() {
        //Search Liverpool
        onView(AllOf.allOf(isDisplayed(), withId(R.id.recyclerView)))
            .perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.action_search)).perform(click())
        onView(withId(R.id.search_src_text)).perform(
            typeText("Liverpool"),
            pressKey(KeyEvent.KEYCODE_ENTER)
        )
        //Check match
        onView(AllOf.allOf(isDisplayed(), withId(R.id.recyclerView)))
            .perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_match)).check(matches(withSubstring("Liverpool")))
        pressBack()
        //Search Japan
        onView(withId(R.id.action_search)).perform(click())
        onView(withId(R.id.search_src_text)).perform(typeText("Japan"))
        //Check Japan Match
        onView(AllOf.allOf(isDisplayed(), withId(R.id.recyclerView)))
            .perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_match)).check(matches(withSubstring("Japan")))
    }

    @Test
    fun testFavorite() {
        //Check item favorite
        onView(withId(R.id.view_pager)).perform(swipeLeft())
        onView(withId(R.id.view_pager)).perform(swipeRight())
        onView(AllOf.allOf(isDisplayed(), withId(R.id.recyclerView))).perform(click())
        onView(withText("Next Match")).perform(click())
        onView(withText("Prev Match")).perform(click())
        //Favorite first item
        onView(AllOf.allOf(isDisplayed(), withId(R.id.recyclerView)))
            .perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.action_favorite)).perform(click())
        pressBack()
        pressBack()
        //UnFavorite first item
        onView(withId(R.id.view_pager)).perform(swipeLeft())
        onView(AllOf.allOf(isDisplayed(), withId(R.id.recyclerView)))
            .perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.action_favorite)).perform(click())
        pressBack()
    }


}
