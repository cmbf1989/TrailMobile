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


// Tag_type
@Table(name = "Tag_type", id= BaseColumns._ID)
public class TagType extends Model implements IModel
{
    // This is the unique id given by the server

    @Column(name = "name")
    public String name;

    @Column(name = "description")
    public String description;

    @Column(name = "server_id")
    public long server_id;

    // Make sure to have a default constructor for every ActiveAndroid model
    public TagType(){
        super();
    }

    public TagType(int remoteId, String description){
        super();

        this.description = description;
    }

    public List<TagType> getAllRows()
    {
        return new Select()
                .from(EventType.class)
                .execute();
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
