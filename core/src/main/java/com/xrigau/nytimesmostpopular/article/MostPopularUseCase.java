package com.xrigau.nytimesmostpopular.article;

import com.xrigau.nytimesmostpopular.HttpServiceFactory;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class MostPopularUseCase {

    private final Callback NULL_SAFE_CALLBACK = new Callback() {
        @Override
        public void onResult(ArticlesResult result) {
            // no op
        }
    };

    private final MostPopularService mostPopularService;
    private final ResponseConverter responseConverter;
    private final FailureConverter failureConverter;

    private Callback callback = NULL_SAFE_CALLBACK;

    public static MostPopularUseCase create(HttpServiceFactory httpServiceFactory) {
        MostPopularService mostPopularService = httpServiceFactory.createMostPopularService();
        return new MostPopularUseCase(mostPopularService, new ResponseConverter(), new FailureConverter());
    }

    private MostPopularUseCase(MostPopularService mostPopularService, ResponseConverter responseConverter, FailureConverter failureConverter) {
        this.mostPopularService = mostPopularService;
        this.responseConverter = responseConverter;
        this.failureConverter = failureConverter;
    }

    public void loadMostViewedArticles(Callback callback) {
        this.callback = callback;

        // TODO: The token needs to be extracted
        Call<ApiResponse> call = mostPopularService.listMostViewedArticles("all-sections", "7", "2Rxr2VwHajucNjXAtcc9PzBAVe7uvdpp");
        call.enqueue(new retrofit2.Callback<ApiResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                MostPopularUseCase.this.callback.onResult(responseConverter.convert(response));
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<ApiResponse> call, Throwable throwable) {
                MostPopularUseCase.this.callback.onResult(failureConverter.convert(throwable));
            }
        });
    }

    public void cancel() {
        // TODO: We're not cancelling the API call
        callback = NULL_SAFE_CALLBACK;
    }

    public interface Callback {
        void onResult(ArticlesResult result);
    }

}
