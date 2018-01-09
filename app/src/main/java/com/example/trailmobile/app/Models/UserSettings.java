package com.example.trailmobile.app.Models;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.example.trailmobile.app.Interfaces.IModel;

/**
 * Created by Cesar Ferreira on 16/04/2016.
 */
@Table(name = "User_settings", id= BaseColumns._ID)
public class UserSettings extends Model implements IModel {
    // This is the unique id given by the server

    @Column(name = "idUser", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public Athlete idUser;

    @Column(name = "idSettings", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public AppSettings idSettings;

    @Column(name = "server_id")
    public long server_id;
    // Make sure to have a default constructor for every ActiveAndroid model

    public UserSettings(){
        super();
    }

    public UserSettings( Athlete idUser, AppSettings idSettings){
        super();

        this.idUser = idUser;
        this.idSettings = idSettings;
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
