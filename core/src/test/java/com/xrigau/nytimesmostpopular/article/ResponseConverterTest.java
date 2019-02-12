package com.xrigau.nytimesmostpopular.article;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import retrofit2.Response;

import java.util.Collections;

public class ResponseConverterTest {

    private static final ArticlesResult EXPECTED_RESULT = new ArticlesResult.Success(
            Collections.singletonList(
                    new Article(123L, "Title", "Abstract", "Byline", "Date", "Url", Article.Image.MISSING, Article.Image.MISSING)
            )
    );

    @Test
    public void convertsSuccess() {
        Response<ApiResponse> response = Response.success(createApiResponse());

        ArticlesResult result = new ResponseConverter().convert(response);

        assertEquals(EXPECTED_RESULT, result);
    }

    private ApiResponse createApiResponse() {
        ApiArticle apiArticle = new ApiArticle();
        apiArticle.setAbstract("Abstract");
        apiArticle.setByline("Byline");
        apiArticle.setId(123L);
        apiArticle.setTitle("Title");
        apiArticle.setUrl("Url");
        apiArticle.setPublishedDate("Date");
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setResults(Collections.singletonList(apiArticle));
        return apiResponse;
    }
}
