package com.example.trailmobile.app.Models;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.example.trailmobile.app.Interfaces.IModel;

/**
 * Created by Cesar Ferreira on 16/04/2016.
 */
@Table(name = "Notification_type", id= BaseColumns._ID)
public class NotificationType extends Model implements IModel
{
    // This is the unique id given by the server
    @Column(name = "name")
    public String name;

    @Column(name = "description")
    public String description;

    @Column(name = "category")
    public String category;

    @Column(name = "priority")
    public int difficulty;

    @Column(name = "bDeleted")
    public int bDeleted;

    @Column(name = "server_id")
    public long server_id;
    // Make sure to have a default constructor for every ActiveAndroid model
    public NotificationType( String description, String category, int difficulty)
    {
        super();

        this.description = description;
        this.category = category;
        this.difficulty = difficulty;
        bDeleted = 0;
    }
    public NotificationType()
    {
        super();
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
        return getId();
    }
}
