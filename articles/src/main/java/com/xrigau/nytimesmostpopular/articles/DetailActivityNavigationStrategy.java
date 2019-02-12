package com.xrigau.nytimesmostpopular.articles;

import com.xrigau.nytimesmostpopular.article.Article;
import com.xrigau.nytimesmostpopular.details.ArticleDetailFragment;

import android.content.Context;
import android.content.Intent;

class DetailActivityNavigationStrategy implements ArticleDetailsDisplayStrategy {

    private static final String VIEW_DETAILS_ACTION = "com.xrigau.nytimesmostpopular.VIEW_DETAILS";

    private final Context context;

    DetailActivityNavigationStrategy(Context context) {
        this.context = context;
    }

    @Override
    public void display(Article article) {
        Intent intent = new Intent(VIEW_DETAILS_ACTION);
        intent.putExtra(ArticleDetailFragment.ARG_ARTICLE, article);
        context.startActivity(intent);
    }
}
