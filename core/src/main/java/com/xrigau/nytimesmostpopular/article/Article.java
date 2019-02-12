package com.xrigau.nytimesmostpopular.article;

import java.io.Serializable;

public class Article implements Serializable {

    private final long id;
    private final String title;
    private final String abstractText;
    private final String authors;
    private final String publishedDate;
    private final String url;
    private final Image thumbnail;
    private final Image hero;

    public Article(long id, String title, String abstractText, String authors, String publishedDate, String url, Image thumbnail, Image hero) {
        this.id = id;
        this.title = title;
        this.abstractText = abstractText;
        this.authors = authors;
        this.publishedDate = publishedDate;
        this.url = url;
        this.thumbnail = thumbnail;
        this.hero = hero;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAbstractText() {
        return abstractText;
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

    public Image getThumbnail() {
        return thumbnail;
    }

    public Image getHero() {
        return hero;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", abstractText='" + abstractText + '\'' +
                ", authors='" + authors + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", url='" + url + '\'' +
                ", thumbnail=" + thumbnail + '\'' +
                ", hero=" + hero +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (id != article.id) return false;
        if (!title.equals(article.title)) return false;
        if (!abstractText.equals(article.abstractText)) return false;
        if (!authors.equals(article.authors)) return false;
        if (!publishedDate.equals(article.publishedDate)) return false;
        if (!url.equals(article.url)) return false;
        if (!thumbnail.equals(article.thumbnail)) return false;
        return hero.equals(article.hero);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + title.hashCode();
        result = 31 * result + abstractText.hashCode();
        result = 31 * result + authors.hashCode();
        result = 31 * result + publishedDate.hashCode();
        result = 31 * result + url.hashCode();
        result = 31 * result + thumbnail.hashCode();
        result = 31 * result + hero.hashCode();
        return result;
    }

    public static class Image implements Serializable {
        public static final Image MISSING = new Image("missing");

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
