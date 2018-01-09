package com.example.trailmobile.app.Models;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.example.trailmobile.app.Classes.Factory;
import com.example.trailmobile.app.Interfaces.IEvent;
import com.example.trailmobile.app.Interfaces.IModel;
import com.example.trailmobile.app.POJO.Competition;
import com.example.trailmobile.app.POJO.Event;
import com.example.trailmobile.app.POJO.JsonResponse;
import com.example.trailmobile.app.POJO.MainEvent;
import com.example.trailmobile.app.POJO.Result;

import java.util.List;

/**
 * Created by Cesar Ferreira on 25/03/2016.
 */
@Table(name = "Event", id= BaseColumns._ID)
public class TrailEvent extends Model implements IEvent,IModel {


    @Column(name = "idState", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public EventState idState;


    @Column(name = "idType", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public EventType idType;

    @Column(name = "idOrganization", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public Organization idOrganization;


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

    @Column(name = "server_id")
    public long server_id;

    @Column(name = "name")
    public String name;

    @Column(name = "event_url")
    public String event_url;

    public static List<TrailEvent> getAll() {
        // This is how you execute a query
        return new Select()
                .from(TrailEvent.class)
                .orderBy("Name ASC")
                .execute();
    }


    // Make sure to have a default constructor for every ActiveAndroid model

    public TrailEvent(){
        super();
        bDeleted = 0;
    }

    public TrailEvent( EventState idState, EventType idType, Organization idOrganization, String description, String data, String beginDate, String endDate) {
        super();

        this.idState = idState;
        this.idType = idType;
        this.idOrganization = idOrganization;
        this.description = description;
        this.data = data;
        this.beginDate = beginDate;
        this.endDate = endDate;
        bDeleted = 0;
    }


    @Override
    public <S> boolean isCached(S id) {
        return getEventByServerId((Long) id) != null;
    }

    public TrailEvent getEventByServerId(long eventId)
    {
        return  new Select()
                .from(TrailEvent.class)
                .where("server_id = ?", eventId)
                .orderBy("name ASC")
                .executeSingle();
    }

    @Override
    public <S> IModel saveUncachedList(S data) {

        try {
            JsonResponse events = (JsonResponse) data;
            List<MainEvent> events_result = events.getResult();
            for(MainEvent result : events_result) {

                boolean  not_cached = !isCached(Long.valueOf(result.getTrailEventId()));
                IModel trail_event = Factory.getInstance().createTrailEvent();

                if (not_cached) {
                    trail_event = trail_event.saveUncached(result);
                } else {
                    trail_event = ((TrailEvent)trail_event).getEventByServerId(Long.valueOf(result.getTrailEventId()));
                }

                List<Competition> competitions = result.getCompetition();

                for (Competition competition : competitions ) {
                    IModel trail = Factory.getInstance().createTrailCompetition();
                    TrailCompetition trail_competition = (TrailCompetition) trail.saveUncached(competition);
                    trail_competition.idEvent = (TrailEvent) trail_event;
                    trail_competition.save();

                }

            }
        } catch (Exception e) {
            String a = e.toString();
        }

        return this;

    }

    @Override
    public long getModelId() {
        return getId();
    }

    @Override
    public <S> IModel saveUncached(S data) {
        try {
            MainEvent event = (MainEvent) data;

            name = event.getShortName();
            description = event.getDescription();
            server_id = Long.valueOf(event.getTrailEventId());
            beginDate = event.getInitDate();
            endDate = event.getEndDate();
            event_url = event.getEventUrl();
            idState = (EventState) Factory.getInstance().createEventState().saveUncached(event);
            save();
        }catch (Exception e) {

            String exepc =  e.toString();
            String etes = exepc;
        }

        return this;
    }
}
