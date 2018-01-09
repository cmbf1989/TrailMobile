package com.example.trailmobile.app.Presenters;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.example.trailmobile.app.Classes.DataSource;
import com.example.trailmobile.app.Classes.FileManager;
import com.example.trailmobile.app.Interfaces.IDataSource;
import com.example.trailmobile.app.Interfaces.IManager;
import com.example.trailmobile.app.Interfaces.IObserver;
import com.example.trailmobile.app.Interfaces.IPresenter;
import com.example.trailmobile.app.Models.GpsTrial;
import com.example.trailmobile.app.Models.TrailCompetition;
import com.example.trailmobile.app.Models.TrailEvent;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Cesar Ferreira on 09/03/2016.
 */
public class EventsPresenter implements IPresenter,IObserver {

    private Activity activity;
    private final OkHttpClient client = new OkHttpClient();
    String message_server;

    public EventsPresenter() {
        message_server = "";
    }


    @Override
    public void attachActivity(Activity a) {
        activity = a;
    }

    @Override
    public void attachFragment(Fragment a) {

    }

    @Override
    public void attachTrialManager(IManager rep) {

    }

    @Override
    public boolean getCompetitionStatus() {
        return true;
    }

    @Override
    public void startService(int pos, Intent intent) {

    }

    @Override
    public void stopService(int pos, Intent intent) {

    }

    @Override
    public void update() {

    }

    public Object[] getEvents() {
        TrailEvent trailEvent = new TrailEvent();
        List<TrailEvent> events = trailEvent.getAll();
        int size = events.size();
        if(size == 0) return null;
        String[] name = new String[size];
        String[] description = new String[size];
        long[] ids = new long[size];
        int iterator = 0;
        for(TrailEvent event : events) {
            name[iterator] = event.name;
            description[iterator] = event.description;
            ids[iterator] = event.getId();
            iterator++;
        }

        return new Object[] {name,description,ids};
    }

    public List<TrailCompetition> getTrialsFromEvent(long idEvent) {
        return TrailCompetition.getTrailByEventId(idEvent);
    }

    public Object[] getTrials(long event_id) {
       // TrailCompetition trails = new TrailCompetition();
        List<TrailCompetition> trail_competitions = TrailCompetition.getTrailByEventId(event_id);
        int size = trail_competitions.size();
        if(size == 0) return null;
        String[] name = new String[size];
        String[] description = new String[size];
        long[] ids = new long[size];
        int iterator = 0;
        for(TrailCompetition trial : trail_competitions) {
            name[iterator] = trial.name;
            description[iterator] = trial.description;
            ids[iterator] = trial.getId();
            iterator++;
        }
        return new Object[] {name,description,ids};
    }
    public boolean loadTrialTrack(long id) {
        TrailCompetition trial = TrailCompetition.load(TrailCompetition.class,id);
        //FileManager.parseGpxToList( new ConnectionManager().readFileServer(trial.gpx_src), activity);
        DataSource.getInstance().setTrail_id(id);
        return true;
    }

    public String getPathFileFromServer(final long trial_id) throws Exception
    {
        String message = "No message.";

        final TrailCompetition trail = TrailCompetition.load(TrailCompetition.class, trial_id);
        List<GpsTrial> trial_coordinates = GpsTrial.getTrialById(trial_id);
        boolean hasMap = trail.coordinate_number != 0 && trail.coordinate_number == trial_coordinates.size() ;
        if (hasMap) {
            DataSource.getInstance().setTrail_id(trial_id);
            Toast toast = Toast.makeText(activity.getBaseContext(),"O mapa carregado com sucesso... ", Toast.LENGTH_LONG);
            toast.show();
            return "Ficheiro carregado com sucesso...";
        }

            String[] url_splitted = trail.gpx_src.split("/");
            String get = url_splitted[url_splitted.length -1];
            int size_url = trail.gpx_src.length();
            String base_url = trail.gpx_src.substring(0, size_url - get.length());
            Request request = new Request.Builder()
                    .url(trail.gpx_src)
                    .build();

            client.newCall(request).enqueue(new okhttp3.Callback() {

                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, okhttp3.Response response) throws IOException {
                    boolean teste = response.isSuccessful();
                    if (response.isSuccessful()) {

                        final InputStreamReader file = new InputStreamReader(response.body().byteStream());
                        FileManager.parseGpxToList(file, activity.getBaseContext(), trial_id);
                        DataSource.getInstance().setTrail_id(trial_id);
                        activity.runOnUiThread(new Runnable() {
                               @Override
                               public void run() {
                                   Toast toast = Toast.makeText(activity, "O mapa carregado com sucesso... ", Toast.LENGTH_LONG);

                                   toast.show();
                               }
                           }
                        );
                    } else {

                    }

                }

            });


        return message;
    }
}
