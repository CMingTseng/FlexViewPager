package com.lany.library;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.SparseArrayCompat;
import android.view.ViewGroup;

public abstract class FlexFragmentPagerAdapter extends FragmentPagerAdapter {
    private SparseArrayCompat<OnScrollTabListener> mScrollTabHolders = new SparseArrayCompat<>();
    private int mNumFragments;

    public FlexFragmentPagerAdapter(FragmentManager fm, int numFragments) {
        super(fm);
        this.mNumFragments = numFragments;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object object = super.instantiateItem(container, position);
        mScrollTabHolders.put(position, (OnScrollTabListener) object);
        return object;
    }

    @Override
    public int getCount() {
        return mNumFragments;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    public SparseArrayCompat<OnScrollTabListener> getScrollTabHolders() {
        return mScrollTabHolders;
    }
}
