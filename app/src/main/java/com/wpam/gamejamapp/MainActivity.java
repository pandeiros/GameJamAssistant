package com.wpam.gamejamapp;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final int TAB_COUNT = 3;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private int[] tabIcons = {
            R.drawable.ic_tab_home,
            R.drawable.ic_tab_games,
            R.drawable.ic_tab_profile,
    };

    private int[] tabTitles = {
            R.string.str_tab_news,
            R.string.str_tab_games,
            R.string.str_tab_profile
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(R.string.str_tab_news);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        for (int i = 0; i < TAB_COUNT; ++i)
        {
            ImageView view = (ImageView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
            view.setImageResource(tabIcons[i]);
            if (i == 0)
                view.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.icons), PorterDuff.Mode.SRC_IN);
            else
                view.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.primary_text), PorterDuff.Mode.SRC_IN);
            tabLayout.getTabAt(i).setCustomView(view);
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment());
//        adapter.addFragment(new EventFragment());
        adapter.addFragment(new GamesFragment());
        adapter.addFragment(new ProfileFragment());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < TAB_COUNT; ++i)
                {
                    ImageView view = (ImageView)tabLayout.getTabAt(i).getCustomView();
                    if (i == position)
                        view.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.icons), PorterDuff.Mode.SRC_IN);
                    else
                        view.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.primary_text), PorterDuff.Mode.SRC_IN);
                    tabLayout.getTabAt(i).setCustomView(view);
                }
                getSupportActionBar().setTitle(tabTitles[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }

        @Override
        public CharSequence getPageTitle(int position) {

            // return null to display only the icon
            return null;

//            return mFragmentTitleList.get(position);
        }
    }
}
