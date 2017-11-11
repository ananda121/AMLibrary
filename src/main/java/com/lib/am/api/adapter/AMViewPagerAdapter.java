package com.lib.am.api.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lib.am.api.exceptions.AMViewNotFoundException;
import com.lib.am.api.model.AMTabPagerItem;
import com.lib.am.api.view.AMBaseFragment;
import com.lib.am.api.view.AMFragment;

import java.util.List;

/**
 * Created by sasmi_000 on 15-Nov-15.
 */
public class AMViewPagerAdapter  extends FragmentPagerAdapter {


    private List<AMTabPagerItem> mTabs;
    public AMViewPagerAdapter(FragmentManager fragmentManager, List<AMTabPagerItem> tabs) {
        super(fragmentManager);
        this.mTabs = tabs;
    }

    public void setDatasource(List<AMTabPagerItem> datasource){
        mTabs = datasource;
        notifyDataSetChanged();
    }

    @Override
    public AMBaseFragment getItem(int i) {
       AMFragment fragnment =  mTabs.get(i).getFragment();
        if(fragnment instanceof AMBaseFragment){
            return (AMBaseFragment)fragnment;
        }else{
            throw new AMViewNotFoundException();
        }
    }

    @Override
    public int getCount() {
        return mTabs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabs.get(position).getTitle();
    }
}
