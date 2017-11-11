package com.lib.am.api.adapter;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lib.am.api.R;
import com.lib.am.api.model.AMItem;

public class AMGridViewAdapter extends BaseAdapter {
    private Activity context;
    List<AMItem> items;
    public AMGridViewAdapter(Activity context, List<AMItem> items) {
        this.context = context;
        this.items = items;
    }

    public int getCount() {
        return items.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater=context.getLayoutInflater();
		View iconView=inflater.inflate(R.layout.gridview_imageicon, null,true);
		
		ImageView imageView = (ImageView) iconView.findViewById(R.id.icon);
		TextView txtTitle = (TextView) iconView.findViewById(R.id.item_name);
		if (items != null && items.size() > 0) {
			txtTitle.setText(items.get(position).getName());
			imageView.setImageResource(items.get(position).getIcon());
		}
		return iconView;
		
	
    }
}
