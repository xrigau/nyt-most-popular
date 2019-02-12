package com.xrigau.nytimesmostpopular;

import com.xrigau.nytimesmostpopular.article.MostPopularService;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class HttpServiceFactory {

    private final Retrofit retrofit;

    public static HttpServiceFactory create(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
        return new HttpServiceFactory(retrofit);
    }

    HttpServiceFactory(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public MostPopularService createMostPopularService() {
        return retrofit.create(MostPopularService.class);
    }
}
