package com.arksana.clubo.main;

import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class MyViewAction {

    public static ViewAction clickChildViewWithId(final int id) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return null;
            }

            @Override
            public String getDescription() {
                return "Click on a child view with specified id.";
            }

            @Override
            public void perform(UiController uiController, View view) {
                View v = view.findViewById(id);
                v.performClick();
            }
        };
    }

    public static <T> Matcher<T> result(final Matcher<T> matcher, final int i) {
        return new BaseMatcher<T>() {
            private int resultIndex = -1;

            @Override
            public boolean matches(final Object item) {
                if (matcher.matches(item)) {
                    resultIndex++;
                    return resultIndex == i;
                }
                return false;
            }

            @Override
            public void describeTo(final Description description) {
            }
        };
    }


}
