package com.example.trailmobile.app.Models;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.example.trailmobile.app.Interfaces.ICompetition;
import com.example.trailmobile.app.Interfaces.IModel;
import com.example.trailmobile.app.POJO.Competition;
import com.example.trailmobile.app.POJO.Event;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by Cesar Ferreira on 25/03/2016.
 */
@Table(name = "Trial", id= BaseColumns._ID)
public class TrailCompetition extends Model implements IModel,ICompetition {

    // This is the unique id given by the server


    @Column(name = "idState", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public TrialState idState;

    @Column(name = "idType", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public TrialType idType;

    @Column(name = "idEvent", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public TrailEvent idEvent;

    @Column(name = "description")
    public String description;

    @Column(name = "data")
    public String data;

    @Column(name = "beginDate")
    public String beginDate;

    @Column(name = "endDate")
    public String endDate;

    @Column(name = "bDeleted")
    public int bDeleted;

    @Column(name = "name")
    public String name;

    @Column(name = "distance")
    public float distance;

    @Column(name = "gpx_src")
    public String gpx_src;

    @Column(name = "coordinate_number")
    public int coordinate_number;

    @Column(name = "server_id")
    public long server_id;
    // Make sure to have a default constructor for every ActiveAndroid model

    public TrailCompetition(){
        super();
        bDeleted = 0;
    }

    public TrailCompetition(String description, TrialState idState, String data, String beginDate, String endDate, TrialType idType){
        super();

        this.idState = idState;
        this.description = description;
        this.data = data;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.idType = idType;
        bDeleted = 0;
    }
    public TrailCompetition getTrailCompetitionById(long remoteId)
    {
        TrailCompetition trail = new Select()
                .from(TrailCompetition.class)
                .where("_id = ?", remoteId)
                .orderBy("id ASC")
                .executeSingle();

        return trail;
    }

    public static float getDistanceById(long id)
    {
        return ((TrailCompetition)
                new Select()
                .from(TrailCompetition.class)
                .where("_id = ?", id)
                .executeSingle()).distance;
    }
    public static List<TrailCompetition> getTrailByEventId(long eventId)
    {
        return  new Select()
                .from(TrailCompetition.class)
                .where("idEvent = ?", eventId)
                .orderBy("name ASC")
                .execute();
    }

    public TrailCompetition getTrailByServerId(long eventId)
    {
        return  new Select()
                .from(TrailCompetition.class)
                .where("server_id = ?", eventId)
                .orderBy("name ASC")
                .executeSingle();
    }
    @Override
    public <S>  boolean isCached(S id) {
        return getTrailByServerId((Long) id) != null;
    }

    @Override
    public <S> IModel saveUncached(S data) {

        Competition event = (Competition) data;
        long server_id = Long.valueOf(event.getCompetitionId());

        if (!isCached(server_id)) {
            this.name = event.getName();
            this.description = event.getLongName();
            this.beginDate = event.getInitDate();
            this.endDate = event.getEndDate();
            float distance = 0;
            try
            {
                NumberFormat format = NumberFormat.getInstance(Locale.ENGLISH);
                Number number = format.parse(event.getTotalDistance());
                distance = number.floatValue();
            } catch (Exception e) {}
            this.distance = distance;
            this.server_id = server_id;
            save();
        } else {
            return  getTrailByServerId(server_id);
        }
        return this;
    }

    @Override
    public <S> IModel saveUncachedList(S data) {
        return null;
    }

    @Override
    public long getModelId() {
        return getId();
    }

    public static List<TrailCompetition> getAll() {
        // This is how you execute a query
        return new Select()
                .from(TrailCompetition.class)
                .where("idType != ",TrialType.training)
                .orderBy("Name ASC")
                .execute();
    }
}

