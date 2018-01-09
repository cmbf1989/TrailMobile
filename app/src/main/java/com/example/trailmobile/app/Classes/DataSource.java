package com.example.trailmobile.app.Classes;

import com.example.trailmobile.app.Interfaces.IDataSource;
import com.example.trailmobile.app.Models.TrailEvent;

import java.io.InputStreamReader;

/**
 * Created by Cesar Ferreira on 01/04/2016.
 */
public class DataSource implements IDataSource {

    private static DataSource mInstance = null;

    private long event_id = -1;
    private long user_id = -1;
    private long trail_id = -1;
    private long org_id = -1;
    private long user_data_id = -1;
    private boolean competitionStatus = false;
    private InputStreamReader current_file = null;

    public DataSource()
    {

    }

    public static IDataSource getInstance()
    {
        if(mInstance == null)
        {
            mInstance = new DataSource();
        }
        return mInstance;
    }
    @Override
    public long getUserData_id() {
        return user_data_id;
    }

    @Override
    public void setUserData_id(long user_data_id) {
        this.user_data_id = user_data_id;
    }

    @Override
    public long getEvent_id() {
        return event_id;
    }

    @Override
    public long getUser_id() {
        return user_id;
    }

    @Override
    public long getTrail_id() {
        return trail_id;
    }

    @Override
    public long getOrg_Id() {
        return org_id;
    }
    @Override
    public void setEvent_id(long event_id) {
        this.event_id = event_id;
    }
    @Override
    public  void setUser_id(long user_id) {
        this.user_id = user_id;
    }
    @Override
    public void setTrail_id(long trail_id) {
        this.trail_id = trail_id;
    }

    @Override
    public void setOrg_id(long org_id) {
        this.org_id = org_id;
    }


    public void loadEvents()
    {
        TrailEvent event = new TrailEvent();

    }


    public boolean getCompetitionStatus() {
        return competitionStatus;
    }

    public void setCompetitionStatus(boolean competitionStatus) {
        this.competitionStatus = competitionStatus;
    }

    public InputStreamReader getCurrent_file() {
        return current_file;
    }

    public void setCurrent_file(InputStreamReader current_file) {
        this.current_file = current_file;
    }

    //public void
}
