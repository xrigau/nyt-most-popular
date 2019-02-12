package com.xrigau.nytimesmostpopular.articles;

import androidx.fragment.app.FragmentManager;
import com.xrigau.nytimesmostpopular.article.Article;
import com.xrigau.nytimesmostpopular.details.ArticleDetailFragment;

import android.os.Bundle;

class TwoPaneDetailFragmentStrategy implements ArticleDetailsDisplayStrategy {

    private final FragmentManager fragmentManager;

    TwoPaneDetailFragmentStrategy(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Override
    public void display(Article article) {
        // There's some duplication here & in ArticleDetailActivity - it could be extracted if needed
        Bundle arguments = new Bundle();
        arguments.putSerializable(ArticleDetailFragment.ARG_ARTICLE, article);
        ArticleDetailFragment fragment = new ArticleDetailFragment();
        fragment.setArguments(arguments);
        fragmentManager.beginTransaction()
                .replace(R.id.item_detail_container, fragment)
                .commit();
    }
}
