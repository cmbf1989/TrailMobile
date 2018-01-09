package com.example.trailmobile.app.Interfaces;

/**
 * Created by Cesar Ferreira on 19/03/2016.
 */
public interface IManager {

    void attachOrganization(IOrganization obj);
    void attachUser(IUser obj);
    void attachObserver(IObserver obs);
    void detachObserver(IObserver obs);

}
