package com.example.trailmobile.app.Interfaces;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by Cesar Ferreira on 09/03/2016.
 */
public interface IPresenter {

    void attachActivity(Activity a);
    void attachFragment(Fragment a);
    void attachTrialManager(IManager rep);
    boolean getCompetitionStatus();
    void startService(int pos, Intent intent);
    void stopService(int pos, Intent intent);
}
