package com.example.trailmobile.app.Listeners;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

/**
 * Created by Cesar Ferreira on 09/03/2016.
 */
public class TabListener implements TabLayout.OnTabSelectedListener {

    private int[] selected;
    private int[] unselected;
    private ViewPager viewPager;

    public TabListener(int[] selected,int[] unselected,ViewPager viewPager) {
        this.selected = selected;
        this.unselected = unselected;
        this.viewPager = viewPager;
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        TextView tab_aux = (TextView) tab.getCustomView();
        tab_aux.setCompoundDrawablesWithIntrinsicBounds(0, selected[tab.getPosition()], 0, 0);
        tab.setCustomView(tab_aux);
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        TextView tab_aux = (TextView) tab.getCustomView();
        tab_aux.setCompoundDrawablesWithIntrinsicBounds(0, unselected[tab.getPosition()], 0, 0);
        tab.setCustomView(tab_aux);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}