package com.lib.am.api.view;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public abstract class AMBaseActivity extends AppCompatActivity {

	public AMBaseActivity() {
		super();
		initialize();
	}
	
	protected abstract void initialize();
	
	protected void setFragment(Fragment fragment) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.replace(getContent(), fragment);
		fragmentTransaction.commit();
	}

	protected int getContent() {
		return android.R.id.content;
	}

	protected void navigate(Context appCotext, Class<?> clazz) {
		Intent intent = new Intent(appCotext, clazz);
		startActivity(intent);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
}
