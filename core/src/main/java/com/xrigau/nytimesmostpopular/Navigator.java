package com.xrigau.nytimesmostpopular;

import com.xrigau.nytimesmostpopular.article.Article;

public interface Navigator {
    void navigateTo(Article article);

    void navigateTo(String url);
}
