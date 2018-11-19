package com.phongtoanhuu.hhh.imicmo3.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.phongtoanhuu.hhh.imicmo3.R;

public class FlashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_screen);

        animation();
        changeIntro();
    }

    private void changeIntro() {
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(FlashScreenActivity.this, IntroActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);
            }
        });
        thread.start();
    }

    private void animation() {
        ImageView imageLogo = findViewById(R.id.logo);

        Animation anim_fadein = AnimationUtils.loadAnimation(this, R.anim.anim_fadein);
        Animation anim_rotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        Animation anim_fadeout = AnimationUtils.loadAnimation(this, R.anim.anim_fadeout);

        AnimationSet set = new AnimationSet(true);

        set.addAnimation(anim_fadein);
        set.addAnimation(anim_rotate);
        set.addAnimation(anim_fadeout);
        imageLogo.startAnimation(set);
    }

}
