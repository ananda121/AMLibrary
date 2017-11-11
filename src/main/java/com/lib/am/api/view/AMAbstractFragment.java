package com.lib.am.api.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lib.am.api.exceptions.AMViewNotFoundException;

public abstract class AMAbstractFragment<M> extends AMBaseFragment implements
		AMView<M> {

	private int mode;

	public AMAbstractFragment() {
		this(CREATE_MODE);

	}

	public AMAbstractFragment(int mode) {
		super();
		this.mode = mode;
	}

	@Override
	public void initComponent() {
		// TODO Auto-generated method stub

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,	Bundle savedInstanceState) {
		View view = getMainView(inflater, container);
		if(view == null) {
			throw new AMViewNotFoundException();
		}
		return view;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initComponent();
		initListener();
	}

	protected abstract View getMainView(LayoutInflater inflater, ViewGroup container);

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
