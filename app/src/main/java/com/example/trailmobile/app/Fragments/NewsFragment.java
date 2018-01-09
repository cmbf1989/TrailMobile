package com.example.trailmobile.app.Fragments;

/**
 * Created by Cesar Ferreira on 08/03/2016.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trailmobile.app.Interfaces.IFragment;
import com.example.trailmobile.app.Interfaces.IManager;
import com.example.trailmobile.app.Interfaces.IOrganization;
import com.example.trailmobile.app.Interfaces.IPresenter;
import com.example.trailmobile.app.Interfaces.IUser;
import com.example.trailmobile.trailmobile.R;

public class NewsFragment extends Fragment implements IFragment {

    private IPresenter presenter;
    private final int PRESENTER_NUMBER  = 1;
    private IOrganization organization;
    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.news_fragment, container, false);


        return v;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        //presenter = Factory.getInstance().createPresenter(PRESENTER_NUMBER);
        if(presenter == null) return;
        presenter.attachActivity(getActivity());
        presenter.attachFragment(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter = null;
    }


    @Override
    public void attachOrganization(IOrganization obj) {
        this.organization = obj;
    }

    @Override
    public void attachUser(IUser obj) {

    }

    @Override
    public void attachRepositoryToPresenter(IManager repository) {
        if(presenter == null) return;
        presenter.attachTrialManager(repository);
    }

    @Override
    public void attachPresenter(IPresenter presenter) {
        this.presenter = presenter;
    }
}