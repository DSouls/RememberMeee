package com.meee.remeber.remembermeee.ui.menu;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.meee.remeber.remembermeee.R;
import com.meee.remeber.remembermeee.databinding.ActivityNavHomePageBinding;
import com.meee.remeber.remembermeee.utils.ShareUtils;
import com.meee.remeber.remembermeee.view.statusbar.StatusBarUtil;

/**
 * Created by Administrator on 2017/3/17.
 */

public class NavHomePageActivity extends AppCompatActivity{
    private ActivityNavHomePageBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_nav_home_page);
        mBinding.toolbar.setTitle("生而为人，对不起");
        StatusBarUtil.setTranslucentForImageView(this, 0, mBinding.toolbar);
        mBinding.fabShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareUtils.share(v.getContext(), R.string.string_share_text);
            }
        });
    }

    public static void startHome(Context context) {
        Intent intent = new Intent(context, NavHomePageActivity.class);
        context.startActivity(intent);
    }
}
