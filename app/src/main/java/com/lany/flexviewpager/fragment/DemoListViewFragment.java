package com.lany.flexviewpager.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lany.flexviewpager.R;
import com.lany.library.ListViewFragment;


public class DemoListViewFragment extends ListViewFragment {

    public static Fragment newInstance(int position) {
        DemoListViewFragment fragment = new DemoListViewFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        mPosition = getArguments().getInt(ARG_POSITION);
        View view = inflater.inflate(R.layout.fragment_list_view, container, false);
        mListView = (ListView) view.findViewById(R.id.listview);
        View placeHolderView = inflater.inflate(R.layout.header_placeholder, mListView, false);
        mListView.addHeaderView(placeHolderView);
        setAdapter();
        return view;
    }

    private void setAdapter() {
        if (getActivity() == null)
            return;
        int size = 50;
        String[] stringArray = new String[size];
        for (int i = 0; i < size; ++i) {
            stringArray[i] = ""+i;
        }
        mListView.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, stringArray));
    }
}
