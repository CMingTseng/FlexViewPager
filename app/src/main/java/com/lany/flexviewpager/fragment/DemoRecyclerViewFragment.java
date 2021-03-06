package com.lany.flexviewpager.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lany.flexviewpager.R;
import com.lany.flexviewpager.adapter.RecyclerAdapter;
import com.lany.library.RecyclerViewFragment;

import java.util.ArrayList;
import java.util.List;


public class DemoRecyclerViewFragment extends RecyclerViewFragment {
    private LinearLayoutManager mLayoutMgr;

    public static Fragment newInstance(int position) {
        DemoRecyclerViewFragment fragment = new DemoRecyclerViewFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mPosition = getArguments().getInt(ARG_POSITION);

        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        setupRecyclerView();
        return view;
    }

    @Override
    protected void setScrollOnLayoutManager(int scrollY) {
        mLayoutMgr.scrollToPositionWithOffset(0, -scrollY);
    }

    private void setupRecyclerView() {
        mLayoutMgr = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutMgr);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter();
        recyclerAdapter.addItems(createItemList());
        mRecyclerView.setAdapter(recyclerAdapter);

        setRecyclerViewOnScrollListener();
    }

    private List<String> createItemList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("Item " + i);
        }
        return list;
    }
}
