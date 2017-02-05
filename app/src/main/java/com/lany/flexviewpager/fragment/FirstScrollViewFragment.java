package com.lany.flexviewpager.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lany.flexviewpager.R;
import com.lany.library.NestedScrollViewFragment;


public class FirstScrollViewFragment extends NestedScrollViewFragment {

    public static Fragment newInstance(int position) {
        FirstScrollViewFragment fragment = new FirstScrollViewFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        mPosition = getArguments().getInt(ARG_POSITION);
        View view = inflater.inflate(R.layout.fragment_first_scroll_view, container, false);
        mScrollView = (NestedScrollView) view.findViewById(R.id.scrollview);
        return view;
    }
}
