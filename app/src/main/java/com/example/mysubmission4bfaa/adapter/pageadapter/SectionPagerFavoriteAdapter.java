package com.example.mysubmission4bfaa.adapter.pageadapter;

import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SectionPagerFavoriteAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragment = new ArrayList<>();
    private List<String> mTitleFragment = new ArrayList<>();

    public SectionPagerFavoriteAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    public void addFragment(Fragment fragment, String title) {
        mFragment.add(fragment);
        mTitleFragment.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleFragment.get(position);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }
}
