package com.xrigau.nytimesmostpopular.articles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import com.xrigau.nytimesmostpopular.article.Article;
import com.xrigau.nytimesmostpopular.articles.ArticleAdapter.NavigationStrategy;

import java.util.List;

public class AndroidArticlesView implements ArticlesView {

    private final RecyclerView recyclerView;
    private final NavigationStrategy navigationStrategy;

    public static ArticlesView create(AppCompatActivity activity, NavigationStrategy navigationStrategy) {
        Toolbar toolbar = activity.findViewById(R.id.toolbar);
        toolbar.setTitle(activity.getTitle());
        activity.setSupportActionBar(toolbar);
        RecyclerView recyclerView = activity.findViewById(R.id.articles);
        return new AndroidArticlesView(recyclerView, navigationStrategy);
    }

    AndroidArticlesView(RecyclerView recyclerView, NavigationStrategy navigationStrategy) {
        this.recyclerView = recyclerView;
        this.navigationStrategy = navigationStrategy;
    }

    @Override
    public void show(List<Article> articles) {
        recyclerView.setAdapter(new ArticleAdapter(articles, navigationStrategy));
    }

    @Override
    public void showError(String reason) {
        Snackbar.make(recyclerView, reason, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showGenericError() {
        Snackbar.make(recyclerView, R.string.generic_error, Snackbar.LENGTH_LONG).show();
    }
}
