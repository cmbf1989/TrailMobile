package com.example.trailmobile.app.Listeners;

import android.app.Service;
import android.content.Intent;

import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.trailmobile.app.Interfaces.IObserver;


import java.util.List;

/**
 * Created by utilizador on 07/04/2017.
 */

public class ServerUploader extends Service implements Observable {

    private List<IObserver> observers;



    @Override
    public void notifyObservers() {
        for(IObserver obs : observers)
            obs.update();
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
