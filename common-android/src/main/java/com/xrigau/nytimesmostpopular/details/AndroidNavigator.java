package com.xrigau.nytimesmostpopular.details;

import com.xrigau.nytimesmostpopular.article.Article;

import android.content.Context;
import android.content.Intent;

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
        // TODO: Chrome custom tabs
    }
}
