package com.xrigau.nytimesmostpopular.article;

public class Article {

    private final long id;
    private final String title;
    private final String authors;
    private final String publishedDate;
    private final String url;
    private final Image image;

    public Article(long id, String title, String authors, String publishedDate, String url, Image image) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.publishedDate = publishedDate;
        this.url = url;
        this.image = image;
    }

    static class Image {
        static final Image MISSING = new Image("missing");

        private final String url;

        public Image(String url) {

            this.url = url;
        }
    }
}
