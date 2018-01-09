package com.example.trailmobile.app.Models;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.example.trailmobile.app.Interfaces.IModel;
import com.example.trailmobile.app.POJO.Event;
import com.example.trailmobile.app.POJO.MainEvent;

import java.util.List;

/**
 * Created by Cesar Ferreira on 16/04/2016.
 */
@Table(name = "Event_state", id= BaseColumns._ID)
public class EventState extends Model implements IModel {
    // This is the unique id given by the server

    @Column(name = "name")
    public String name;

    @Column(name = "description")
    public String description;

    @Column(name = "bDeleted")
    public int bDeleted;


    public EventState(){
        super();
        bDeleted = 0;
    }

    public EventState( String description){
        super();

        this.description = description;
        bDeleted = 0;
    }
    public static List<EventState> getAllRows()
    {
        return new Select()
                .from(EventState.class)
                .execute();
    }


    public IModel getTrialByName(String name)
    {
        IModel model = new Select()
                .from(EventState.class)
                .where("name = ?", name)
                .executeSingle();

        return model;
    }
    @Override
    public <S> boolean isCached(S id)
    {
        return  new Select()
                .from(EventState.class)
                .where("name = ?", id)
                .executeSingle() != null;
    }

    @Override
    public <S> IModel saveUncached(S data) {
        MainEvent event = (MainEvent) data;
        String state_name = getStatAlias(event.getStatus());

        if (isCached(state_name)) {
            return getTrialByName(state_name);
        }
        name = state_name;
        save();
        return this;
    }

    public static String getStatAlias(int status)
    {
        switch(status)
        {
            case 0:
                return "unactive";
            case 1:
                return "active";
            default:
                return "unactive";
        }
    }
    @Override
    public <S> IModel saveUncachedList(S data) {
        return null;
    }

    @Override
    public long getModelId() {
        return getId();
    }
}
