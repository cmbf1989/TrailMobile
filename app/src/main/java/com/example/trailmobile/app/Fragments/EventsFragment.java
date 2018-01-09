package com.example.trailmobile.app.Fragments;

/**
 * Created by Cesar Ferreira on 08/03/2016.
 */

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trailmobile.app.Classes.CustomListAdapter;
import com.example.trailmobile.app.Interfaces.IFragment;
import com.example.trailmobile.app.Interfaces.IManager;
import com.example.trailmobile.app.Interfaces.IOrganization;
import com.example.trailmobile.app.Interfaces.IPresenter;
import com.example.trailmobile.app.Interfaces.IUser;
import com.example.trailmobile.app.Presenters.EventsPresenter;
import com.example.trailmobile.trailmobile.R;

public class EventsFragment extends Fragment implements IFragment {

    private IPresenter presenter;
    private final int PRESENTER_NUMBER  = 2;
    private CustomListAdapter adapter;
    CustomListAdapter trial_adapter;
    String[] name;
    String[] description;
    long[] event_ids;
    int[] layout_ids = { R.id.event_name,R.id.event_description};
    int[] trial_layout_ids = { R.id.trial_name,R.id.trial_description};
    private View view;
    public EventsFragment() {
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
        view = inflater.inflate(R.layout.events_fragment, container, false);
        if(presenter == null)
            return view;
        Object[] events = ((EventsPresenter) presenter).getEvents();
        if(events != null) {
            name = (String[]) events[0];
            description = (String[]) events[1];
            event_ids = (long[]) events[2];
        } else {
            name = new String[] {""};
            description =  new String[] {"Não existem dados"};
            event_ids =new long[]{-1};
        }

        adapter = new CustomListAdapter(getActivity(), description, name, layout_ids, R.layout.events_list_layout);
        adapter.setId_element(event_ids);
        ListView list = (ListView) view.findViewById(R.id.trials_list_view);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                makePopupTrials(position);
            }
        });

        return view;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
       // presenter = Factory.getInstance().createPresenter(PRESENTER_NUMBER);
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

    public void makePopupTrials(int event_position)
    {
        final EventsPresenter presenter_aux = ((EventsPresenter) presenter);
        final long[] trial_ids;
        final Dialog dialog;
        Object[] trials = ((EventsPresenter) presenter).getTrials(event_ids[event_position]);
        String[] trial_description;
        String[] trial_name;
        if(trials != null) {
            trial_name = (String[]) trials[0];
            trial_description = (String[]) trials[1];
            trial_ids = (long[]) trials[2];
        } else {
            trial_name = new String[] {""};
            trial_description =  new String[] {"Não existem dados"};
            trial_ids = new long[]{-1};
        }
        View popup_view = LayoutInflater.from(getContext()).inflate(Integer.valueOf(R.layout.popup_trials), null);
       // presenter_aux.configButtonOptions(position, popup_view);
        final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getContext());
        alertBuilder.setView(popup_view);

        View title = View.inflate(getContext(), R.layout.popup_title, null);
        ((TextView) title.findViewById(R.id.title_popup)).setText("Provas");


        trial_adapter = new CustomListAdapter(getActivity(), trial_description, trial_name, trial_layout_ids, R.layout.trial_list_layout);
        trial_adapter.setId_element(trial_ids);
        ListView list = (ListView) popup_view.findViewById(R.id.trials_list_view);
        list.setAdapter(trial_adapter);
        alertBuilder.setCancelable(true)
                .setCustomTitle(title)
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        // carregar mapa para a db atraves da net caso nao tenha localmente.

                    }
                });

        dialog = alertBuilder.create();
        dialog.show();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                boolean connected = true;
                //makePopupTrials(position,trials);
                try {
                    String msg = presenter_aux.getPathFileFromServer(trial_ids[position]);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // boolean success = presenter_aux.loadTrialTrack(trial_ids[position]);
                    CharSequence text = "O mapa irá ser carregado aguarde ... ";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(view.getContext(), text, duration);
                    toast.show();
                    dialog.dismiss();
            }
        });


    }
}