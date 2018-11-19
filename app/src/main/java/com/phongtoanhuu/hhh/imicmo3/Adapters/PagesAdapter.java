package com.phongtoanhuu.hhh.imicmo3.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.phongtoanhuu.hhh.imicmo3.Views.InfoUserFragment.InfoUserFragment;
import com.phongtoanhuu.hhh.imicmo3.Views.IntroducesFragment;
import com.phongtoanhuu.hhh.imicmo3.Views.JobRecruimentFragment.JobRecruitmentsFragment;
import com.phongtoanhuu.hhh.imicmo3.Views.OpeningSchedulerFragment.OpeningSchedulerFragment;
import com.phongtoanhuu.hhh.imicmo3.Views.VideoGroupFragment.VideoGroupFragment;

import java.util.ArrayList;
import java.util.List;

public class PagesAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentManagers;

    public PagesAdapter(FragmentManager fm, Context context) {
        super(fm);

        fragmentManagers = new ArrayList<>();
        fragmentManagers.add(new VideoGroupFragment());
        fragmentManagers.add(new JobRecruitmentsFragment());
        fragmentManagers.add(new OpeningSchedulerFragment());
        fragmentManagers.add(new IntroducesFragment());
        fragmentManagers.add(new InfoUserFragment());
    }

    @Override
    public int getCount() {
        return fragmentManagers.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentManagers.get(position);
    }

}
