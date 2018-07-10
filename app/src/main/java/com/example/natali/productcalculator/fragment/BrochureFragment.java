package com.example.natali.productcalculator.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.natali.productcalculator.R;

public class BrochureFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_broshure;

    @Nullable
    public static BrochureFragment getInstance(Context context){

        BrochureFragment fragment = new BrochureFragment();
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_broshure));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
