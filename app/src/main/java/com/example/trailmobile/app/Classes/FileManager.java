package com.example.trailmobile.app.Classes;

import android.content.Context;
import android.os.Environment;

import com.example.trailmobile.app.Models.GpsTrial;
import com.example.trailmobile.app.Models.TrailCompetition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.nio.channels.FileChannel;

/**
 * Created by Cesar Ferreira on 31/03/2016.
 */
public class FileManager {


    public static void parseGpxToList(Reader content, Context context, long trail_id)
    {
        int number = 0;
        TrailCompetition trail = TrailCompetition.load(TrailCompetition.class,trail_id);
        try {
            //ActiveAndroid.beginTransaction();
            BufferedReader br = new BufferedReader(content);
            String line;

            while ((line = br.readLine()) != null) {

                if(line.contains("trkpt") && !line.contains("</trkpt>") ) {
                    String[] fragments = line.split("\"");
                    // fragments[0] =  <trkpt lat=" | fragments[1] = 2.223 lon="23.23023"
                    // fragments_lat[0] = 2.223 | fragments_lat[1] = lon="23.23023"

                    GpsTrial gpsTrial = new GpsTrial();
                    gpsTrial.longitude =  Float.parseFloat(fragments[3]);
                    gpsTrial.latitude =  Float.parseFloat(fragments[1]);
                    gpsTrial.number = number;
                    gpsTrial.idTrial = trail;
                    gpsTrial.save();
                    number++;
                }

            }
            trail.coordinate_number = number;
            trail.save();
           // ActiveAndroid.setTransactionSuccessful();
            br.close();
        }
        catch (Exception e) {
            //You'll need to add proper error handling here
            String asd = e.toString();
        }
        //ActiveAndroid.endTransaction();
        //return list_coordinates;
    }

    public static void exportDB(){
        String SAMPLE_DB_NAME = "trailmobile.db";
        File sd = Environment.getExternalStorageDirectory();
        File data = Environment.getDataDirectory();
        FileChannel source=null;
        FileChannel destination=null;
        String currentDBPath =  "/data/com.example.trailmobile.trailmobile" +"/databases/"+ SAMPLE_DB_NAME;
        String backupDBPath = SAMPLE_DB_NAME;
        File currentDB = new File(data, currentDBPath);
        File backupDB = new File(sd, backupDBPath);
        try {
            source = new FileInputStream(currentDB).getChannel();
            destination = new FileOutputStream(backupDB).getChannel();

            destination.transferFrom(source, 0, source.size());
            source.close();

            destination.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
