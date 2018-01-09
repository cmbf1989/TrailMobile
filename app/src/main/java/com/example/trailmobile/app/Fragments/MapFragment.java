package com.example.trailmobile.app.Fragments;

/**
 * Created by Cesar Ferreira on 08/03/2016.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.ImageView;

import com.example.trailmobile.app.Classes.DataSource;
import com.example.trailmobile.app.Interfaces.IFragment;
import com.example.trailmobile.app.Interfaces.IManager;
import com.example.trailmobile.app.Interfaces.IOrganization;
import com.example.trailmobile.app.Interfaces.IPresenter;
import com.example.trailmobile.app.Interfaces.IUser;
import com.example.trailmobile.app.Presenters.MapPresenter;
import com.example.trailmobile.trailmobile.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class MapFragment extends Fragment implements IFragment, OnMapReadyCallback {


    private SupportMapFragment fragment;
    private GoogleMap map;
    private IPresenter presenter;
    private final int PRESENTER_NUMBER  = 3;
    private int[] start_buttons = {R.mipmap.ic_start_competition,R.mipmap.ic_start_competition_selected};
    private ImageView start_button;
    private View frag_view;
    private long time_elapse = 0;

    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.map_fragment, container, false);
        FragmentManager fm = getChildFragmentManager();
        fragment = (SupportMapFragment) fm.findFragmentById(R.id.map_container);
        if (fragment == null) {
            fragment = SupportMapFragment.newInstance();
            fm.beginTransaction().replace(R.id.map_container, fragment).commit();
        }
        fragment.getMapAsync(this);
        start_button = (ImageView) v.findViewById(R.id.start_button);
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(DataSource.getInstance().getTrail_id() < 1) {

                    return;
                }
                int toggleStartButton = 1;

                if (presenter.getCompetitionStatus()) {
                    toggleStartButton = 0;
                    ((MapPresenter) presenter).stopCompetition();
                } else {
                    ((MapPresenter) presenter).startCompetition();
                }
                start_button.setImageResource(start_buttons[toggleStartButton]);
            }
        });


        return v;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        setRetainInstance(true);
        //presenter = Factory.getInstance().createPresenter(PRESENTER_NUMBER);
        if(presenter == null) return;
        presenter.attachActivity(getActivity());
        presenter.attachFragment(this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.stopService(0,null);
        presenter = null;
        //System.gc();
    }

    @Override
    public void onPause() {
        presenter.startService(0,null);
        time_elapse = ((Chronometer) getActivity().findViewById(R.id.time_spent)).getBase();
        super.onPause();
    }


    @Override
    public void attachOrganization(IOrganization obj) {

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
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentManager fm = getChildFragmentManager();
        fragment = (SupportMapFragment) fm.findFragmentById(R.id.map_container);
        if (fragment == null) {
            fragment = SupportMapFragment.newInstance();
            fm.beginTransaction().replace(R.id.map_container, fragment).commit();
        }
        fragment.getMapAsync(this);
    }

    @Override
    public void onResume() {
        try {
            if(presenter != null) {


                if( ((MapPresenter) presenter).getCompetitionStatus()) {

                }
                presenter.stopService(0, null);
            }

        } catch(Exception e)
        {

        }
        super.onResume();

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (googleMap == null) return;
        map = googleMap;
        ((MapPresenter) presenter).attachMap(map);
        //((MapPresenter) presenter).addPolyline();
    }


    @Override
    public void attachPresenter(IPresenter presenter) {
        this.presenter = presenter;
    }
}