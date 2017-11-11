package com.lib.am.api.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lib.am.api.R;
import com.lib.am.api.model.AMItem;

import java.util.List;

public class AMListViewAdapter extends ArrayAdapter<AMItem> {

	private final Activity context;
	List<AMItem> items;

	public AMListViewAdapter(Activity context, List<AMItem> items) {
		super(context, R.layout.listview_imageicon, items);
		this.context = context;
		this.items = items;
	}

	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.listview_imageicon, null, true);

		ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
		TextView txtTitle = (TextView) rowView.findViewById(R.id.item_name);

		if (items != null && items.size() > 0) {
			AMItem item = items.get(position);
			if (item != null) {
				txtTitle.setText(item.getName());
				if(item.isSelected()) {
					imageView.setImageResource(item.getSelectedIcon());
					txtTitle.setTextColor(context.getResources().getColor(R.color.list_item_title_selected));
				}else{
					imageView.setImageResource(item.getIcon());
					txtTitle.setTextColor(context.getResources().getColor(R.color.list_item_title));
				}
			}
		}
		return rowView;

	}

}
