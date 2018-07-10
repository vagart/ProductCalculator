package com.example.natali.productcalculator.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.natali.productcalculator.fragment.AbstractTabFragment;
import com.example.natali.productcalculator.fragment.BrochureFragment;
import com.example.natali.productcalculator.fragment.CutawaceFragment;

import java.util.HashMap;
import java.util.Map;

public class TabsFragmentAdapter extends FragmentPagerAdapter {
    private Map<Integer,AbstractTabFragment> tabs;
    private Context context;
    private CutawaceFragment cutawaceFragment;
    private BrochureFragment brochureFragment;

    public TabsFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;

        initTabsMap(context);
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabsMap(Context context) {

        cutawaceFragment = CutawaceFragment.getInstance(context);
        brochureFragment = BrochureFragment.getInstance(context);
        tabs = new HashMap<>();
        tabs.put(0, cutawaceFragment);
        tabs.put(1,brochureFragment);

    }
}
