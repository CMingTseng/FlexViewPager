package com.lany.library;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.util.Log;

public class NestedScrollViewFragment extends ScrollTabFragment {
    protected static final int NO_SCROLL_X = 0;
    protected NestedScrollView mScrollView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView view, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Log.d(TAG, "position " + mPosition);
                if (mOnScrollTabListener != null) {
                    mOnScrollTabListener.onScrollViewScroll(view, scrollX, scrollY, oldScrollX, oldScrollY, mPosition);
                }
            }
        });
    }

    @Override
    public void adjustScroll(int scrollHeight, int headerHeight) {
        if (mScrollView == null)
            return;

        mScrollView.scrollTo(NO_SCROLL_X, headerHeight - scrollHeight);

        if (mOnScrollTabListener != null) {
            mOnScrollTabListener.onScrollViewScroll(mScrollView, 0, 0, 0, 0, mPosition);
        }
    }
}
