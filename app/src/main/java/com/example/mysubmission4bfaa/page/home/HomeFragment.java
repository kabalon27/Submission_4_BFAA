package com.example.mysubmission4bfaa.page.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mysubmission4bfaa.R;
import com.example.mysubmission4bfaa.adapter.pageadapter.SectionPagerAdapter;
import com.example.mysubmission4bfaa.view.viewmovie.MovieFragment;
import com.example.mysubmission4bfaa.view.viewtv.TvShowFragment;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {
    private TabLayout tabs;
    private int[] tabIcon = {
            R.drawable.baseline_movie_creation_white_24dp,
            R.drawable.baseline_live_tv_white_24dp
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewPager viewPager = view.findViewById(R.id.view_pager);
        setupViewPager(viewPager);

        tabs = view.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        tabs.getTabAt(0).setIcon(tabIcon[0]);
        tabs.getTabAt(1).setIcon(tabIcon[1]);
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionPagerAdapter sectionPagerAdapter = new SectionPagerAdapter(getFragmentManager());

        sectionPagerAdapter.addFragment(new MovieFragment(), getString(R.string.title_movie));
        sectionPagerAdapter.addFragment(new TvShowFragment(), getString(R.string.title_tv));
        viewPager.setAdapter(sectionPagerAdapter);
    }
}