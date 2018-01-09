package com.example.trailmobile.app.Presenters;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.widget.Chronometer;
import android.widget.TextView;

import com.example.trailmobile.app.Classes.DataSource;
import com.example.trailmobile.app.Classes.Factory;
import com.example.trailmobile.app.Classes.FileManager;
import com.example.trailmobile.app.Classes.Statistics;
import com.example.trailmobile.app.Interfaces.IDataSource;
import com.example.trailmobile.app.Interfaces.IManager;
import com.example.trailmobile.app.Interfaces.IObserver;
import com.example.trailmobile.app.Interfaces.IPresenter;
import com.example.trailmobile.app.Interfaces.ITracker;
import com.example.trailmobile.app.Listeners.GpsTracker;
import com.example.trailmobile.app.Models.Athlete;
import com.example.trailmobile.app.Models.Gps;
import com.example.trailmobile.app.Models.GpsTrial;
import com.example.trailmobile.app.Models.TrailCompetition;
import com.example.trailmobile.app.Models.UserData;
import com.example.trailmobile.trailmobile.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cesar Ferreira on 09/03/2016.
 */
public class MapPresenter implements IPresenter,IObserver {

    Activity activity;
    private GoogleMap map;
    private IManager repository;
    private ITracker gps_tracker;

    private Long base_elapsed_time;
    private Polyline polyline;

    @Override
    public void attachActivity(Activity a) {
        activity = a;

    }

    @Override
    public void attachFragment(Fragment a) {

    }

    @Override
    public void attachTrialManager(IManager rep) {
        repository = rep;
        repository.attachObserver(this);
    }

    @Override
    public void update()
    {
        if(map == null) return;
        //List<LatLng> currentPath = ((TrialManager) repository).getLocationList();
        IDataSource datasource = DataSource.getInstance();
        long trail_id = datasource.getTrail_id();
        long user_id = datasource.getUser_id();

        Athlete user = new Athlete();
        user.getAthleteById(datasource.getUser_id());
        Gps user_gps = new Gps();

        long user_data_id = UserData.getUserDataId(user_id,trail_id );
        List<Gps> user_coordinates = user_gps.getUserDataById(user_data_id);
        List<LatLng> currentPath = new ArrayList<>();
        for(Gps coordinates : user_coordinates) {
            currentPath.add(new LatLng(coordinates.latitude, coordinates.longitude));
        }
        if(currentPath.size() > 0) {
            map.clear();
            addPolylineUser(currentPath,Color.rgb(34, 139, 34), 20.0f, false);
        }
        List<LatLng> trail_points = drawTrialMap();
        if(trail_points != null && trail_points.size() > 0) {
            addPolylineCompetition(trail_points, Color.rgb(51, 122, 183), 30.0f, true);
        } else {
            // No coordinate maps in database nothing to load
        }
        GpsTracker current_gps = ((GpsTracker) gps_tracker);
        Double speed = Statistics.getAvgSpeed(currentPath, current_gps.getRealTimeInterval());
       // String time_spent = user_coordinates.get(user_coordinates.size()-1).time;
        float distance_left = TrailCompetition.getDistanceById(trail_id);
        int distance_run =  Statistics.distance(currentPath.get(currentPath.size()-1),currentPath.get(0)).intValue();
        TextView speed_label = (TextView) activity.findViewById(R.id.speed_label);

        TextView distance_label = (TextView) activity.findViewById(R.id.distance);

        distance_label.setText(distance_run+"/"+ distance_left+ " metro(s)");
        speed_label.setText(String.format("%.2f",speed) + " m/s");
        if (distance_run > (distance_left + 100)) {
            // Terminou;
        }
        System.gc();
    }

    public void attachMap(GoogleMap map)
    {
        if(map == null) return;
        this.map = map;
       // addPolylineCompetition(drawTrialMap(), Color.rgb(51, 122, 183), 30.0f, true);
    }


    public void addPolylineUser(List<LatLng> currentPath,int pathColor, float width, boolean startEnd)
    {
        if(map == null) return;


        // map.addMarker( new MarkercurrentPath.get(currentPath.size()-1));
        int points_nr = currentPath.size();
        if(currentPath.size() < 1) return;


        PolylineOptions rectOptions = new PolylineOptions();
        rectOptions.addAll(currentPath);
        rectOptions.width(width);
        rectOptions.color(pathColor);

        Polyline polyline = map.addPolyline(rectOptions);
        LatLng last_point = currentPath.get(points_nr - 1);
        LatLng first_point = currentPath.get(0);


        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(last_point, 35);
        map.animateCamera(cameraUpdate);


    }

    public void addPolylineCompetition(List<LatLng> currentPath,int pathColor, float width, boolean startEnd)
    {
       // map.addMarker( new MarkercurrentPath.get(currentPath.size()-1));
        int points_nr = currentPath.size();
        if(currentPath.size() < 1) return;


        PolylineOptions rectOptions = new PolylineOptions();
        rectOptions.addAll(currentPath);
        rectOptions.width(width);
        rectOptions.color(pathColor);

        Polyline polyline = map.addPolyline(rectOptions);
        LatLng last_point = currentPath.get(points_nr - 1);
        LatLng first_point = currentPath.get(0);

        map.addMarker(new MarkerOptions()
                .position(first_point)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                .title("Início"));
        map.addMarker(new MarkerOptions()
                .position(last_point)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                .title("Fim"));

    }


    public void stopService(int pos, Intent intent)
    {
        Intent intent_current = new Intent(activity,GpsTracker.class);
        if(gps_tracker == null) return;
        switch(pos)
        {
            case -1:
                break;
            default:
                activity.stopService(intent_current);
                //startCompetition();
        }
    }


    public void startService(int pos, Intent intent)
    {
        Intent intent_current = new Intent(activity,GpsTracker.class);
        if(gps_tracker == null) return;
        switch(pos)
        {
            case -1:
                break;
            default:
                activity.startService(intent_current);
              //  startCompetition();
        }
    }


    public String[] startCompetition()
    {
        IDataSource datasource = DataSource.getInstance();
        long trail_id = datasource.getTrail_id();

        if (trail_id > 0 ) {

            gps_tracker = Factory.getInstance().createTracker(activity.getBaseContext());
            //((GpsTracker) gps_tracker).setRepository(repository);
            gps_tracker.setStatus(true);
            ((GpsTracker) gps_tracker).setChronometer(((Chronometer) activity.findViewById(R.id.time_spent)));
            ((GpsTracker) gps_tracker).attachObserver(this);
            ((GpsTracker) gps_tracker).startTimer(1);
            base_elapsed_time = startChronometer();
            ((GpsTracker) gps_tracker).setChronometer_base(base_elapsed_time);
            List<LatLng> trail_points = drawTrialMap();
            FileManager.exportDB();

            if(trail_points != null && trail_points.size() > 0) {
                addPolylineCompetition(trail_points, Color.rgb(51, 122, 183), 30.0f, true);
            } else {
                // No coordinate maps in database nothing to load
            }
                return new String[] {"success"};
            } else {
                return new String[] {"fail","Por favor escolha a sua prova primeiro"};
            }


    }

    public List<LatLng> drawTrialMap()
    {

        TrailCompetition trial = TrailCompetition.load(TrailCompetition.class, DataSource.getInstance().getTrail_id());
        GpsTrial gps_coordinates = new GpsTrial();

        List<LatLng> funduras_gps_list =  gps_coordinates.getTrialByIdLatLng(DataSource.getInstance().getTrail_id());
        //FileManager.parseGpxToList(ConnectionManager.readFileServer(trial.gpx_src), activity);
        return funduras_gps_list;
    }


    public void stopCompetition()
    {
        IDataSource datasource = DataSource.getInstance();
        //((TrialManager) repository).setCompetitionStatus(false);
        gps_tracker.setStatus(false);
        ((GpsTracker) gps_tracker).stopTimer();
        stopChronometer();
        gps_tracker = null;
        Gps.deleteAllById(UserData.getUserDataId(datasource.getUser_id(), datasource.getTrail_id()));
        TrailCompetition trail = TrailCompetition.load(TrailCompetition.class, datasource.getTrail_id());
        trail.coordinate_number = 0;
        trail.save();
        System.gc();
    }

    public Chronometer getCurrentChronometer()
    {
        if(gps_tracker != null) return ((GpsTracker) gps_tracker).getChronometer();

        return null;
    }
    public Long startChronometer() {

        Chronometer mChronometer = (Chronometer) activity.findViewById(R.id.time_spent);
        Long elapsedTime = SystemClock.elapsedRealtime();
        mChronometer.setBase(elapsedTime);
        mChronometer.start();
        return elapsedTime;
    }

    public long getElapsedTime() {
        return SystemClock.elapsedRealtime() - ((Chronometer)activity.findViewById(R.id.time_spent)).getBase();
    }

    public void stopChronometer() {
        ((Chronometer) activity.findViewById(R.id.time_spent)).stop();
    }
    @Override
    public boolean getCompetitionStatus() {

        if(gps_tracker == null) return false;

        return gps_tracker.getStatus();
    }

    public Long getBase_elapsed_time() {
        if(gps_tracker != null) return 0l;

        return ((GpsTracker) gps_tracker).getChronometer_base();
    }
}
