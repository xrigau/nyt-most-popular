package com.xrigau.nytimesmostpopular.article;

class FailureConverter {
    ArticlesResult convert(Throwable throwable) {
        return new ArticlesResult.ClientError(throwable);
    }
}
