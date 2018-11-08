package com.example.hhh.imicmo3.Views;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.hhh.imicmo3.Entities.AccountEntity;
import com.example.hhh.imicmo3.R;
import com.example.hhh.imicmo3.Adapters.CustomViewPager;
import com.example.hhh.imicmo3.Adapters.PagesAdapter;
import com.example.hhh.imicmo3.Views.DeveloperActivity.DeveloperActivity;
import com.example.hhh.imicmo3.Views.InfoUserFragment.InfoUserFragment;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private Toolbar toolbar;
    private CustomViewPager viewPager; // class custom lai viewpager
    private TabLayout tabLayout;
    public static int REQUEST_CODE_LOGIN_REGISTER = 1;
    private InfoUserFragment infoUserFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        setSupportActionBar(toolbar);
        initEvent(viewPager);
        setTabLayout(tabLayout);

    }


    public void initEvent(CustomViewPager viewPager){
        this.viewPager = viewPager;

        viewPager.setOffscreenPageLimit(5);
        PagerAdapter pagerAdapter = new PagesAdapter(getSupportFragmentManager(),this);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(2);
        infoUserFragment = (InfoUserFragment) ((PagesAdapter) pagerAdapter).getItem(4);
        viewPager.addOnPageChangeListener(this);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setPagingEnabled(false); //disable keo trang trong viewpagers
    }



    public void setTabLayout(TabLayout tabLayout) {
        this.tabLayout = tabLayout;
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_video_library_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_business_center_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_home_black_24dp);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_help_black_24dp);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_account_box_black_24dp);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        String s1 = getResources().getString(R.string.Videos);
        String s2 = getResources().getString(R.string.Job_Recruitments);
        String s3 = getResources().getString(R.string.Opening_Scheduler);
        String s4 = getResources().getString(R.string.Introduction);
        String s5 = getResources().getString(R.string.Account);
        String[] titles = {s1, s2, s3, s4, s5};
        String titleChanged = titles[viewPager.getCurrentItem()];
        getSupportActionBar().setTitle(titleChanged);


    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /*
     * Tao menu
     * */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.item,menu);
        return super.onCreateOptionsMenu(menu);
    }

    /*
     * bat su kien menu
     * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Intent intent = new Intent(MainActivity.this, DeveloperActivity.class);
                startActivity(intent);
                return true;
            case R.id.help:
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                alertDialog.setTitle("Version 2.0");
                alertDialog.setMessage("Made by Android-team");
                alertDialog.setNegativeButton("OK", null);
                alertDialog.create().show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*
     * bat su kien back button de thoat app
     * */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(true);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void notifyDataSetChanged() {
        infoUserFragment.notifyDataSetChanged();
    }

}
