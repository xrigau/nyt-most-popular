package com.xrigau.nytimesmostpopular.details;

import androidx.fragment.app.Fragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.xrigau.nytimesmostpopular.article.Article;
import com.xrigau.nytimesmostpopular.common.ImageLoader;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class AndroidArticleDetailView implements ArticleDetailView {

    private final ImageLoader imageLoader;
    private final ImageView image;
    private final TextView title;
    private final TextView author;
    private final TextView date;
    private final TextView abstractText;
    private final FloatingActionButton floatingActionButton;

    public static ArticleDetailView create(ArticleDetailFragment articleDetailFragment) {
        return new AndroidArticleDetailView(
                ImageLoader.create(),
                image(articleDetailFragment),
                (TextView) articleDetailFragment.getView().findViewById(R.id.article_title),
                (TextView) articleDetailFragment.getView().findViewById(R.id.article_author),
                (TextView) articleDetailFragment.getView().findViewById(R.id.article_date),
                (TextView) articleDetailFragment.getView().findViewById(R.id.article_abstract),
                floatingActionButton(articleDetailFragment)
        );
    }

    private static ImageView image(Fragment articleDetailFragment) {
        boolean isTablet = articleDetailFragment.getResources().getBoolean(R.bool.is_tablet);
        if (isTablet) {
            ImageView image = articleDetailFragment.getView().findViewById(R.id.article_image_tablet);
            image.setVisibility(View.VISIBLE);
            return image;
        } else {
            return articleDetailFragment.getActivity().findViewById(R.id.article_image);
        }
    }

    private static FloatingActionButton floatingActionButton(ArticleDetailFragment articleDetailFragment) {
        boolean isTablet = articleDetailFragment.getResources().getBoolean(R.bool.is_tablet);
        if (isTablet) {
            FloatingActionButton floatingActionButton = articleDetailFragment.getView().findViewById(R.id.fab_tablet);
            floatingActionButton.show();
            return floatingActionButton;
        } else {
            return (FloatingActionButton) articleDetailFragment.getActivity().findViewById(R.id.fab);
        }
    }

    AndroidArticleDetailView(ImageLoader imageLoader, ImageView image, TextView title, TextView author, TextView date, TextView abstractText, FloatingActionButton floatingActionButton) {
        this.imageLoader = imageLoader;
        this.image = image;
        this.title = title;
        this.author = author;
        this.date = date;
        this.abstractText = abstractText;
        this.floatingActionButton = floatingActionButton;
    }

    @Override
    public void show(final Article article, final Listener listener) {
        imageLoader.loadImage(article.getHero().getUrl(), image);
        title.setText(article.getTitle());
        author.setText(article.getAuthors());
        date.setText(article.getPublishedDate());
        abstractText.setText(article.getAbstractText());
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onActionPressed(article);
            }
        });
    }

}
