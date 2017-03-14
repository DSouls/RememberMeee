package com.meee.remeber.remembermeee.utils;

import android.view.View;

import java.util.Calendar;

/**
 * 避免一秒内多次点击
 */

public abstract class PerfectClickListener implements View.OnClickListener{
    private static final int MIN_CLICK_DELAY_TIME = 1000;
    private long lastClickTime = 0;
    private int id = -1;

    @Override
    public void onClick(View v) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        int mId = v.getId();
        if(id != mId) {
            lastClickTime = currentTime;
            id = v.getId();
            OnNoDoubleClick(v);
            return;
        }
        if(currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            OnNoDoubleClick(v);
        }
    }

    protected abstract void OnNoDoubleClick(View v);

}
