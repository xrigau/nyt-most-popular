package com.xrigau.nytimesmostpopular.articles;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.xrigau.nytimesmostpopular.article.Article;
import com.xrigau.nytimesmostpopular.article.ArticlesResult;
import com.xrigau.nytimesmostpopular.article.MostPopularUseCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

@RunWith(MockitoJUnitRunner.class)
public class ArticleListPresenterTest {

    private static final ArticlesResult.Success SUCCESS = new ArticlesResult.Success(
            Collections.singletonList(
                    new Article(123L, "Title", "Abstract", "Byline", "Date", "Url", Article.Image.MISSING, Article.Image.MISSING)
            )
    );
    private static final ArticlesResult.ServerError SERVER_ERROR = new ArticlesResult.ServerError("error reason");
    private static final ArticlesResult.ClientError CLIENT_ERROR = new ArticlesResult.ClientError(new Exception("client error"));

    @Mock private MostPopularUseCase useCase;
    @Mock private ArticlesView view;

    private ArticleListPresenter presenter;

    @Before
    public void setUp() {
        presenter = new ArticleListPresenter(useCase, view);
    }

    @Test
    public void showsLoadingWhenStartPresenting() {
        presenter.startPresenting();

        verify(view).showLoading();
    }

    @Test
    public void loadsMostViewedArticlesWhenStartPresenting() {
        presenter.startPresenting();

        verify(useCase).loadMostViewedArticles(any(MostPopularUseCase.Callback.class));
    }

    @Test
    public void showsArticlesWhenLoadedResultIsSuccess() {
        presenter.startPresenting();

        invoke().onResult(SUCCESS);

        verify(view).show(SUCCESS.getArticles());
    }

    @Test
    public void showsErrorReasonWhenLoadedResultIsServerError() {
        presenter.startPresenting();

        invoke().onResult(SERVER_ERROR);

        verify(view).showError(SERVER_ERROR.getReason());
    }

    @Test
    public void showsGenericErrorWhenLoadedResultIsClientError() {
        presenter.startPresenting();

        invoke().onResult(CLIENT_ERROR);

        verify(view).showGenericError();
    }

    private MostPopularUseCase.Callback invoke() {
        ArgumentCaptor<MostPopularUseCase.Callback> captor = ArgumentCaptor.forClass(MostPopularUseCase.Callback.class);
        verify(useCase).loadMostViewedArticles(captor.capture());
        return captor.getValue();
    }

}
