package com.example.trailmobile.app.Models;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.example.trailmobile.app.Interfaces.IModel;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

@Table(name = "Gps_trial", id= BaseColumns._ID)
public class GpsTrial  extends Model implements IModel {
    // This is the unique id given by the server

    @Column(name = "idTrial", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public TrailCompetition idTrial;

    @Column(name = "longitude")
    public Float longitude;

    @Column(name = "latitude")
    public Float latitude;

    @Column(name = "altitude")
    public Float altitude;

    @Column(name ="number")
    public int number;

    @Column(name = "description")
    public String description;

    @Column(name = "server_id")
    public long server_id;

    @Column(name = "bDeleted")
    public int bDeleted;


    // Make sure to have a default constructor for every ActiveAndroid model

    public GpsTrial(){
        super();
        bDeleted = 0;
    }


    public static List<GpsTrial> getTrialById(long remoteId) {
        // This is how you execute a query
        return new Select()
                .from(GpsTrial.class)
                .where("idTrial = ?", remoteId)
                .orderBy("number ASC")
                .execute();
    }

    public static List<LatLng> getTrialByIdLatLng(long remoteId) {
        // This is how you execute a query

        List<LatLng> coordinates = new ArrayList<>();
        List<GpsTrial> coordinates_gps = new Select()
                .from(GpsTrial.class)
                .where("idTrial = ?", remoteId)
                .orderBy("number ASC")
                .execute();

        for(GpsTrial coordinate : coordinates_gps)
            coordinates.add(new LatLng(coordinate.latitude,coordinate.longitude));
        coordinates_gps = null;
        return coordinates;
    }

    @Override
    public <S>  boolean isCached(S id) {
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
