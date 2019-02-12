package com.xrigau.nytimesmostpopular;

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

    public void loadThumbnail(String url, ImageView imageView) {
        picasso.load(url).into(imageView);
    }

}
