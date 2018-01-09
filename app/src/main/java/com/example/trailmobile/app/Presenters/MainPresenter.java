package com.example.trailmobile.app.Presenters;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.trailmobile.app.Classes.TrialManager;
import com.example.trailmobile.app.Interfaces.IDataSource;
import com.example.trailmobile.app.Interfaces.IObserver;
import com.example.trailmobile.app.Interfaces.IPresenter;
import com.example.trailmobile.app.Interfaces.IManager;

/**
 * Created by Cesar Ferreira on 09/03/2016.
 */
public class MainPresenter implements IPresenter,IObserver {

    private Activity activity;
    private IManager repository;
    private IDataSource datasource;

    public MainPresenter()
    {
    }


    @Override
    public void attachActivity(Activity a)
    {
        activity = a;

    }


    @Override
    public void attachFragment(Fragment a) {

    }

    @Override
    public void attachTrialManager(IManager rep) {
        repository = rep;
        repository.attachObserver(this);
    }

    @Override
    public boolean getCompetitionStatus() {
        return ((TrialManager) repository).getCompetitionStatus();
    }

    @Override
    public void startService(int pos, Intent intent) {

    }

    @Override
    public void stopService(int pos, Intent intent) {

    }

    @Override
    public void update() {

    }
}
