package com.xrigau.nytimesmostpopular.details;

import com.xrigau.nytimesmostpopular.article.Article;

interface ArticleDetailView {
    void show(Article article, Listener listener);

    interface Listener {
        void onActionPressed(Article article);
    }
}
