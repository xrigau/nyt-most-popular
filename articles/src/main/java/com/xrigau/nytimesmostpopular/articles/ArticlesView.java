package com.xrigau.nytimesmostpopular.articles;

import com.xrigau.nytimesmostpopular.article.Article;

import java.util.List;

interface ArticlesView {
    void show(List<Article> articles);

    void showError(String reason);

    void showGenericError();

    void showLoading();
}
