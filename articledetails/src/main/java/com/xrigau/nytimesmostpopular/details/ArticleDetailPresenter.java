package com.xrigau.nytimesmostpopular.details;

import com.xrigau.nytimesmostpopular.article.Article;

class ArticleDetailPresenter {

    private final ArticleDetailView articleDetailView;
    private final Navigator navigator;

    ArticleDetailPresenter(ArticleDetailView articleDetailView, Navigator navigator) {
        this.articleDetailView = articleDetailView;
        this.navigator = navigator;
    }

    void startPresenting(Article article) {
        articleDetailView.show(article, new ArticleDetailView.Listener() {
            @Override
            public void onActionPressed(Article article) {
                navigator.navigateTo(article.getUrl());
            }
        });
    }

}
