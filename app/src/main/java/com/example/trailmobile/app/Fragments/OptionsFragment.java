package com.example.trailmobile.app.Fragments;

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

import com.example.trailmobile.app.Classes.CustomListAdapter;
import com.example.trailmobile.app.Classes.DataSource;
import com.example.trailmobile.app.Interfaces.IFragment;
import com.example.trailmobile.app.Interfaces.IOrganization;
import com.example.trailmobile.app.Interfaces.IPresenter;
import com.example.trailmobile.app.Interfaces.IManager;
import com.example.trailmobile.app.Interfaces.IUser;
import com.example.trailmobile.app.Models.Athlete;
import com.example.trailmobile.app.Presenters.OptionsPresenter;
import com.example.trailmobile.trailmobile.R;

/**
 * Created by Cesar Ferreira on 08/03/2016.
 */

public class OptionsFragment extends Fragment  implements IFragment {

    private IPresenter presenter;
    private CustomListAdapter adapter;
    private IOrganization organization;
    private IUser user;
    private final int PRESENTER_NUMBER  = 4;
    private String[] alias = {
            "Pedir ajuda",
            "Intervalo de captura"
    };
    private int[] images = {
        R.mipmap.ic_emergency,
        R.mipmap.ic_alarm
    };
    private int[] viewsOptions = {
            R.layout.emergency_option,
            R.layout.alarm_option
    };



    public OptionsFragment() {
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
        adapter = new CustomListAdapter(getActivity(), alias, images,viewsOptions);
        View view = inflater.inflate(R.layout.profile_fragment, container, false);
        ListView list = (ListView) view.findViewById(R.id.general_options_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                OptionsPresenter presenter_aux = (OptionsPresenter) presenter;
                String[] configs = presenter_aux.loadConfiguration(position);
                View popup_view = LayoutInflater.from(getContext()).inflate(Integer.valueOf(configs[1]), null);
                presenter_aux.configButtonOptions(position, popup_view);
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getContext());
                alertBuilder.setView(popup_view);
                String positive = presenter_aux.getDialogButtonMessage(position, true);
                String negative = presenter_aux.getDialogButtonMessage(position, false);
                View title = View.inflate(getContext(), R.layout.popup_title, null);
                ((TextView) title.findViewById(R.id.title_popup)).setText(configs[0]);
                alertBuilder.setCancelable(true)
                        .setCustomTitle(title)
                        .setPositiveButton(positive, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                if (configs[2] != "information") {
                    alertBuilder.setNegativeButton(negative, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                }

                Dialog dialog = alertBuilder.create();
                dialog.show();
            }
        });
        if(DataSource.getInstance().getUser_id() < 1) return view;

        Athlete profile = Athlete.load(Athlete.class, DataSource.getInstance().getUser_id());
        if(profile != null) {
            ((TextView) view.findViewById(R.id.user_name)).setText(profile.name != "" ? profile.name : "");
            ((TextView) view.findViewById(R.id.user_email)).setText(profile.email != "" ? profile.email : "" );
            ((TextView) view.findViewById(R.id.user_phone)).setText(profile.phone != "" ? profile.phone : "");


        }

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
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
        this.user =  obj;
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