package com.lib.am.api.view;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lib.am.api.R;
import com.lib.am.api.model.AMItem;
import com.lib.am.api.adapter.AMListViewAdapter;

import java.util.List;

public abstract class AMDrawerActivity extends AMBaseActivity {

    private static final int FIRST_ITEM = 1;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    private ListView menuItemsList;
    private CharSequence drawerTitle;
    private CharSequence title;
    private List<AMItem> menuItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        title = drawerTitle = getTitle();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        menuItemsList = (ListView) findViewById(R.id.left_drawer);

        menuItems = getMenuItems();

        AMListViewAdapter adapter = new AMListViewAdapter(this, menuItems);
        menuItemsList.setAdapter(adapter);
        menuItemsList.setOnItemClickListener(new DrawerItemClickListener());

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = new AMActionBarDrawerToggle(this, /* host Activity */
                drawerLayout, /* DrawerLayout object */
                R.string.drawer_open, /* "open drawer" description */
                R.string.drawer_close /* "close drawer" description */
        );

        drawerLayout.setDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        if (savedInstanceState == null) {
            selectItem(FIRST_ITEM);
        }
    }
    class AMActionBarDrawerToggle extends ActionBarDrawerToggle{

        public AMActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, int openDrawerDesc, int closeDrawerDesc) {
            super(activity, drawerLayout, openDrawerDesc, closeDrawerDesc);
        }

        public void onDrawerClosed(View view) {
            super.onDrawerClosed(view);
            drawerClosed(view);
        }

        public void onDrawerOpened(View view) {
            super.onDrawerOpened(view);
            drawerOpened(view);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if(drawerToggle!=null){
            drawerToggle.syncState();
        }
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    @Override
    public void onBackPressed() {
        selectItem(FIRST_ITEM);
    }

    private void selectItem(int position) {

        AMFragment fragment = getFragment(position);
        boolean added = addFragment(fragment);
        if (added) {
            menuItemsList.setItemChecked(position, true);
            menuItemsList.setSelection(position);
            AMItem amItem = menuItems.get(position - 1);
            resetSelelection(menuItems);
            amItem.setSelected(true);
            setTitle(amItem.getName());
            drawerLayout.closeDrawer(menuItemsList);
        }
    }

    private void resetSelelection(List<AMItem> menuItems) {
        for (AMItem item : menuItems){
            item.setSelected(false);
        }
    }

    public boolean addFragment(AMFragment fragment) {
        boolean added;
        if (fragment instanceof Fragment) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, (Fragment) fragment).commit();
            added = true;
        } else if (fragment instanceof android.support.v4.app.Fragment) {
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, (android.support.v4.app.Fragment) fragment).commit();
            added = true;
        } else {
            Log.e(getLocalClassName(), "Error in creating fragment");
            added = false;
        }
        return added;
    }

    @Override
    public void setTitle(CharSequence title) {
        this.title = title;
        this.drawerTitle = title;
        getSupportActionBar().setTitle(this.title);
    }

    protected void drawerClosed(View view) {
        getSupportActionBar().setTitle(this.title);
    }
    protected void drawerOpened(View view) {
        getSupportActionBar().setTitle(drawerTitle);
    }
    public ListView getMenuItemsList() {
        return menuItemsList;
    }
    protected abstract List<AMItem> getMenuItems();
    protected abstract AMFragment getFragment(int position);
}
