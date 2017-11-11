package com.lib.am.api.presenter;


public interface AMPresenter<M, V> {

    void initialize();

    void initView();

    void initModel();

    M getModel();

    V getView();

    void cleanUp();
}
