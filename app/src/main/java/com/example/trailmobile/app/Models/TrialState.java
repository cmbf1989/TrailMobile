package com.example.trailmobile.app.Models;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.example.trailmobile.app.Interfaces.IModel;
import com.example.trailmobile.app.POJO.Competition;
import com.example.trailmobile.app.POJO.Event;

import java.util.List;

/**
 * Created by Cesar Ferreira on 16/04/2016.
 */
@Table(name = "Trial_state", id= BaseColumns._ID)
public class TrialState extends Model implements IModel {
    // This is the unique id given by the server


    @Column(name = "description")
    public String description;

    @Column(name = "name")
    public String name;

    @Column(name = "bDeleted")
    public int bDeleted;

    public TrialState(){
        super();
        bDeleted = 0;
    }

    public TrialState(String description){
        super();

        this.description = description;
        bDeleted = 0;
    }
    public List<TrialState> getAllRows()
    {
        return new Select()
                .from(TrialState.class)
                .execute();
    }

    public IModel getTrialByName(String name)
    {
        IModel model = new Select()
                .from(TrialState.class)
                .where("name = ?", name)
                .executeSingle();

        return model;
    }
    @Override
     public <S> boolean isCached(S id)
    {
        return  new Select()
            .from(TrialState.class)
            .where("name = ?", id)
            .executeSingle() != null;
    }

    @Override
    public <S> IModel saveUncached(S data) {
        Competition event = (Competition) data;
        String state_name = getStatAlias(event.getActive());

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