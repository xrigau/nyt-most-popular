package com.xrigau.nytimesmostpopular.article;

import com.squareup.moshi.Json;

import java.util.List;

public class ApiResponse {

    @Json(name = "status")
    private String status;
    @Json(name = "copyright")
    private String copyright;
    @Json(name = "num_results")
    private Long numResults;
    @Json(name = "results")
    private List<ApiArticle> results = null;
    @Json(name = "fault")
    private ApiFault fault;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Long getNumResults() {
        return numResults;
    }

    public void setNumResults(Long numResults) {
        this.numResults = numResults;
    }

    public List<ApiArticle> getResults() {
        return results;
    }

    public void setResults(List<ApiArticle> results) {
        this.results = results;
    }

    public ApiFault getFault() {
        return fault;
    }

    public void setFault(ApiFault fault) {
        this.fault = fault;
    }

    public static class ApiFault {

        @Json(name = "faultstring")
        private String faultstring;

        public String getFaultstring() {
            return faultstring;
        }

        public void setFaultstring(String faultstring) {
            this.faultstring = faultstring;
        }
    }
}
