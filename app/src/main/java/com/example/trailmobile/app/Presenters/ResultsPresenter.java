package com.example.trailmobile.app.Presenters;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.NumberPicker;

import com.example.trailmobile.app.Classes.Factory;
import com.example.trailmobile.app.Classes.TrialManager;
import com.example.trailmobile.app.Interfaces.IConfiguration;
import com.example.trailmobile.app.Interfaces.IDataSource;
import com.example.trailmobile.app.Interfaces.IManager;
import com.example.trailmobile.app.Interfaces.IPresenter;
import com.example.trailmobile.app.Models.ConfigurationManager;
import com.example.trailmobile.trailmobile.R;

/**
 * Created by utilizador on 20/09/2016.
 */
public class ResultsPresenter implements IPresenter {
    private Activity activity;

    private IDataSource datasource;

    public ResultsPresenter()
    {

    }
    @Override
    public void attachActivity(Activity a) {
        activity = a;
    }

    @Override
    public void attachFragment(Fragment a) {

    }

    @Override
    public void attachTrialManager(IManager rep) {

    }



    @Override
    public boolean getCompetitionStatus() {
        return false;
    }

    @Override
    public void startService(int pos, Intent intent) {

    }


    @Override
    public void stopService(int pos, Intent intent) {

    }
}
