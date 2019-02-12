package com.xrigau.nytimesmostpopular.articles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.xrigau.nytimesmostpopular.HttpServiceFactory;
import com.xrigau.nytimesmostpopular.article.Article;
import com.xrigau.nytimesmostpopular.article.MostPopularUseCase;
import com.xrigau.nytimesmostpopular.details.ArticleDetailFragment;

import android.content.Context;
import android.content.Intent;
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

    private ArticleAdapter.NavigationStrategy createNavigationStrategy() {
        if (usingTwoPaneLayout()) {
            return new TwoPaneStrategy(getSupportFragmentManager());
        } else {
            return new NewScreenStrategy(this);
        }
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

    private boolean usingTwoPaneLayout() {
        return getResources().getBoolean(R.bool.is_tablet);
    }

    private static class TwoPaneStrategy implements ArticleAdapter.NavigationStrategy {

        private final FragmentManager fragmentManager;

        private TwoPaneStrategy(FragmentManager fragmentManager) {
            this.fragmentManager = fragmentManager;
        }

        @Override
        public void navigate(Article article) {
            Bundle arguments = new Bundle();
            arguments.putSerializable(ArticleDetailFragment.ARG_ARTICLE, article);
            ArticleDetailFragment fragment = new ArticleDetailFragment();
            fragment.setArguments(arguments);
            fragmentManager.beginTransaction()
                    .replace(R.id.item_detail_container, fragment)
                    .commit();
        }
    }

    private static class NewScreenStrategy implements ArticleAdapter.NavigationStrategy {

        private static final String VIEW_DETAILS_ACTION = "com.xrigau.nytimesmostpopular.VIEW_DETAILS";

        private final Context context;

        private NewScreenStrategy(Context context) {
            this.context = context;
        }

        @Override
        public void navigate(Article article) {
            Intent intent = new Intent(VIEW_DETAILS_ACTION);
            intent.putExtra(ArticleDetailFragment.ARG_ARTICLE, article);
            context.startActivity(intent);
        }
    }
}
