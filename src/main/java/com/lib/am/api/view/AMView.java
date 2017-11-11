package com.lib.am.api.view;

/**
 * @author sasmi_000
 * @param <M>
 */
public interface AMView<M> {

	int CREATE_MODE = 0;
	int EDIT_MODE = 1;

	/**
	 * 
	 * @return
	 */
	int getMode();

	/**
	 * 
	 */
	void initComponent();

	/**
	 * 
	 */
	void initListener();

	/**
	 * Show the Progressbar
	 */
	void showProgress();

	/**
	 * Hide the Progressbar
	 */
	void hideProgress();

	/**
	 * 
	 * @return
	 */
	boolean validate();

	/**
	 * 
	 * @param model
	 */
	void populateComponent(M model);

	/**
	 * 
	 */
	void destroy();

	/**
	 * 
	 * @param b
	 */
	void setEnable(boolean b);

}
