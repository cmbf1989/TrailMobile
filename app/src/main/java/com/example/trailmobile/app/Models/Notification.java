package com.example.trailmobile.app.Models;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.example.trailmobile.app.Interfaces.IModel;

/**
 * Created by Cesar Ferreira on 31/03/2016.
 */
@Table(name = "Notification", id= BaseColumns._ID)
public class Notification  extends Model implements IModel
{

    // This is the unique id given by the server

    @Column(name = "idOrganization", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public Organization idOrganization;

    @Column(name = "idTrial", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public TrailCompetition idTrial;


    @Column(name = "idNotificationType", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public NotificationType idNotificationType;

    @Column(name = "scheduleTime")
    public String scheduleTime;

    @Column(name = "description")
    public Float description;

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
    public Notification( Organization idOrganization, TrailCompetition idTrial, NotificationType idNotificationType, String scheduleTime, Float description, String data, String beginDate, String endDate, int bDeleted)
    {
        super();
        this.idOrganization = idOrganization;
        this.idTrial = idTrial;
        this.idNotificationType = idNotificationType;
        this.scheduleTime = scheduleTime;
        this.description = description;
        this.data = data;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.bDeleted = bDeleted;
    }
    public Notification()
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
