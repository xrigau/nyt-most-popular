package com.xrigau.nytimesmostpopular.articles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.xrigau.nytimesmostpopular.HttpServiceFactory;
import com.xrigau.nytimesmostpopular.article.Article;
import com.xrigau.nytimesmostpopular.article.MostPopularUseCase;
import com.xrigau.nytimesmostpopular.details.ItemDetailActivity;
import com.xrigau.nytimesmostpopular.details.ItemDetailFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class ArticleListActivity extends AppCompatActivity {

    private ArticlesPresenter articlesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

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
            arguments.putString(ItemDetailFragment.ARG_ITEM_ID, String.valueOf(article.getId()));
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            fragmentManager.beginTransaction()
                    .replace(R.id.item_detail_container, fragment)
                    .commit();
        }
    }

    private static class NewScreenStrategy implements ArticleAdapter.NavigationStrategy {

        private final Context context;

        private NewScreenStrategy(Context context) {
            this.context = context;
        }

        @Override
        public void navigate(Article article) {
            Intent intent = new Intent(context, ItemDetailActivity.class);
            intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, article.getId());
            context.startActivity(intent);
        }
    }
}
