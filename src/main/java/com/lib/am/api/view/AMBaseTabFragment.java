package com.lib.am.api.view;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lib.am.api.R;
import com.lib.am.api.adapter.AMViewPagerAdapter;
import com.lib.am.api.model.AMTabPagerItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Sample fragment that contains tabs of other fragments.
 */
public abstract class AMBaseTabFragment extends AMBaseFragment {
    private List<AMTabPagerItem> tabPagerItems = new ArrayList<>();
    private View view;

    public void addTab(String title, AMFragment fragment) {
        tabPagerItems.add(new AMTabPagerItem(title, fragment));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_viewpager, container, false);
        this.view = rootView;
        tabPagerItems.clear();
        initialize();
        return rootView;
    }

    protected void initPager() {

        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
        mViewPager.setOffscreenPageLimit(tabPagerItems.size());
        mViewPager.setAdapter(new AMViewPagerAdapter(getChildFragmentManager(), tabPagerItems));
        TabLayout mSlidingTabLayout = (TabLayout) view.findViewById(R.id.tabLayout);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mSlidingTabLayout.setElevation(15);
        }
        mSlidingTabLayout.setupWithViewPager(mViewPager);
       /* mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });*/
    }
}
