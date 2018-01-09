package com.example.trailmobile.app.Models;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;

/**
 * Created by Cesar Ferreira on 16/04/2016.
 */
@Table(name = "user_organization", id= BaseColumns._ID)
public class AthleteOrganization extends Model {
    // This is the unique id given by the server

    // This is an association to another activeandroid model
    @Column(name = "idUser", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public Athlete idUser;

    @Column(name = "server_id")
    public long server_id;

    @Column(name = "idOrganization", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public Organization idOrganization;
    // Make sure to have a default constructor for every ActiveAndroid model
    public AthleteOrganization(){
        super();
    }

    public AthleteOrganization(int remoteId, Athlete idUser, Organization idOrganization){
        super();
        this.idUser = idUser;
        this.idOrganization = idOrganization;
    }

    // Used to return items from another table based on the foreign key
    public List<Athlete> users() {
        return getMany(Athlete.class, "idUser");
    }

    public List<Organization> organizations() {
        return getMany(Organization.class, "idOrganization");
    }
}