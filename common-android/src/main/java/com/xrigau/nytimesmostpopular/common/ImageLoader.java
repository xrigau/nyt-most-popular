package com.xrigau.nytimesmostpopular.common;

import com.squareup.picasso.Picasso;

import android.widget.ImageView;

public class ImageLoader {

    private final Picasso picasso;

    public static ImageLoader create() {
        return new ImageLoader(Picasso.get());
    }

    ImageLoader(Picasso picasso) {
        this.picasso = picasso;
    }

    public void loadImage(String url, ImageView imageView) {
        picasso.load(url).into(imageView);
    }

}
