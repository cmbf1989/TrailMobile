package com.example.trailmobile.app.Presenters;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.trailmobile.app.Interfaces.IDataSource;
import com.example.trailmobile.app.Interfaces.IManager;
import com.example.trailmobile.app.Interfaces.IPresenter;

/**
 * Created by utilizador on 23/10/2016.
 */
public class TrainingPresenter implements IPresenter {

    private Activity activity;

    private IDataSource datasource;

    public TrainingPresenter() {

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