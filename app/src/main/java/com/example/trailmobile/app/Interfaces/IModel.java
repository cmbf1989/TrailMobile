package com.example.trailmobile.app.Interfaces;

/**
 * Created by Cesar Ferreira on 04/04/2016.
 */
public interface IModel {

    <S> boolean isCached(S id);
    <S> IModel saveUncached(S data);
    <S> IModel saveUncachedList(S data);
    long getModelId();

}
