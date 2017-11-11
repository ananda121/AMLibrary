package com.lib.am.api.view;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

public class AMBaseFragment extends Fragment implements AMFragment{

	public AMBaseFragment() {
		super();
	}

	@Override
	public void initialize() {

	}

	protected void navigate(Context appCotext, Class<?> clazz) {
		Activity activity = getActivity();
		if(activity instanceof AMBaseActivity){
			((AMBaseActivity) activity).navigate(appCotext, clazz);
		}
	}

}
