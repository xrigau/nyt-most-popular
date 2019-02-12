package com.xrigau.nytimesmostpopular.articles;

import androidx.appcompat.app.AppCompatActivity;
import com.xrigau.nytimesmostpopular.HttpServiceFactory;
import com.xrigau.nytimesmostpopular.article.MostPopularUseCase;
import com.xrigau.nytimesmostpopular.details.AndroidNavigator;

import android.os.Bundle;

public class ArticleListActivity extends AppCompatActivity {

    private ArticlesPresenter articlesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.articles_activity);

        MostPopularUseCase mostPopularUseCase = MostPopularUseCase.create(HttpServiceFactory.create("https://api.nytimes.com/"));
        ArticlesView articlesView = AndroidArticlesView.create(this, createNavigationStrategy());
        articlesPresenter = new ArticleListPresenter(mostPopularUseCase, articlesView);
    }

    private ArticleDetailsDisplayStrategy createNavigationStrategy() {
        if (usingTwoPaneLayout()) {
            return new TwoPaneDetailFragmentStrategy(getSupportFragmentManager());
        } else {
            return new DetailActivityNavigationStrategy(new AndroidNavigator(this));
        }
    }

    private boolean usingTwoPaneLayout() {
        return getResources().getBoolean(R.bool.is_tablet);
    }

    @Override
    protected void onStart() {
        super.onStart();
        articlesPresenter.startPresenting();
    }

    @Override
    protected void onStop() {
        super.onStop();
        articlesPresenter.stopPresenting();
    }

}
