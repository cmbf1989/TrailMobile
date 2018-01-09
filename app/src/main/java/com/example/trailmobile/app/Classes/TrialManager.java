package com.example.trailmobile.app.Classes;

import android.location.Location;

import com.example.trailmobile.app.Interfaces.IEvent;
import com.example.trailmobile.app.Interfaces.IObserver;
import com.example.trailmobile.app.Interfaces.IOrganization;
import com.example.trailmobile.app.Interfaces.IManager;
import com.example.trailmobile.app.Interfaces.IUser;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cesar Ferreira on 19/03/2016.
 */
public class TrialManager implements IManager {

    private List<LatLng> locations;
    private List<Location> locations_list;

    private IOrganization organization;
    private IUser user;
    private boolean competition_status = false;
    private List<IObserver> observers;

    private IEvent currentEvent;

    public TrialManager()
    {

        observers = new ArrayList<>();
        locations = new ArrayList<>();
        locations_list = new ArrayList<>();
    }

    public void addLocation(Location location) {
        if (location != null) {

            locations_list.add(location);
            locations.add(new LatLng(location.getLatitude(), location.getLongitude()));
            notifyObservers();
        }
    }

    public List<Location> getLocations() {
        return locations_list;
    }

    public void attachObserver(IObserver obs)
    {
        observers.add(obs);
    }

    public void detachObserver(IObserver obs)
    {
        observers.remove(obs);
    }
    public List<LatLng> getLocationList() {
        return locations;
    }

    @Override
    public void attachOrganization(IOrganization obj) {

    }

    @Override
    public void attachUser(IUser user) {
        this.user = user;
    }

    /*
        Competition status - true ( Modo on ), false ( Modo off)
     */
    public void setCompetitionStatus(boolean b) {
        competition_status = b;
    }

    public boolean getCompetitionStatus()
    {
        return competition_status;
    }

    public void notifyObservers()
    {
        for (IObserver obs : observers) {
            obs.update();
        }
        System.gc();
    }

    public IEvent getCurrentEvent() {
        return currentEvent;
    }

    public void setCurrentEvent(IEvent currentEvent) {
        this.currentEvent = currentEvent;
    }

    public List<IObserver> getObservers() {
        return observers;
    }

    public void setObservers(List<IObserver> observers) {
        this.observers = observers;
    }

    public boolean isCompetition_status() {
        return competition_status;
    }

    public void setCompetition_status(boolean competition_status) {
        this.competition_status = competition_status;
    }

    public IUser getUser() {
        return user;
    }

    public void setUser(IUser user) {
        this.user = user;
    }

    public IOrganization getOrganization() {
        return organization;
    }

    public void setOrganization(IOrganization organization) {
        this.organization = organization;
    }
}
