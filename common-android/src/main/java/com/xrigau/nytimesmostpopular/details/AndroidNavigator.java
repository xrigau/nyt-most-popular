package com.xrigau.nytimesmostpopular.details;

import androidx.browser.customtabs.CustomTabsIntent;
import com.xrigau.nytimesmostpopular.Navigator;
import com.xrigau.nytimesmostpopular.article.Article;
import com.xrigau.nytimesmostpopular.common.R;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class AndroidNavigator implements Navigator {

    private static final String VIEW_DETAILS_ACTION = "com.xrigau.nytimesmostpopular.VIEW_DETAILS";

    private final Context context;

    public AndroidNavigator(Context context) {
        this.context = context;
    }

    @Override
    public void navigateTo(Article article) {
        Intent intent = new Intent(VIEW_DETAILS_ACTION);
        intent.putExtra("argument_article", article);
        context.startActivity(intent);
    }

    @Override
    public void navigateTo(String url) {
        CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder()
                .setToolbarColor(context.getResources().getColor(R.color.browser_tabs_color))
                .build();
        customTabsIntent.launchUrl(context, Uri.parse(url));
    }
}
