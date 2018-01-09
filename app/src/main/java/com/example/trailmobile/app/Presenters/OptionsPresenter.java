package com.example.trailmobile.app.Presenters;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.NumberPicker;

import com.example.trailmobile.app.Classes.Factory;
import com.example.trailmobile.app.Classes.TrialManager;
import com.example.trailmobile.app.Interfaces.IConfiguration;
import com.example.trailmobile.app.Interfaces.IDataSource;
import com.example.trailmobile.app.Interfaces.IPresenter;
import com.example.trailmobile.app.Interfaces.IManager;
import com.example.trailmobile.app.Models.ConfigurationManager;
import com.example.trailmobile.trailmobile.R;

/**
 * Created by Cesar Ferreira on 09/03/2016.
 */
public class OptionsPresenter implements IPresenter {
    private Activity activity;
    private IConfiguration configurationManager;
    private IManager repository;
    private IDataSource datasource;

    public OptionsPresenter()
    {
        configurationManager = Factory.getInstance().createConfiguration();
    }
    @Override
    public void attachActivity(Activity a) {
        activity = a;
    }

    @Override
    public void attachFragment(Fragment a) {

    }

    @Override
    public void attachTrialManager(IManager rep) {
        repository = rep;
    }

    public String[] loadConfiguration(int position)
    {
        String[] options = new String[3];
        switch(position)
        {
            case 0:
                options[0] = "Suporte";
                options[1] = String.valueOf(R.layout.emergency_option);
                options[2] = "information";
                break;
            case 1:
                options[0] = "Intervalo de Captura";
                options[1] =  String.valueOf(R.layout.alarm_option);
                options[2] = "save";
                break;
            default:

        }
        return options;
    }

    public void configButtonOptions(int position, View v)
    {
        switch(position)
        {
            case 0:

                break;
            case 1:
                NumberPicker np = (NumberPicker) v.findViewById(R.id.gps_interval);
                String[] max_number = ((ConfigurationManager) configurationManager).getMaxTimerNums();
                np.setMinValue(1);
                np.setMaxValue(20);
                np.setWrapSelectorWheel(false);
                np.setDisplayedValues(max_number);
                np.setValue(1);

                //((TextView) np.getFocusedChild()).setTextSize(15.0f);
                //((TextView) np.get).setTextSize(15.0f);

                break;
        }
    }

    public String getDialogButtonMessage(int position,boolean isPositive)
    {
        switch(position)
        {
            case 0:
                return "Cancelar";
            default:
                return isPositive ? "Guardar" : "Cancelar";
        }
    }

    @Override
    public boolean getCompetitionStatus() {
        return ((TrialManager) repository).getCompetitionStatus();
    }

    @Override
    public void startService(int pos, Intent intent) {

    }


    @Override
    public void stopService(int pos, Intent intent) {

    }
}
