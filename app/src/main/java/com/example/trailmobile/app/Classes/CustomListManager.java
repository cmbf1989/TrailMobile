package com.example.trailmobile.app.Classes;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trailmobile.app.Interfaces.ICustomList;
import com.example.trailmobile.trailmobile.R;

/**
 * Created by utilizador on 16/10/2016.
 */
public class CustomListManager implements ICustomList {

    private int layout;
    private String[] names;
    private int[] imgid;


    public CustomListManager() {
    }

    @Override
    public int getListLayout() {
        return layout;
    }

    @Override
    public String[] getItemNames() {
        return names;
    }

    @Override
    public void handleContent(View rowView, int position) {
        TextView firstLine = (TextView) rowView.findViewById(R.id.training_name);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        imageView.setImageResource(imgid[position]);
        firstLine.setText(names[position]);
    }
}
