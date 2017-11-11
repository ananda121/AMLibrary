package com.lib.am.api.view;

import android.view.View;

public abstract class AMAbstractView<M> implements AMView<M> {

    private int mode;

    public AMAbstractView() {
        this(CREATE_MODE);
    }

    public AMAbstractView( int mode) {
        super();
        this.mode = mode;
    }

    public abstract View getView();

    @Override
    public void initComponent() {
        // TODO Auto-generated method stub

    }

    @Override
    public void initListener() {
        // TODO Auto-generated method stub

    }

    @Override
    public int getMode() {
        return mode;
    }

    @Override
    public void showProgress() {
        // TODO Auto-generated method stub
    }

    @Override
    public void hideProgress() {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean validate() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void populateComponent(M model) {
        // TODO Auto-generated method stub

    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void setEnable(boolean b) {
        // TODO Auto-generated method stub

    }
}
