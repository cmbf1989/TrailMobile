package com.example.trailmobile.app.Models;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.example.trailmobile.app.Interfaces.IModel;

import java.util.List;

/**
 * Created by Cesar Ferreira on 02/04/2016.
 */
@Table(name = "user_data", id= BaseColumns._ID)
public class UserData extends Model implements IModel{
    // This is the unique id given by the server


    @Column(name = "idUser", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public Athlete idUser;

    @Column(name = "idTrial", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public TrailCompetition idTrial;

    @Column(name = "creationDate")
    public String creationDate;

    @Column(name = "server_id")
    public long server_id;

    // Make sure to have a default constructor for every ActiveAndroid model
    public UserData()
    {
        super();
    }

    public static UserData getUserDataByTrailAndUser(long idUser, long idTrial)
    {
        return new Select()
                .from(UserData.class)
                .where("idUser = ? AND idTrial = ?", idUser, idTrial)
                .executeSingle();
    }

    public static long getUserDataId(long idUser, long idTrial)
    {
        return new Select()
                .from(UserData.class)
                .where("idUser = ? AND idTrial = ?", idUser, idTrial)
                .executeSingle()
                .getId();
    }


    public UserData getUserDataById(long remoteId)
    {
        return new Select()
                .from(UserData.class)
                .where("_id = ?", remoteId)
                .executeSingle();
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
