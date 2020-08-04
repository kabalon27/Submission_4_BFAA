package com.example.mysubmission4bfaa.page.favorite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mysubmission4bfaa.R;
import com.example.mysubmission4bfaa.adapter.pageadapter.SectionPagerFavoriteAdapter;
import com.example.mysubmission4bfaa.view.viewmovie.MovieFavoriteFragment;
import com.example.mysubmission4bfaa.view.viewtv.TvShowFavoriteFragment;
import com.google.android.material.tabs.TabLayout;

public class FavoriteFragment extends Fragment {
    private TabLayout tabs;
    private int[] tabIcon = {
            R.drawable.baseline_movie_creation_white_24dp,
            R.drawable.baseline_live_tv_white_24dp
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_favorite, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewPager viewPager = view.findViewById(R.id.view_pager_favorite);
        setupViewPager(viewPager);

        tabs = view.findViewById(R.id.tabsFavorite);
        tabs.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        tabs.getTabAt(0).setIcon(tabIcon[0]);
        tabs.getTabAt(1).setIcon(tabIcon[1]);
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionPagerFavoriteAdapter sectionPagerFavoriteAdapter = new SectionPagerFavoriteAdapter(getFragmentManager());

        sectionPagerFavoriteAdapter.addFragment(new MovieFavoriteFragment(), getString(R.string.title_movie_favorite));
        sectionPagerFavoriteAdapter.addFragment(new TvShowFavoriteFragment(), getString(R.string.title_tv_favorite));
        viewPager.setAdapter(sectionPagerFavoriteAdapter);
    }
}