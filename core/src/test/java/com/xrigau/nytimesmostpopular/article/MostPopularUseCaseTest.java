package com.xrigau.nytimesmostpopular.article;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import retrofit2.Call;

@RunWith(MockitoJUnitRunner.class)
public class MostPopularUseCaseTest {

    @Mock private MostPopularService mostPopularService;
    @Mock private ResponseConverter responseConverter;
    @Mock private FailureConverter failureConverter;

    @Test
    public void shouldCallServiceWithCorrectParameters() {
        String apiToken = "apiToken";
        MostPopularUseCase useCase = new MostPopularUseCase(mostPopularService, responseConverter, failureConverter, apiToken);
        when(mostPopularService.listMostViewedArticles(anyString(), anyString(), anyString())).thenReturn(mock(Call.class));

        useCase.loadMostViewedArticles(null);

        verify(mostPopularService).listMostViewedArticles("all-sections", "7", apiToken);
    }
}
