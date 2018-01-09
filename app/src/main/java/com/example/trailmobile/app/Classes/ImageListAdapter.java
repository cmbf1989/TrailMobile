package com.example.trailmobile.app.Classes;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.trailmobile.app.Interfaces.ICustomList;
import com.example.trailmobile.app.Interfaces.ListViewCustomAdapter;

/**
 * Created by utilizador on 16/10/2016.
 */
public class ImageListAdapter extends ArrayAdapter<String> implements ListViewCustomAdapter {

    private final Activity context;
    private final ICustomList list_data;

    public ImageListAdapter(Activity context, ICustomList list_data) {
        super(context, list_data.getListLayout(), list_data.getItemNames());
        // TODO Auto-generated constructor stub
        this.list_data = list_data;
        this.context=context;

    }

    public View getView(int position, View view, ViewGroup parent) {
        View rowView = null;
        LayoutInflater inflater = context.getLayoutInflater();
        rowView = inflater.inflate(list_data.getListLayout(), null, true);
        list_data.handleContent(rowView, position);
        return rowView;
    }

}
