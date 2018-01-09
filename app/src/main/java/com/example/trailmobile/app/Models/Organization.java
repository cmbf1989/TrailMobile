package com.example.trailmobile.app.Models;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.example.trailmobile.app.Interfaces.IModel;
import com.example.trailmobile.app.Interfaces.IOrganization;

/**
 * Created by Cesar Ferreira on 14/03/2016.
 */
@Table(name = "Organization", id= BaseColumns._ID)
public class Organization extends Model implements IOrganization,IModel
{


    // This is the unique id given by the server


    // This is an association to another activeandroid model
    @Column(name = "name")
    public String name;

    @Column(name = "email")
    public String email;

    @Column(name = "website")
    public String website;

    @Column(name = "phone")
    public String phone;

    @Column(name = "address")
    public String address;

    @Column(name = "server_id")
    public long server_id;
    // Make sure to have a default constructor for every ActiveAndroid model
    public Organization(){
        super();
    }

    public Organization(String name, String website, String email, String phone)
    {
        super();

        this.name = name;
        this.website = website;
        this.email = email;
        this.phone = phone;

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
