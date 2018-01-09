package com.example.trailmobile.app.Models;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.example.trailmobile.app.Interfaces.IModel;

import java.util.List;

/**
 * Created by Cesar Ferreira on 16/04/2016.
 */
@Table(name = "Event_type", id= BaseColumns._ID)
public class EventType extends Model implements IModel{
    // This is the unique id given by the server


    @Column(name = "description")
    public String description;

    @Column(name = "category")
    public String category;

    @Column(name = "difficulty")
    public String difficulty;

    @Column(name = "bDeleted")
    public int bDeleted;


    public EventType(){
        super();
        bDeleted = 0;
    }

    public EventType( String description, String category, String difficulty){
        super();

        this.description = description;
        this.category = category;
        this.difficulty = difficulty;
        bDeleted = 0;
    }

    public List<TrailEvent> getTrailEventById(long remoteId) {
        // This is how you execute a query
        return new Select()
                .from(TrailEvent.class)
                .where("idTrial = ?", remoteId)
                .orderBy("id ASC")
                .execute();
    }

    public  List<TrailEvent> getAllEvents()
    {
        return new Select()
                .from(TrailEvent.class)
                .orderBy("id ASC")
                .execute();
    }

    public static List<EventType> getAllRows()
    {
        return new Select()
                .from(EventType.class)
                .execute();
    }

    @Override
    public <S> boolean isCached(S id) {
        return false;
    }

    @Override
    public <S> IModel saveUncached(S data) {
        return null;
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
