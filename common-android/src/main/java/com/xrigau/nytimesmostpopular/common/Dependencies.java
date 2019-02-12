package com.xrigau.nytimesmostpopular.common;

import okhttp3.OkHttpClient;

public interface Dependencies {

    OkHttpClient provideOkHttpClient();

}
