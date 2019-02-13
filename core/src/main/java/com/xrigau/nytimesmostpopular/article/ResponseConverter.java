package com.xrigau.nytimesmostpopular.article;

import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

class ResponseConverter {

    ArticlesResult convert(Response<ApiResponse> apiResponse) {
        if (apiResponse.isSuccessful()) {
            return new ArticlesResult.Success(convertArticles(apiResponse.body().getResults()));
        } else {
            return new ArticlesResult.ServerError(failureReason(apiResponse));
        }
    }

    private String failureReason(Response<ApiResponse> apiResponse) {
        ApiResponse body = apiResponse.body();
        if (body == null) {
            return "Unknown error";
        } else {
            return body.getFault().getFaultstring();
        }
    }

    private List<Article> convertArticles(List<ApiArticle> apiArticles) {
        List<Article> articles = new ArrayList<>();
        for (ApiArticle apiArticle : apiArticles) {
            articles.add(
                    new Article(
                            apiArticle.getId(),
                            apiArticle.getTitle(),
                            apiArticle.getAbstract(),
                            apiArticle.getByline(),
                            apiArticle.getPublishedDate(),
                            apiArticle.getUrl(),
                            getImage(apiArticle, "Large Thumbnail"),
                            getImage(apiArticle, "superJumbo"))
            );
        }
        return articles;
    }

    private Article.Image getImage(ApiArticle apiArticle, String desiredFormat) {
        if (apiArticle.getMedia() == null
                || apiArticle.getMedia().isEmpty()
                || !apiArticle.getMedia().get(0).getType().equals("image")
                || apiArticle.getMedia().get(0).getMediaMetadata() == null
                || apiArticle.getMedia().get(0).getMediaMetadata().isEmpty()) {
            return Article.Image.MISSING;
        }

        for (ApiArticle.ApiMediaMetadata apiMediaMetadata : apiArticle.getMedia().get(0).getMediaMetadata()) {
            if (apiMediaMetadata.getFormat().equals(desiredFormat)) {
                return new Article.Image(apiMediaMetadata.getUrl());
            }
        }
        return new Article.Image(apiArticle.getMedia().get(0).getMediaMetadata().get(0).getUrl());
    }

}
