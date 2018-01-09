package com.example.trailmobile.app.Interfaces;

import java.io.InputStreamReader;

/**
 * Created by Cesar Ferreira on 01/04/2016.
 */
public interface IDataSource
{
    long getEvent_id();
    long getUser_id();
    long getTrail_id();
    long getOrg_Id();
    long getUserData_id();
    void setUserData_id(long user_data_id);
    void setEvent_id(long event_id);
    void setUser_id(long user_id);
    void setTrail_id(long trail_id);
    void setOrg_id(long trail_id);
    boolean getCompetitionStatus();
    void setCurrent_file(InputStreamReader file);
    InputStreamReader getCurrent_file();
}
