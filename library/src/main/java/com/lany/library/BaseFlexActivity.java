package com.lany.library;

import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;

public abstract class BaseFlexActivity extends AppCompatActivity implements OnScrollTabListener {
    final String TAG = getClass().getSimpleName();

    protected static final String IMAGE_TRANSLATION_Y = "image_translation_y";
    protected static final String HEADER_TRANSLATION_Y = "header_translation_y";

    protected View mHeader;
    protected ViewPager mViewPager;
    protected FlexFragmentPagerAdapter mAdapter;

    protected int mMinHeaderHeight;
    protected int mHeaderHeight;
    protected int mMinHeaderTranslation;
    protected int mNumFragments;

    protected abstract void initValues();

    protected abstract void scrollHeader(int scrollY);

    protected abstract void setupAdapter();

    protected int getScrollYOfListView(AbsListView view) {
        View child = view.getChildAt(0);
        if (child == null) {
            return 0;
        }

        int firstVisiblePosition = view.getFirstVisiblePosition();
        int top = child.getTop();

        int headerHeight = 0;
        if (firstVisiblePosition >= 1) {
            headerHeight = mHeaderHeight;
        }

        return -top + firstVisiblePosition * child.getHeight() + headerHeight;
    }

    protected void addOnPageChangeListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
                    fragmentContent.adjustScroll((int) (mHeader.getHeight() + mHeader.getTranslationY()), mHeader.getHeight());
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
        });
    }

    @Override
    public void adjustScroll(int scrollHeight, int headerHeight) {
    }

    @Override
    public void onListViewScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount, int pagePosition) {
        if (mViewPager.getCurrentItem() == pagePosition) {
            scrollHeader(getScrollYOfListView(view));
        }
    }

    @Override
    public void onScrollViewScroll(NestedScrollView view, int x, int y, int oldX, int oldY, int pagePosition) {
        if (mViewPager.getCurrentItem() == pagePosition) {
            scrollHeader(view.getScrollY());
        }
    }

    @Override
    public void onRecyclerViewScroll(RecyclerView view, int dx, int dy, int scrollY, int pagePosition) {
        if (mViewPager.getCurrentItem() == pagePosition) {
            scrollHeader(scrollY);
        }
    }
}
