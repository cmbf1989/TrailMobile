package com.example.trailmobile.app.Models;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by Cesar Ferreira on 16/04/2016.
 */
@Table(name = "User_category", id= BaseColumns._ID)
public class AthleteCategory extends Model {
    // This is the unique id given by the server
    // This is a regular field
    @Column(name = "description")
    public String description;
    @Column(name = "max_age")
    public int max_age;
    @Column(name = "min_age")
    public int min_age;
    @Column(name = "bDeleted")
    public int bDeleted;
    @Column(name = "server_id")
    public long server_id;
    // This is an association to another activeandroid model

    // Make sure to have a default constructor for every ActiveAndroid model
    public AthleteCategory(){
        super();
        bDeleted = 0;
    }

    public AthleteCategory(int remoteId, int min_age, int max_age, String description){
        super();
        this.min_age = min_age;
        this.max_age = max_age;
        this.description = description;
        this.bDeleted = 0;
    }
    public List<AthleteCategory> getAllRows()
    {
        return new Select()
                .from(AthleteCategory.class)
                .execute();
    }
    // Used to return items from another table based on the foreign key
    public List<Athlete> users() {
        return getMany(Athlete.class, "idCategory");
    }


}