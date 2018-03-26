package com.chengx.mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.chengx.mvp.base.XFragment;

import java.util.List;

/**
 * 作者: chengx
 * 日期: 2016/10/10.
 * 描述: 通用的PagerAdapter
 */
public class PagerAdapter extends FragmentPagerAdapter {
    private List<XFragment> fragments;

    public PagerAdapter(FragmentManager fm, List<XFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
