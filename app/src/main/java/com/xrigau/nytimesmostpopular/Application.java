package com.xrigau.nytimesmostpopular;

import com.xrigau.nytimesmostpopular.common.Dependencies;
import okhttp3.OkHttpClient;

public class Application extends android.app.Application implements Dependencies {

    private OkHttpClient okHttpClient;

    @Override
    public void onCreate() {
        super.onCreate();
        okHttpClient = new OkHttpClient.Builder()
                .build();
    }

    @Override
    public OkHttpClient provideOkHttpClient() {
        return okHttpClient;
    }
}
