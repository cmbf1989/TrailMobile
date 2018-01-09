package com.example.trailmobile.app.Listeners;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Chronometer;

import com.example.trailmobile.app.Classes.DataSource;
import com.example.trailmobile.app.Interfaces.IManager;
import com.example.trailmobile.app.Interfaces.IObserver;
import com.example.trailmobile.app.Interfaces.ITracker;
import com.example.trailmobile.app.Models.Gps;
import com.example.trailmobile.app.Models.UserData;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * Created by Cesar Ferreira on 12/03/2016.
 */
public class GpsTracker extends Service implements ITracker,LocationListener,Observable {

    private static final float MIN_DISTANCE_CHANGE_FOR_UPDATES = 0;
    private static final int TIME_UPDATES = 0;
    private Context context;
    private LocationManager locationManager;
    private boolean status;
    private Location location; // location
    private Timer timer;
    private static final int HANDLER_DELAY = 1000*60;
    private Chronometer chronometer;
    private List<IObserver> observers;
    private int elapsed_time = 0;
    private int timeInterval = 1;
    private IManager repository;
    private Handler handler;
    private Runnable runnable;
    private Long chronometer_base;



    public GpsTracker(Context context)
    {

        observers = new ArrayList<>();
        handler = new Handler();
        runnable = new  Runnable() {

            @Override
            public void run() {
                getLocation();
                elapsed_time += timeInterval;
                handler.postDelayed(this, timeInterval*HANDLER_DELAY);
            }
        };
        this.context = context;
        chronometer = null;
    }

    public void attachObserver(IObserver observer)
    {
        observers.add(observer);
    }

    public void detachObserver(IObserver observer)
    {
        observers.remove(observer);
    }

    public void setRepository(IManager rep) {
        repository = rep;
    }

    public Chronometer getChronometer() {
        return chronometer;
    }

    public void setChronometer(Chronometer chrono)
    {
        this.chronometer = chrono;
    }
    public void startTimer(int runtime)
    {

        if(timer != null) return;

        timeInterval = runtime;
        //timer = new Timer();
        //getLocation();
        if(handler == null) return;

        handler.postDelayed(runnable, timeInterval*HANDLER_DELAY);

    }


    public int getTimeInterval() {
        return timeInterval;
    }
    public int getRealTimeInterval() {
        return timeInterval;
    }
    public void setTimeInterval(int timeInterval) {
        this.timeInterval = timeInterval;
    }

    public void stopTimer() {

        if (handler == null) return;

        handler.removeCallbacks(runnable);
        timer = null;
        try {
            if (locationManager != null ) {
                locationManager.removeUpdates(this);
            }
        } catch(Exception e) {

        }

    }

    public void getLocation()
    {


        try {
            locationManager = (LocationManager) context
                    .getSystemService(Context.LOCATION_SERVICE);

            // getting GPS status
            boolean isGPSEnabled = locationManager
                    .isProviderEnabled(LocationManager.GPS_PROVIDER);

            // getting network status
            boolean isNetworkEnabled = locationManager
                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!isGPSEnabled && !isNetworkEnabled) {
                // no network provider is enabled
            } else {

                // First get location from Network Provider
                if (isNetworkEnabled) {
                    locationManager.requestLocationUpdates(
                            LocationManager.NETWORK_PROVIDER,
                            timeInterval*TIME_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                    Log.d("Network", "Network");
                    if (locationManager != null) {
                        location = locationManager
                                .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        updateDatabase(location);
                        return;
                    }
                }
                // if GPS Enabled get lat/long using GPS Services
                if (isGPSEnabled) {
                    if (location == null) {
                        locationManager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                timeInterval*TIME_UPDATES,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        Log.d("GPS Enabled", "GPS Enabled");
                        if (locationManager != null) {
                            location = locationManager
                                    .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            updateDatabase(location);
                            return;
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void updateDatabase(Location location)
    {
        if(location == null) return;

        // ((TrialManager) repository).addLocation(location);
        long user_id = DataSource.getInstance().getUser_id();
        long trial_id = DataSource.getInstance().getTrail_id();
        UserData user_data = UserData.getUserDataByTrailAndUser(user_id, trial_id);

        Gps gps_coordinate = new Gps();

        gps_coordinate.latitude = Float.parseFloat(String.valueOf(location.getLatitude()));
        gps_coordinate.idUserData = user_data;
        gps_coordinate.longitude = Float.parseFloat(String.valueOf(location.getLongitude()));
        gps_coordinate.time = getElapsedTime();
        gps_coordinate.save();

        //System.gc();
        notifyObservers();

    }
    @Override
    public int getTrackerMaxTimer() {
        return 0;
    }

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location loc) {

        if(location != null) {
            System.gc();
            location = loc;
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void notifyObservers() {
        for(IObserver obs : observers)
            obs.update();
    }


    public String getElapsedTime() {

        long base = SystemClock.elapsedRealtime() - chronometer_base;
        String minutes = String.valueOf(TimeUnit.MILLISECONDS.toMinutes(base));
        String seconds = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(base));
        String hours = String.valueOf(TimeUnit.MILLISECONDS.toHours(base));
        return hours + ":" + minutes + ":" + seconds;
    }

    public Long getChronometer_base() {
        return chronometer_base;
    }

    public void setChronometer_base(Long chronometer_base) {
        this.chronometer_base = chronometer_base;
    }
}
