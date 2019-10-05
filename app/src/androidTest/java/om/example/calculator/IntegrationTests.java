package om.example.calculator;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class IntegrationTests {
    // Define the activity to be tested
    @Rule
    public ActivityTestRule<MainActivity> activity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testButton1() {
        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.display)).check(matches(withText("1")));
    }

    @Test
    public void testAddition() {
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.buttonAdd)).perform(click());
        onView(withId(R.id.button5)).perform(click());
        onView(withId(R.id.buttonEq)).perform(click());
        onView(withId(R.id.display)).check(matches(withText("8.0")));
    }

    @Test
    public void testMultiplication() {
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.buttonMul)).perform(click());
        onView(withId(R.id.button6)).perform(click());
        onView(withId(R.id.buttonEq)).perform(click());
        onView(withId(R.id.display)).check(matches(withText("12.0")));
    }

    @Test
    public void testSubtraction() {
        onView(withId(R.id.button7)).perform(click());
        onView(withId(R.id.buttonSub)).perform(click());
        onView(withId(R.id.button9)).perform(click());
        onView(withId(R.id.buttonEq)).perform(click());
        onView(withId(R.id.display)).check(matches(withText("-2.0")));
    }

    @Test
    public void testDiv() {
        onView(withId(R.id.button5)).perform(click());
        onView(withId(R.id.buttonDiv)).perform(click());
        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.button0)).perform(click());
        onView(withId(R.id.buttonEq)).perform(click());
        onView(withId(R.id.display)).check(matches(withText("0.5")));
    }

    @Test
    public void testDoubleClickDot() {
        onView(withId(R.id.buttonDot)).perform(click());
        onView(withId(R.id.display)).check(matches(withText("0.")));
        onView(withId(R.id.buttonEq)).perform(click());
        onView(withId(R.id.display)).check(matches(withText("0.0")));
    }

    @Test
    public void testDoubleClickNeg() {
        onView(withId(R.id.buttonNeg)).perform(click());
        onView(withId(R.id.display)).check(matches(withText("-0")));
        onView(withId(R.id.buttonNeg)).perform(click());
        onView(withId(R.id.display)).check(matches(withText("0")));
    }

    @Test
    public void testInfinityAndNaNResults() {
        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.buttonDiv)).perform(click());
        onView(withId(R.id.button0)).perform(click());
        onView(withId(R.id.buttonEq)).perform(click());
        onView(withId(R.id.display)).check(matches(withText("Infinity")));

        onView(withId(R.id.buttonMul)).perform(click());
        onView(withId(R.id.button0)).perform(click());
        onView(withId(R.id.buttonEq)).perform(click());
        onView(withId(R.id.display)).check(matches(withText("NaN")));

        onView(withId(R.id.buttonEq)).perform(click());
        onView(withId(R.id.display)).check(matches(withText("NaN")));
    }
}
