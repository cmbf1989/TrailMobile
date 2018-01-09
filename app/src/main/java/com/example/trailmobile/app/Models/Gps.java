package com.example.trailmobile.app.Models;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.example.trailmobile.app.Interfaces.IModel;

import java.util.List;

/**
 * Created by Cesar Ferreira on 31/03/2016.
 */
@Table(name = "Gps_data", id= BaseColumns._ID)
public class Gps  extends Model implements IModel{


    // This is the unique id given by the server


    @Column(name = "idUserData", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public UserData idUserData;


    @Column(name = "longitude")
    public Float longitude;

    @Column(name = "latitude")
    public Float latitude;

    @Column(name = "altitude")
    public Float altitude;

    @Column(name = "description")
    public String description;

    @Column(name = "time")
    public String time;

    @Column(name = "date")
    public String date;

    @Column(name = "bDeleted")
    public int bDeleted;

    @Column(name = "server_id")
    public long server_id;

    // Make sure to have a default constructor for every ActiveAndroid model

    public Gps(){
        super();
        bDeleted = 0;
    }

    public Gps( Float latitude, Float longitude, Float altitude, String description, UserData idUserData, String time){
        super();
        this.idUserData = idUserData;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.description = description;
        this.time = time;
        bDeleted = 0;

    }
    public static List<Gps> getUserDataById(long id_user_data) {
        // This is how you execute a query
        return new Select()
                .from(Gps.class)
                .where("idUserData = ?", id_user_data)
                .execute();
    }
    public List<Gps> getAll() {
        // This is how you execute a query
        return new Select()
                .from(Gps.class)
                .execute();
    }

    public static void deleteAllById(long id_user_data) {
        // This is how you execute a query
        List<Gps> coordinates = new Select()
                .from(Gps.class)
                .where("idUserData = ?", id_user_data)
                .execute();
        for(Gps coord : coordinates)
            coord.delete();
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
