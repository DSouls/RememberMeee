package com.meee.remeber.remembermeee.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.meee.remeber.remembermeee.app.RememberMeeeApplication;

/**
 * Created by Alex on 2017/3/14.
 */

public class CommonUtils {
    public static Drawable getDrawable(int resId) {
        //// TODO: 2017/3/14
        return getResources().getDrawable(resId);
    }

    public static Resources getResources() {
        return RememberMeeeApplication.getInstance().getResources();
    }
}
