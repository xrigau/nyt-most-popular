package com.xrigau.nytimesmostpopular.article;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FailureConverterTest {

    @Test
    public void testConverts() {
        Exception someError = new Exception("Some error");

        ArticlesResult result = new FailureConverter().convert(someError);

        assertEquals(new ArticlesResult.ClientError(someError), result);
    }
}
