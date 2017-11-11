package com.lib.am.api.adapter.GenericAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by sasmi_000 on 17-Nov-15.
 */
public class AMGenericListViewAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<AMViewBuider> items;
    @SuppressWarnings("unchecked")
    public AMGenericListViewAdapter(List items, Context c) {
        this.items = (List) items;
        inflater = LayoutInflater.from(c);
    }
    @Override
    public int getCount() {
        return items.size();
    }
    @Override
    public Object getItem(int position) {
        return items.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return items.get(position).buildView(convertView, inflater, parent); }
}

