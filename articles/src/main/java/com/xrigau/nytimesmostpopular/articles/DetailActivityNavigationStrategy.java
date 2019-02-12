package com.xrigau.nytimesmostpopular.articles;

import com.xrigau.nytimesmostpopular.article.Article;
import com.xrigau.nytimesmostpopular.Navigator;

class DetailActivityNavigationStrategy implements ArticleDetailsDisplayStrategy {

    private final Navigator navigator;

    DetailActivityNavigationStrategy(Navigator navigator) {
        this.navigator = navigator;
    }

    @Override
    public void display(Article article) {
        navigator.navigateTo(article);
    }
}
