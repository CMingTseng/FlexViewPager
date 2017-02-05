package com.lany.library;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;

public class ScrollTabFragment extends Fragment implements OnScrollTabListener {
    protected final String TAG = this.getClass().getSimpleName();
    protected static final String ARG_POSITION = "position";

    protected OnScrollTabListener mOnScrollTabListener;
    protected int mPosition;

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mOnScrollTabListener = (OnScrollTabListener) activity;
        } catch (final ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement ScrollTabHolder");
        }
    }

    @Override
    public void onDetach() {
        mOnScrollTabListener = null;
        super.onDetach();
    }

    @Override
    public void adjustScroll(int scrollHeight, int headerHeight) {
    }

    @Override
    public void onListViewScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount, int pagePosition) {
    }

    @Override
    public void onScrollViewScroll(NestedScrollView view, int x, int y, int oldX, int oldY, int pagePosition) {
    }

    @Override
    public void onRecyclerViewScroll(RecyclerView view, int dx, int dy, int scrollY, int pagePosition) {
    }
}
