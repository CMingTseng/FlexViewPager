package com.lany.library;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;

public interface OnScrollTabListener {

    void adjustScroll(int scrollHeight, int headerHeight);

    void onListViewScroll(AbsListView listView, int firstVisibleItem, int visibleItemCount, int totalItemCount, int pagePosition);

    void onScrollViewScroll(NestedScrollView scrollView, int x, int y, int oldX, int oldY, int pagePosition);

    void onRecyclerViewScroll(RecyclerView recyclerView, int dx, int dy, int scrollY, int pagePosition);
}
