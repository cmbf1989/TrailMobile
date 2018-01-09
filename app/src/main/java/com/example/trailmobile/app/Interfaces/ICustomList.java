package com.example.trailmobile.app.Interfaces;

import android.view.View;

/**
 * Created by utilizador on 16/10/2016.
 */
public interface ICustomList {
    int getListLayout();
    String[] getItemNames();
    void handleContent(View rowView, int position);
}
