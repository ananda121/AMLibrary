package com.lib.am.api.view;

import android.os.Bundle;

import com.lib.am.api.presenter.AMPresenter;

public abstract class AMAbstractActivity<M, V extends AMView<M>, P extends AMPresenter<M, V>> extends AMBaseActivity {

	protected P presenter;
	
	public AMAbstractActivity() {
		super();
		initialize();
	}
	
	protected abstract void initialize();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (presenter == null) {
			throw new IllegalStateException("Presenter must not be null!");
		}
	}
	
	protected abstract P getPresenter();

	@Override
	protected void onDestroy() {
		presenter.cleanUp();
		super.onDestroy();
	}
	

}
