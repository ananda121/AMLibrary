package com.lib.am.api.view.component;

import com.lib.am.api.view.AMBaseTabFragment;
import com.lib.am.api.view.AMView;

/**
 * Created by sasmi_000 on 21-Nov-15.
 */
public class AMDefaultTabFragment<M> extends AMBaseTabFragment implements AMView<M> {

    private int mode;

    public AMDefaultTabFragment() {
        this(CREATE_MODE);

    }

    public AMDefaultTabFragment(int mode) {
        super();
        this.mode = mode;
    }

    @Override
    public int getMode() {
        return mode;
    }

    @Override
    public void initComponent() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public void populateComponent(M model) {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void setEnable(boolean b) {

    }
}
