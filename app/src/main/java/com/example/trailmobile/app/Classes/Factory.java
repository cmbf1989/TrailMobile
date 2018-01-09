package com.example.trailmobile.app.Classes;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.example.trailmobile.app.Fragments.EventsFragment;
import com.example.trailmobile.app.Fragments.MapFragment;
import com.example.trailmobile.app.Fragments.NewsFragment;
import com.example.trailmobile.app.Fragments.OptionsFragment;
import com.example.trailmobile.app.Fragments.ResultsFragment;
import com.example.trailmobile.app.Fragments.TrainingFragment;
import com.example.trailmobile.app.Interfaces.ICompetition;
import com.example.trailmobile.app.Interfaces.IConfiguration;
import com.example.trailmobile.app.Interfaces.IEvent;
import com.example.trailmobile.app.Interfaces.IManager;
import com.example.trailmobile.app.Interfaces.IModel;
import com.example.trailmobile.app.Interfaces.IOrganization;
import com.example.trailmobile.app.Interfaces.IPresenter;
import com.example.trailmobile.app.Interfaces.ITracker;
import com.example.trailmobile.app.Interfaces.IUser;
import com.example.trailmobile.app.Listeners.GpsTracker;
import com.example.trailmobile.app.Models.Athlete;
import com.example.trailmobile.app.Models.ConfigurationManager;
import com.example.trailmobile.app.Models.EventState;
import com.example.trailmobile.app.Models.Organization;
import com.example.trailmobile.app.Models.TrailCompetition;
import com.example.trailmobile.app.Models.TrailEvent;
import com.example.trailmobile.app.Presenters.EventsPresenter;
import com.example.trailmobile.app.Presenters.MainPresenter;
import com.example.trailmobile.app.Presenters.MapPresenter;
import com.example.trailmobile.app.Presenters.NewsPresenter;
import com.example.trailmobile.app.Presenters.OptionsPresenter;
import com.example.trailmobile.app.Presenters.ResultsPresenter;
import com.example.trailmobile.app.Presenters.TrainingPresenter;

/**
 * Created by Cesar Ferreira on 09/03/2016.
 */
public class Factory {

    private static Factory mInstance = null;
    public Factory()
    {

    }

    public static Factory getInstance()
    {
        if(mInstance == null)
        {
            mInstance = new Factory();
        }
        return mInstance;
    }

    public Fragment createFragment(int pos)
    {
        switch (pos) {

            case 0:

                return new OptionsFragment();
            case 1:

                return new EventsFragment();
            case 2:

                return new MapFragment();
            case 3:

                return new ResultsFragment();
            case 4:
                return new TrainingFragment();
            default:

                return null;
        }
    }


    public IOrganization createOrganization()
    {
        return new Organization();
    }

    public IConfiguration createConfiguration()
    {
        return new ConfigurationManager();
    }

    public IModel createModel(String name) throws IllegalAccessException, InstantiationException {
        Class<?> class_type = null;
        IModel model = null;
        try
        {
            class_type = Class.forName("com.example.trailmobile.app.Models."+name);
            model =  (IModel) class_type.newInstance();
        } catch (Exception e) {}

        return model;
    }

    public IModel createTrailCompetition()
    {
        return new TrailCompetition();
    }

    public IModel createTrailEvent()
    {
        return new TrailEvent();
    }

    public IPresenter createPresenter(int type)
    {
        switch(type)
        {
            case 0:
                return new MainPresenter();
            case 1:
                return new NewsPresenter();
            case 2:
                return new EventsPresenter();
            case 3:
                return new MapPresenter();
            case 4:
                return new ResultsPresenter();
            case 5:
                return new TrainingPresenter();
            default:
                return null;
        }
    }


    public ITracker createTracker(Context context)
    {
        return new GpsTracker(context);
    }
    public IManager createTrialManager() {
        return new TrialManager();
    }

    public IEvent createEvent(Context context)
    {
        return new TrailEvent();
    }

    public ICompetition createCompetition()
    {
        return new TrailCompetition();
    }

    public IModel createAthlete()
    {
        return new Athlete();
    }

    public IModel createEventState()
    {
        return new EventState();
    }
}
