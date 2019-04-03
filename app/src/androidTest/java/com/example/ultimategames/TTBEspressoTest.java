package com.example.ultimategames;

        import android.support.test.espresso.ViewAction;
        import android.support.test.rule.ActivityTestRule;
        import android.support.test.runner.AndroidJUnit4;
        import android.widget.Button;
        import android.widget.TextView;

        import org.junit.Rule;
        import org.junit.Test;
        import org.junit.runner.RunWith;

        import static android.support.test.espresso.Espresso.onView;
        import static android.support.test.espresso.action.ViewActions.click;
        import static android.support.test.espresso.assertion.ViewAssertions.matches;
        import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
        import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
        import static android.support.test.espresso.matcher.ViewMatchers.withId;
        import static android.support.test.espresso.matcher.ViewMatchers.withText;
        import static org.hamcrest.Matchers.not;
        import com.example.ultimategames.TouchTheBlock.TTB_Activity;

@RunWith(AndroidJUnit4.class)
public class TTBEspressoTest {
    @Rule
    public ActivityTestRule<TTB_Activity> activityTestRule = new ActivityTestRule<>(TTB_Activity.class);

    @Test
    public void testButtonsVisible() {

        onView(withId(R.id.bt_Backround)).check(matches(isDisplayed()));
    }
    @Test
    public void testVisibility(){
        onView(withId(R.id.bt_block)).check(matches(isDisplayed()));
        onView(withId(R.id.bt_Backround)).check(matches(isDisplayed()));
    }
    @Test
    public void testButtonMovment()
    {
        onView(withId(R.id.bt_block)).check(matches(isClickable()));
        onView(withId(R.id.bt_block)).perform(click()).check(matches(isDisplayed()));
    }

    @Test
    public void ButtonShouldStayVisible()
    {
        // After Clicking the Button should Stay Visible and not disapear

        for (int i = 0; i < 5; i++) {
            onView(withId(R.id.bt_block)).perform(click());
            onView(withId(R.id.bt_block)).perform(click()).check(matches(isDisplayed()));
        }
    }

    @Test
    public void LostMessageShouldBeDisplayed()
    {
        // After Clicking the Button should Stay Visible and not disapear

            onView(withId(R.id.bt_Backround)).perform(click());
            onView(withId(R.id.txt_Lost)).check(matches(isDisplayed()));
    }

}