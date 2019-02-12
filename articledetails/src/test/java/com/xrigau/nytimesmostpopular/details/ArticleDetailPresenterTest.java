package com.xrigau.nytimesmostpopular.details;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import com.xrigau.nytimesmostpopular.Navigator;
import com.xrigau.nytimesmostpopular.article.Article;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ArticleDetailPresenterTest {

    private static final Article ARTICLE = new Article(123L, "Title", "Abstract", "Byline", "Date", "Url", Article.Image.MISSING, Article.Image.MISSING);

    @Mock private ArticleDetailView view;
    @Mock private Navigator navigator;

    private ArticleDetailPresenter presenter;

    @Before
    public void setUp() {
        presenter = new ArticleDetailPresenter(view, navigator);
    }

    @Test
    public void usesViewToPresent() {
        presenter.startPresenting(ARTICLE);

        verify(view).show(eq(ARTICLE), any(ArticleDetailView.Listener.class));
    }

    @Test
    public void navigatesToArticleUrlOnActionPressed() {
        presenter.startPresenting(ARTICLE);

        invoke().onActionPressed(ARTICLE);

        verify(navigator).navigateTo(ARTICLE.getUrl());
    }

    private ArticleDetailView.Listener invoke() {
        ArgumentCaptor<ArticleDetailView.Listener> captor = ArgumentCaptor.forClass(ArticleDetailView.Listener.class);
        verify(view).show(eq(ARTICLE), captor.capture());
        return captor.getValue();
    }
}
