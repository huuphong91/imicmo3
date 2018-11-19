package com.phongtoanhuu.hhh.imicmo3.Views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.phongtoanhuu.hhh.imicmo3.Adapters.IntroAdatper;
import com.phongtoanhuu.hhh.imicmo3.R;

import me.relex.circleindicator.CircleIndicator;

public class IntroActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private IntroAdatper customPagerAdapter;
    private TextView tvSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        SharedPreferences sharedPreferences = getSharedPreferences("check_first_login", MODE_PRIVATE);
        boolean checkFirstVisit = sharedPreferences.getBoolean("isFirstVisit", true);
        if (checkFirstVisit) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isFirstVisit", false);
            editor.apply();
            builtIntroViewpager();
            setTvSkip();
        } else {
            translateMain();
        }
    }

    private void translateMain() {
        Intent intent = new Intent(IntroActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);
        finish();
    }

    private void setTvSkip() {
        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == ((customPagerAdapter.image_resources.length) - 1)) {
                    tvSkip.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void builtIntroViewpager() {
        viewPager = findViewById(R.id.viewpager);
        customPagerAdapter = new IntroAdatper(this);
        viewPager.setAdapter(customPagerAdapter);
        tvSkip = findViewById(R.id.skip);
        CircleIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);
        customPagerAdapter.registerDataSetObserver(indicator.getDataSetObserver());

        CubeOutRotationTransformation cubeOutRotationTransformation = new CubeOutRotationTransformation();
        viewPager.setPageTransformer(true, cubeOutRotationTransformation);
    }

    private class CubeOutRotationTransformation implements ViewPager.PageTransformer {
        @Override
        public void transformPage(@NonNull View page, float position) {

            if (position < -1) {    // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.setAlpha(0);

            } else if (position <= 0) {    // [-1,0]
                page.setAlpha(1);
                page.setPivotX(page.getWidth());
                page.setRotationY(-90 * Math.abs(position));

            } else if (position <= 1) {    // (0,1]
                page.setAlpha(1);
                page.setPivotX(0);
                page.setRotationY(90 * Math.abs(position));

            } else {    // (1,+Infinity]
                // This page is way off-screen to the right.
                page.setAlpha(0);

            }
        }
    }
}
