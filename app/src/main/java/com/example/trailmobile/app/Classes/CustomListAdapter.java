package com.example.trailmobile.app.Classes;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trailmobile.trailmobile.R;

/**
 * Created by Cesar Ferreira on 10/03/2016.
 */
public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final int[] imgid;
    private final int[] viewIds;
    private final String[] description;
    private long[] id_element;

    public CustomListAdapter(Activity context, String[] itemname, int[] imgid, int[] viewIds) {
        super(context, R.layout.options_list, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
        this.viewIds = viewIds;
        description = null;
    }

    public CustomListAdapter(Activity context,String[] description, String[] itemname,  int[] viewIds, int list_layout) {
        super(context, list_layout, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.viewIds = viewIds;
        this.description = description;
        imgid = null;
    }
    public View getView(int position,View view,ViewGroup parent) {
        View rowView = null;

        if(imgid != null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.options_list, null, true);
            TextView firstLine = (TextView) rowView.findViewById(R.id.training_name);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
            imageView.setImageResource(imgid[position]);
            firstLine.setText(itemname[position]);
        } else {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.events_list_layout, null, true);
            TextView name_label = (TextView) rowView.findViewById(R.id.event_name);
            TextView description_label = (TextView) rowView.findViewById(R.id.event_description);

            name_label.setText(itemname[position]);
            description_label.setText(description[position]);
        }

        return rowView;
    }


    public long[] getId_element() {
        return id_element;
    }

    public void setId_element(long[] id_element) {
        this.id_element = id_element;
    }
}
