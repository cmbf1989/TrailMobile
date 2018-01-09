package com.example.trailmobile.app.Models;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.example.trailmobile.app.Interfaces.IModel;

import java.util.List;

/**
 * Created by Cesar Ferreira on 16/04/2016.
 */
// User_tag
@Table(name = "User_tag", id= BaseColumns._ID)
public class UserTag extends Model implements IModel
{
    // This is the unique id given by the server

    // This is an association to another activeandroid model
    @Column(name = "idUser", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public Athlete idUser;

    @Column(name = "idTagType", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public TagType idTagType;
    // Make sure to have a default constructor for every ActiveAndroid model
    @Column(name = "description")
    public String description;

    @Column(name = "server_id")
    public long server_id;

    @Column(name = "bDeleted")
    public int bDeleted;

    public UserTag(){
        super();
        this.bDeleted = 0;
    }

    public UserTag(int remoteId, Athlete idUser, TagType idTagType, String description){
        super();
        this.idUser = idUser;
        this.idTagType = idTagType;
        this.description = description;
        this.bDeleted = 0;
    }

    // Used to return items from another table based on the foreign key
    public List<Athlete> users() {
        return getMany(Athlete.class, "idUser");
    }

    public List<TagType> tagTypes() {
        return getMany(TagType.class, "idTagType");
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