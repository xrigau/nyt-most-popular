package com.xrigau.nytimesmostpopular.article;

import java.io.Serializable;

public class Article implements Serializable {

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

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getUrl() {
        return url;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", url='" + url + '\'' +
                ", image=" + image +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (id != article.id) return false;
        if (!title.equals(article.title)) return false;
        if (!authors.equals(article.authors)) return false;
        if (!publishedDate.equals(article.publishedDate)) return false;
        if (!url.equals(article.url)) return false;
        return image.equals(article.image);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + title.hashCode();
        result = 31 * result + authors.hashCode();
        result = 31 * result + publishedDate.hashCode();
        result = 31 * result + url.hashCode();
        result = 31 * result + image.hashCode();
        return result;
    }

    public static class Image implements Serializable {
        static final Image MISSING = new Image("missing");

        private final String url;

        public Image(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        @Override
        public String toString() {
            return "Image{" +
                    "url='" + url + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Image image = (Image) o;

            return url.equals(image.url);
        }

        @Override
        public int hashCode() {
            return url.hashCode();
        }
    }
}
