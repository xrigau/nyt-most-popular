package com.xrigau.nytimesmostpopular.details;

import androidx.fragment.app.Fragment;
import com.xrigau.nytimesmostpopular.article.Article;
import com.xrigau.nytimesmostpopular.common.ImageLoader;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class ArticleDetailView {

    private final ImageLoader imageLoader;
    private final ImageView image;
    private final TextView title;
    private final TextView author;
    private final TextView date;
    private final TextView abstractText;

    public static ArticleDetailView create(ArticleDetailFragment articleDetailFragment) {
        return new ArticleDetailView(
                ImageLoader.create(),
                image(articleDetailFragment),
                (TextView) articleDetailFragment.getView().findViewById(R.id.article_title),
                (TextView) articleDetailFragment.getView().findViewById(R.id.article_author),
                (TextView) articleDetailFragment.getView().findViewById(R.id.article_date),
                (TextView) articleDetailFragment.getView().findViewById(R.id.article_abstract)
        );
    }

    private static ImageView image(Fragment articleDetailFragment) {
        boolean isTablet = articleDetailFragment.getResources().getBoolean(R.bool.is_tablet);
        if (isTablet) {
            ImageView image = articleDetailFragment.getView().findViewById(R.id.article_image);
            image.setVisibility(View.VISIBLE);
            return image;
        } else {
            return articleDetailFragment.getActivity().findViewById(R.id.article_image);
        }
    }

    ArticleDetailView(ImageLoader imageLoader, ImageView image, TextView title, TextView author, TextView date, TextView abstractText) {
        this.imageLoader = imageLoader;
        this.image = image;
        this.title = title;
        this.author = author;
        this.date = date;
        this.abstractText = abstractText;
    }

    void show(Article article) {
        imageLoader.loadImage(article.getHero().getUrl(), image);
        title.setText(article.getTitle());
        author.setText(article.getAuthors());
        date.setText(article.getPublishedDate());
        abstractText.setText(article.getAbstractText());
    }
}
