package com.xrigau.nytimesmostpopular.articles;

import com.xrigau.nytimesmostpopular.article.ArticlesResult;
import com.xrigau.nytimesmostpopular.article.MostPopularUseCase;

public class ArticleListPresenter implements ArticlesPresenter {

    private final MostPopularUseCase mostPopularUseCase;
    private final ArticlesView articlesView;

    public ArticleListPresenter(MostPopularUseCase mostPopularUseCase, ArticlesView articlesView) {
        this.mostPopularUseCase = mostPopularUseCase;
        this.articlesView = articlesView;
    }

    @Override
    public void startPresenting() {
        mostPopularUseCase.loadMostViewedArticles(new MostPopularUseCase.Callback() {
            @Override
            public void onResult(ArticlesResult result) {
                if (result instanceof ArticlesResult.Success) {
                    articlesView.show(((ArticlesResult.Success) result).getArticles());
                } else if (result instanceof ArticlesResult.ServerError) {
                    articlesView.showError(((ArticlesResult.ServerError) result).getReason());
                } else if (result instanceof ArticlesResult.ClientError) {
                    articlesView.showGenericError();
                }
            }
        });
    }

    @Override
    public void stopPresenting() {
        mostPopularUseCase.cancel();
    }
}
