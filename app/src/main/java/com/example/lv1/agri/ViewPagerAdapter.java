package com.example.lv1.agri;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.lv1.agri.fragments.EarningsFragment;
import com.example.lv1.agri.fragments.LinksFragment;
import com.example.lv1.agri.fragments.WorkFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if(position == 0) {
            fragment = new WorkFragment();
        }
        else if(position == 1) {
            fragment = new EarningsFragment();
        }
        else if(position == 2) {
            fragment = new LinksFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "WORK";
        if(position == 0) {
            title = "WORK";
        }
        else if(position == 1) {
            title = "EARNINGS";
        }
        else if(position == 2) {
            title = "LINKS";
        }
        return title;
    }
}
