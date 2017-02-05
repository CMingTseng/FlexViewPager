package com.lany.library;

import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.ViewPager;
import android.view.View;

public class FlexViewPagerChangeListener implements ViewPager.OnPageChangeListener {
    public final String TAG = this.getClass().getSimpleName();
    protected ViewPager mViewPager;
    protected FlexFragmentPagerAdapter mAdapter;
    protected View mHeader;
    protected int mNumFragments;

    public FlexViewPagerChangeListener(ViewPager viewPager, FlexFragmentPagerAdapter adapter, View headerView) {
        this.mViewPager = viewPager;
        this.mAdapter = adapter;
        this.mNumFragments = mAdapter.getCount();
        this.mHeader = headerView;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int currentItem = mViewPager.getCurrentItem();
        if (positionOffsetPixels > 0) {
            SparseArrayCompat<OnScrollTabListener> scrollTabHolders = mAdapter.getScrollTabHolders();
            OnScrollTabListener fragmentContent;
            if (position < currentItem) {
                // Revealed the previous page
                fragmentContent = scrollTabHolders.valueAt(position);
            } else {
                // Revealed the next page
                fragmentContent = scrollTabHolders.valueAt(position + 1);
            }
            fragmentContent.adjustScroll((int) (mHeader.getHeight() + mHeader.getTranslationY()),mHeader.getHeight());
        }
    }

    @Override
    public void onPageSelected(int position) {
        SparseArrayCompat<OnScrollTabListener> scrollTabHolders = mAdapter.getScrollTabHolders();
        if (scrollTabHolders == null || scrollTabHolders.size() != mNumFragments) {
            return;
        }
        OnScrollTabListener currentHolder = scrollTabHolders.valueAt(position);
        currentHolder.adjustScroll((int) (mHeader.getHeight() + mHeader.getTranslationY()), mHeader.getHeight());
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}
