package com.xrigau.nytimesmostpopular;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.IdlingResource;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import com.jakewharton.espresso.OkHttp3IdlingResource;
import com.xrigau.nytimesmostpopular.articles.ArticleListActivity;
import com.xrigau.nytimesmostpopular.articles.R;
import okhttp3.OkHttpClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ArticleListTest {
    @Rule
    public ActivityTestRule<ArticleListActivity> activityRule = new ActivityTestRule<>(ArticleListActivity.class);
    private IdlingResource idlingResource;

    @Before
    public void setUp() throws Exception {
        OkHttpClient okHttpClient = ((Application) activityRule.getActivity().getApplication()).provideOkHttpClient();
        idlingResource = OkHttp3IdlingResource.create("OkHttp", okHttpClient);
        IdlingRegistry.getInstance().register(idlingResource);
    }

    @Test
    public void articleListExists() {
        onView(withId(R.id.articles))
                .check(matches(isDisplayed()));
    }

    @Test
    public void showsArticleDetailsExists() {
        onView(withId(R.id.articles))
                .perform(actionOnItemAtPosition(0, click()));

        onView(withId(R.id.detail_page)).check(matches(isDisplayed()));
    }

    @After
    public void tearDown() throws Exception {
        IdlingRegistry.getInstance().unregister(idlingResource);
    }
}
