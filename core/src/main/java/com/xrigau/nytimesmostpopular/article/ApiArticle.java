package com.xrigau.nytimesmostpopular.article;

import com.squareup.moshi.Json;

import java.util.List;

public class ApiArticle {

    @Json(name = "url")
    private String url;
    @Json(name = "adx_keywords")
    private String adxKeywords;
    @Json(name = "column")
    private String column;
    @Json(name = "section")
    private String section;
    @Json(name = "byline")
    private String byline;
    @Json(name = "type")
    private String type;
    @Json(name = "title")
    private String title;
    @Json(name = "abstract")
    private String _abstract;
    @Json(name = "published_date")
    private String publishedDate;
    @Json(name = "source")
    private String source;
    @Json(name = "id")
    private Long id;
    @Json(name = "asset_id")
    private Long assetId;
    @Json(name = "views")
    private Long views;
    @Json(name = "media")
    private List<ApiMedia> media = null;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAdxKeywords() {
        return adxKeywords;
    }

    public void setAdxKeywords(String adxKeywords) {
        this.adxKeywords = adxKeywords;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstract() {
        return _abstract;
    }

    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public List<ApiMedia> getMedia() {
        return media;
    }

    public void setMedia(List<ApiMedia> media) {
        this.media = media;
    }

    public static class ApiMedia {
        @Json(name = "type")
        private String type;
        @Json(name = "subtype")
        private String subtype;
        @Json(name = "caption")
        private String caption;
        @Json(name = "copyright")
        private String copyright;
        @Json(name = "approved_for_syndication")
        private Long approvedForSyndication;
        @Json(name = "media-metadata")
        private List<ApiMediaMetadata> mediaMetadata = null;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public Long getApprovedForSyndication() {
            return approvedForSyndication;
        }

        public void setApprovedForSyndication(Long approvedForSyndication) {
            this.approvedForSyndication = approvedForSyndication;
        }

        public List<ApiMediaMetadata> getMediaMetadata() {
            return mediaMetadata;
        }

        public void setMediaMetadata(List<ApiMediaMetadata> mediaMetadata) {
            this.mediaMetadata = mediaMetadata;
        }
    }

    public static class ApiMediaMetadata {

        @Json(name = "url")
        private String url;
        @Json(name = "format")
        private String format;
        @Json(name = "height")
        private Long height;
        @Json(name = "width")
        private Long width;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public Long getHeight() {
            return height;
        }

        public void setHeight(Long height) {
            this.height = height;
        }

        public Long getWidth() {
            return width;
        }

        public void setWidth(Long width) {
            this.width = width;
        }

    }
}
