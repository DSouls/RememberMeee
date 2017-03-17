package com.meee.remeber.remembermeee.utils;

import android.content.Context;
import android.content.Intent;

import com.meee.remeber.remembermeee.R;

/**
 * Created by Administrator on 2017/3/17.
 */

public class ShareUtils {
    public static void share(Context context, int resId) {
        share(context, context.getString(resId));
    }

    public static void share(Context context, String extraText) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, R.string.action_share);
        intent.putExtra(Intent.EXTRA_TEXT, extraText);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(
                Intent.createChooser(intent, context.getString(R.string.action_share))
        );
    }
}
