package com.xrigau.nytimesmostpopular.details;

import com.xrigau.nytimesmostpopular.article.Article;

public interface Navigator {
    void navigateTo(Article article);

    void navigateTo(String url);
}
