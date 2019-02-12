package com.xrigau.nytimesmostpopular.details;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.xrigau.nytimesmostpopular.article.Article;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ArticleDetailFragment extends Fragment {

    public static final String ARG_ARTICLE = "argument_article";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!getArguments().containsKey(ARG_ARTICLE)) {
            throw new NullPointerException("Missing article. Make sure you pass the ARG_ARTICLE argument.");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.item_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArticleDetailView articleDetailView = AndroidArticleDetailView.create(this);
        ArticleDetailPresenter presenter = new ArticleDetailPresenter(articleDetailView, new AndroidNavigator(view.getContext()));
        Article article = (Article) getArguments().getSerializable(ARG_ARTICLE);
        presenter.startPresenting(article);
    }

}
