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

@Table(name = "Trial_type", id= BaseColumns._ID)
public class TrialType extends Model implements IModel {
    // This is the unique id given by the server
    static final int training  = 5;
    @Column(name = "name")
    public String name;

    @Column(name = "points")
    public int points;

    @Column(name = "description")
    public String description;

    @Column(name = "category")
    public String category;

    @Column(name = "difficulty")
    public int difficulty;

    @Column(name = "bDeleted")
    public int bDeleted;
    // Make sure to have a default constructor for every ActiveAndroid model
    @Column(name = "server_id")
    public long server_id;

    public TrialType(){
        super();
        bDeleted = 0;
    }

    public TrialType( String description, String category, int difficulty){
        super();

        this.description = description;
        this.category = category;
        this.difficulty = difficulty;
        bDeleted = 0;
    }
    public List<TrialType> getAllRows()
    {
        return new Select()
                .from(TrialType.class)
                .execute();
    }

    public TrialType getType(long id)
    {
        return new Select()
                .from(TrialType.class)
                .where("_id = ?", id)
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
