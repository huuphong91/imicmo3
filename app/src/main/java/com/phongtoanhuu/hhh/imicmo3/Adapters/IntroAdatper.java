package com.phongtoanhuu.hhh.imicmo3.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.phongtoanhuu.hhh.imicmo3.R;

public class IntroAdatper  extends PagerAdapter {
    public int[] image_resources = {R.drawable.introscreen1,R.drawable.introscreen2,R.drawable.introscreen3,R.drawable.introscreen4,R.drawable.introscreen5};
    private Context context;

    public IntroAdatper(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ImageView imageView = new ImageView(context);
        imageView.setImageResource(image_resources[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
