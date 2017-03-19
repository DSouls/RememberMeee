package com.meee.remeber.remembermeee;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.meee.remeber.remembermeee.app.ConstantsImageUrl;
import com.meee.remeber.remembermeee.databinding.ActivityMainBinding;
import com.meee.remeber.remembermeee.ui.gank.GankFragment;
import com.meee.remeber.remembermeee.ui.menu.NavHomePageActivity;
import com.meee.remeber.remembermeee.utils.ImgLoadUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityMainBinding mBinding;
    private Toolbar toolbar;
    private FrameLayout llTitleMenu;
    private DrawerLayout drawerLayout;
    private ActionBar actionbar;
    private NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initId();
        initListener();
        initDrawerLayout();
        // Initialize action bar with toolbar
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        if(actionbar != null) {
            actionbar.setDisplayShowTitleEnabled(false);
        }
    }

    private void initId() {
        toolbar = mBinding.include.toolbar;
        llTitleMenu = mBinding.include.llTitleMenu;
        drawerLayout = mBinding.drawerLayout;
        navView = mBinding.navView;
    }

    private void initListener() {
        llTitleMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.ll_title_menu :
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.ll_nav_homepage:// 主页
                mBinding.drawerLayout.closeDrawer(GravityCompat.START);
                mBinding.drawerLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        NavHomePageActivity.startHome(MainActivity.this);
                    }
                }, 360);
                break;
            default:
                break;
        }
    }

    private void initDrawerLayout() {
        navView.inflateHeaderView(R.layout.nav_header_main);
        View headerView = navView.getHeaderView(0);

        ImageView ivAvatar = (ImageView) headerView.findViewById(R.id.iv_avatar);
        ImgLoadUtil.displayCircle(ivAvatar, ConstantsImageUrl.IC_AVATAR);

        LinearLayout llNavHomepage = (LinearLayout) headerView.findViewById(R.id.ll_nav_homepage);
        LinearLayout llNavScanDownload = (LinearLayout) headerView.findViewById(R.id.ll_nav_scan_download);
        LinearLayout llNavDeedback = (LinearLayout) headerView.findViewById(R.id.ll_nav_deedback);
        LinearLayout llNavAbout = (LinearLayout) headerView.findViewById(R.id.ll_nav_about);
        LinearLayout llNavExit = (LinearLayout) headerView.findViewById(R.id.ll_nav_exit);
        llNavHomepage.setOnClickListener(this);
        llNavScanDownload.setOnClickListener(this);
        llNavDeedback.setOnClickListener(this);
        llNavAbout.setOnClickListener(this);
        llNavExit.setOnClickListener(this);
    }

    private void initContentFragment() {
        ArrayList<Fragment> mFragments = new ArrayList<>();
        mFragments.add(new GankFragment());
    }

}