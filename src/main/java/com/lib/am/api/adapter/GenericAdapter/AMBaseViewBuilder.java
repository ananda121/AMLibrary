package com.lib.am.api.adapter.GenericAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Field;

/**
 * Created by sasmi_000 on 18-Nov-15.
 */
public abstract class AMBaseViewBuilder<VH, E > implements AMViewBuider {
    private static final String TAG = "AMBaseViewBuilder";
    protected int layoutId;
    protected VH viewHolder;
    protected E entity;
    public AMBaseViewBuilder(){
    }

    public AMBaseViewBuilder(E entity, int layoutId){
        this.entity = entity;
        this.layoutId = layoutId;
    }
    protected void invokeView(View v){
        try {
            Field fs[] = viewHolder.getClass().getFields();
            for (Field f : fs) {
                InvokeView a = (InvokeView)
                        f.getAnnotation(InvokeView.class);
                int id = a.viewId();
                Log.d(TAG, "field name: " + f.getName());
                Log.d(TAG, "view id: " + id);
                Log.d(TAG, "class: " + f.getClass());
                f.set(viewHolder, v.findViewById(id));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public View buildView(View v, LayoutInflater inflater, ViewGroup parent) {
        // load the view
        if (null == v) {
            v = inflater.inflate(layoutId, parent, false);
            // get the view
            invokeView(v);
            v.setTag(viewHolder);
        } else {
            viewHolder = (VH) v.getTag();
        }
        // binding logic data to view
        mappingData(viewHolder, entity);
        return v;
    }

    protected abstract void mappingData(VH viewHolder, E entity);
}