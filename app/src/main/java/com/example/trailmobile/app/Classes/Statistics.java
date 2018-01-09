package com.example.trailmobile.app.Classes;

import android.location.Location;

import com.example.trailmobile.app.Interfaces.IStatistics;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * Created by Cesar Ferreira on 20/03/2016.
 */
public class Statistics implements IStatistics {

    public static Double distance(LatLng one, LatLng two) {
        int R = 6371000;
        Double dLat = toRad(two.latitude - one.latitude);
        Double dLon = toRad(two.longitude - one.longitude);
        Double lat1 = toRad(one.latitude);
        Double lat2 = toRad(two.latitude);
        Double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        Double d = R * c;
        return d;
    }
    private static double toRad(Double d) {
        return d * Math.PI / 180;
    }

    private static float getAvgTime(List<Location> locations)
    {
        int size = locations.size();
        float time = 0;
        for(Location loc : locations) {
            time =+ loc.getTime();
        }
        return time/size;
    }
    /*
        Get the distance and time and apply the formula
        End distance - Initial distance / End interval - Initial interval
     */
    private static double getSpeed(float d_init, float d_end,float t_init, float t_end)
    {
        return (double) (d_end - d_init)/(t_end - t_init);
    }

    public static double getAvgSpeed(List<LatLng> locations,int time_between_uptades)
    {
        // Calculate both first and last locations of the list
        LatLng initial = locations.get(0);
        LatLng end     = locations.get(locations.size()-1);

        // Get the distance from them
        Double distance = distance(initial, end);
        // get the time spent on the updates
        float end_interval = time_between_uptades*locations.size();
        // Get the speed with the method gets peed
        return getSpeed(0, distance.floatValue(), 0, end_interval);
    }
}
