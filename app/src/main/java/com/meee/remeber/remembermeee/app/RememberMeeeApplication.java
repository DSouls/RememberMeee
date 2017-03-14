package com.meee.remeber.remembermeee.app;

import android.app.Application;

//import com.example.jingbin.cloudreader.http.HttpUtils;

/**
 * Created by jingbin on 2016/11/22.
 */

public class RememberMeeeApplication extends Application {

    private static RememberMeeeApplication rememberMeeeApplication;

    public static RememberMeeeApplication getInstance() {
        return rememberMeeeApplication;
    }

    @SuppressWarnings("unused")
    @Override
    public void onCreate() {
        super.onCreate();
        rememberMeeeApplication = this;
        //// TODO: 2017/3/14
//      HttpUtils.getInstance().setContext(getApplicationContext());
    }
}
