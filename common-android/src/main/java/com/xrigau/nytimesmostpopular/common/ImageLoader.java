package com.xrigau.nytimesmostpopular.common;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageLoader {

    private final Picasso picasso;

    public static ImageLoader create() {
        return new ImageLoader(Picasso.get());
    }

    ImageLoader(Picasso picasso) {
        this.picasso = picasso;
    }

    public void loadThumbnail(String url, final ImageView imageView) {
        picasso.load(url)
                .transform(new CircleTransform())
                .into(imageView);
    }

    public void loadImage(String url, ImageView imageView) {
        picasso.load(url).into(imageView);
    }
}
