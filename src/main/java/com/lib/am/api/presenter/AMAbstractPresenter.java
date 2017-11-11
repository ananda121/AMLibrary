package com.lib.am.api.presenter;

import com.lib.am.api.view.AMView;

public abstract class AMAbstractPresenter<M, V extends AMView<M>> implements
		AMPresenter<M, V> {

	public AMAbstractPresenter() {
		initialize();
	}

	@Override
	public void cleanUp() {
		V view = getView();
		if (view != null) {
			view.destroy();
		}
	}

}
