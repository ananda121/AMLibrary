package com.lib.am.api.model;

import com.lib.am.api.view.AMFragment;

/**
 * Created by sasmi_000 on 15-Nov-15.
 */
public class AMTabPagerItem {
    private final CharSequence mTitle;
    private final AMFragment mFragment;

    public AMTabPagerItem(CharSequence title, AMFragment fragment) {
        this.mTitle = title;
        this.mFragment = fragment;
    }

    public AMFragment getFragment() {
        return mFragment;
    }

    public CharSequence getTitle() {
        return mTitle;
    }
}
