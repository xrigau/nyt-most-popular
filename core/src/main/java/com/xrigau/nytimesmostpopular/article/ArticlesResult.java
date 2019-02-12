package com.xrigau.nytimesmostpopular.article;

import java.util.List;

public interface ArticlesResult {

    class ServerError implements ArticlesResult {
        private final String reason;

        public ServerError(String reason) {
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }

        @Override
        public String toString() {
            return "ServerError{" +
                    "reason='" + reason + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ServerError that = (ServerError) o;

            return reason.equals(that.reason);
        }

        @Override
        public int hashCode() {
            return reason.hashCode();
        }
    }

    class ClientError implements ArticlesResult {
        private final Throwable throwable;

        public ClientError(Throwable throwable) {
            this.throwable = throwable;
        }

        public Throwable getThrowable() {
            return throwable;
        }

        @Override
        public String toString() {
            return "ClientError{" +
                    "throwable=" + throwable +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ClientError that = (ClientError) o;

            return throwable.equals(that.throwable);
        }

        @Override
        public int hashCode() {
            return throwable.hashCode();
        }
    }

    class Success implements ArticlesResult {
        private final List<Article> articles;

        public Success(List<Article> articles) {
            this.articles = articles;
        }

        public List<Article> getArticles() {
            return articles;
        }

        @Override
        public String toString() {
            return "Success{" +
                    "articles=" + articles +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Success success = (Success) o;

            return articles.equals(success.articles);
        }

        @Override
        public int hashCode() {
            return articles.hashCode();
        }
    }
}
