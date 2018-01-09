package com.example.trailmobile.app.Views;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.activeandroid.ActiveAndroid;
import com.example.trailmobile.app.Classes.ConnectionManager;
import com.example.trailmobile.app.Classes.DataSource;
import com.example.trailmobile.app.Classes.Factory;
import com.example.trailmobile.app.Classes.FileManager;
import com.example.trailmobile.app.Fragments.EventsFragment;
import com.example.trailmobile.app.Fragments.MapFragment;
import com.example.trailmobile.app.Fragments.OptionsFragment;
import com.example.trailmobile.app.Interfaces.IDataSource;
import com.example.trailmobile.app.Interfaces.IFragment;
import com.example.trailmobile.app.Interfaces.IModel;
import com.example.trailmobile.app.Interfaces.IPresenter;
import com.example.trailmobile.app.Listeners.TabListener;
import com.example.trailmobile.app.Models.Athlete;
import com.example.trailmobile.app.Models.AthleteCategory;
import com.example.trailmobile.app.Models.TrailCompetition;
import com.example.trailmobile.app.Models.TrailEvent;
import com.example.trailmobile.app.Models.ViewPagerAdapter;
import com.example.trailmobile.app.POJO.User;
import com.example.trailmobile.trailmobile.R;

import java.util.List;

public class MainMenuActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private IPresenter presenter;
    private final int PRESENTER_NUMBER = 0;
    private ViewPager viewPager;
    private IDataSource datasource;
    private final int num_tabs = 5;
    private int[] tabIcons = {
            R.mipmap.ic_news,
            R.mipmap.ic_events,
            R.mipmap.ic_map,
            R.mipmap.ic_results,
            R.mipmap.ic_training
    };
    private int[] tabIcons_selected = {
            R.mipmap.ic_news_selected,
            R.mipmap.ic_events_selected,
            R.mipmap.ic_map_selected,
            R.mipmap.ic_results_selected,
            R.mipmap.ic_training_selected,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        datasource = DataSource.getInstance();

        ActiveAndroid.initialize(this);
        // END DADOS FICTICIOS
        setContentView(R.layout.main_menu_activity);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        presenter = Factory.getInstance().createPresenter(0);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(4);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setSelectedTabIndicatorColor(Color.alpha(R.color.transparent));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(new TabListener(tabIcons_selected, tabIcons, viewPager));
        setupTabIcons();

        //onTabSelected();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

    }

    @Override
    protected void onStop() {
        FileManager.exportDB();
        super.onStop();
    }

    private void setupTabIcons() {

        for (int i = 0; i < num_tabs; i++) {
            TextView tab = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
            tab.setCompoundDrawablesWithIntrinsicBounds(0, i == 0 ? tabIcons_selected[i] : tabIcons[i], 0, 0);
            tabLayout.getTabAt(i).setCustomView(tab);
        }

    }

    private void setupViewPager(ViewPager viewPager) {


        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());


        for(int i = 0; i < num_tabs; i++)
            adapter.addFrag(Factory.getInstance().createFragment(i), "");

        /*adapter.addFrag(new OptionsFragment(), "");
        adapter.addFrag(new EventsFragment(), "");
        adapter.addFrag(new MapFragment(), "");*/
       // adapter.addFrag(new OptionsFragment(), "");

        int nr_presenters = 1;
        for(Fragment frag : adapter.getFragments()) {

            IPresenter presenter  = Factory.getInstance().createPresenter(nr_presenters);
            presenter.attachActivity(this);
            ((IFragment) frag).attachPresenter(presenter);

            nr_presenters++;
        }
        viewPager.setAdapter(adapter);
    }

}