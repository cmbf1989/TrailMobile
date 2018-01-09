package com.example.trailmobile.app.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trailmobile.app.Classes.ImageListAdapter;
import com.example.trailmobile.app.Interfaces.ICustomList;
import com.example.trailmobile.app.Interfaces.IFragment;
import com.example.trailmobile.app.Interfaces.IManager;
import com.example.trailmobile.app.Interfaces.IOrganization;
import com.example.trailmobile.app.Interfaces.IPresenter;
import com.example.trailmobile.app.Interfaces.IUser;
import com.example.trailmobile.app.Interfaces.ListViewCustomAdapter;
import com.example.trailmobile.app.Presenters.TrainingPresenter;
import com.example.trailmobile.trailmobile.R;

/**
 * Created by utilizador on 17/10/2016.
 */
public class TrainingFragment extends Fragment implements IFragment, ICustomList {

    private ListViewCustomAdapter adapter;
    private TrainingPresenter presenter;
    private View current_view;
    private String[] elements = {
            "Teste",
            "Teste 2"
    };
    private int[] images = {
            R.mipmap.ic_emergency,
            R.mipmap.ic_alarm
    };
    private int[] viewsOptions = {
            R.layout.emergency_option,
            R.layout.alarm_option
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        current_view =  inflater.inflate(R.layout.training_fragment, container, false);
        loadListView(current_view);
        handleButtonClicks(current_view);
        return current_view;
    }

    public void loadListView(View v)
    {
        adapter = new ImageListAdapter(getActivity(), this);
        // adapter.setId_element(event_ids);
        ListView list = (ListView) v.findViewById(R.id.training_list);
        list.setAdapter((ImageListAdapter) adapter);
        final Context context = getActivity().getApplicationContext();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                CharSequence text = "SELECT IT!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

    }
    public void handleButtonClicks(View view)
    {
        ImageButton search = (ImageButton) view.findViewById(R.id.button_search);
        final Context context = getActivity().getApplicationContext();
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                elements = new String[] {"Ttestingo", "Testando", "TEst"};
                loadListView(current_view);

                CharSequence text = "SEARCH IT!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }
    @Override
    public void attachOrganization(IOrganization obj) {

    }

    @Override
    public void attachUser(IUser obj) {

    }

    @Override
    public void attachRepositoryToPresenter(IManager repository) {

    }

    @Override
    public void attachPresenter(IPresenter presenter) {
        this.presenter = (TrainingPresenter) presenter;
    }

    @Override
    public int getListLayout() {
        return R.layout.training_item;
    }

    @Override
    public String[] getItemNames() {
        return elements;
    }

    @Override
    public void handleContent(View rowView, int position) {
        ImageButton edit = (ImageButton) rowView.findViewById(R.id.button_edit);
        ImageButton delete = (ImageButton) rowView.findViewById(R.id.button_delete);
        final Context context = getActivity().getApplicationContext();
        ((TextView) rowView.findViewById(R.id.training_name)).setText(elements[position]);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CharSequence text = "EDIT IT!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence text = "DELETE IT!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }
}
