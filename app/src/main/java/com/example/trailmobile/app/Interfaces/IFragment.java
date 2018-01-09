package com.example.trailmobile.app.Interfaces;

/**
 * Created by Cesar Ferreira on 16/03/2016.
 */
public interface IFragment {

    public void attachOrganization(IOrganization obj);
    public void attachUser(IUser obj);
    public void attachRepositoryToPresenter(IManager repository);
    public void attachPresenter(IPresenter presenter);
}
