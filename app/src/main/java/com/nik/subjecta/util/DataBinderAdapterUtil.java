package com.nik.subjecta.util;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.nik.subjecta.R;

public class DataBinderAdapterUtil {


    @BindingAdapter({"imageUrl", "img_header"})
    public static void loadImageIntoView(ImageView imageView, String imageURL, boolean isHeader) {

        if (isHeader) {
            imageURL = "https://image.tmdb.org/t/p/w500/" + imageURL;


        } else {
            imageURL = "https://image.tmdb.org/t/p/w200/" + imageURL;

        }


        Log.i("TAG", "loadImageIntoView: " + imageURL);
        Glide.with(imageView)
                .applyDefaultRequestOptions(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
                .load(imageURL)
                .thumbnail(Glide.with(imageView.getContext()).load(R.drawable.loading))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);


    }

}
