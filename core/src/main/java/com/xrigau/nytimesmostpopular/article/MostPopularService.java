package com.xrigau.nytimesmostpopular.article;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MostPopularService {
    @GET("svc/mostpopular/v2/mostviewed/{section}/{period}.json")
    Call<ApiResponse> listMostViewedArticles(@Path("section") String section,
                                             @Path("period") String period,
                                             @Query("api-key") String apiKey);
}
