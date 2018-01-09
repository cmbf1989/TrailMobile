package com.example.trailmobile.app.Models;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.example.trailmobile.app.Interfaces.IModel;

/**
 * Created by Cesar Ferreira on 31/03/2016.
 */

@Table(name = "Settings", id= BaseColumns._ID)
public class AppSettings extends Model implements IModel {

    @Column(name = "code")
    public String code;

    @Column(name = "name")
    public String name;

    @Column(name= "description")
    public String description;

    @Column(name = "quantity")
    public int quantity;

    @Column(name = "bActive")
    public int bActive;

    @Column(name = "bDeleted")
    public int bDeleted;

    @Column(name = "server_id")
    public long server_id;
    // Make sure to have a default constructor for every ActiveAndroid model

    public AppSettings(){
        super();
        bDeleted = 0;
    }

    public AppSettings( String code, String name, int quantity){
        super();

        this.code = code;
        this.quantity = quantity;
        bDeleted = 0;
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
        return 0;
    }
}
