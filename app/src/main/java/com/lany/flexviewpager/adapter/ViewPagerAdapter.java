package com.lany.flexviewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.lany.flexviewpager.fragment.DemoListViewFragment;
import com.lany.flexviewpager.fragment.DemoRecyclerViewFragment;
import com.lany.flexviewpager.fragment.FirstScrollViewFragment;
import com.lany.flexviewpager.fragment.SecondScrollViewFragment;
import com.lany.library.FlexFragmentPagerAdapter;

public class ViewPagerAdapter extends FlexFragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm, int numFragments) {
        super(fm, numFragments);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = FirstScrollViewFragment.newInstance(0);
                break;

            case 1:
                fragment = SecondScrollViewFragment.newInstance(1);
                break;

            case 2:
                fragment = DemoListViewFragment.newInstance(2);
                break;

            case 3:
                fragment = DemoRecyclerViewFragment.newInstance(3);
                break;

            default:
                throw new IllegalArgumentException("Wrong page given " + position);
        }
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "标题" + position;
    }
}