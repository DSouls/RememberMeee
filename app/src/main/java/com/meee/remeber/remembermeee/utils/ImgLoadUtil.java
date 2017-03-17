package com.meee.remeber.remembermeee.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.meee.remeber.remembermeee.R;

/**
 * Created by Administrator on 2017/3/17.
 */

public class ImgLoadUtil {

    public static void displayCircle(ImageView imageView, String imageUrl) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .crossFade(500)
                .error(R.drawable.ic_avatar_default)
                .transform(new GlideCircleTransform(imageView.getContext()))
                .into(imageView);
    }
}
