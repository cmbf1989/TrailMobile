package com.example.trailmobile.app.Classes;

import android.telephony.SmsManager;
import android.util.Log;

import com.example.trailmobile.app.Interfaces.IConnection;
import com.example.trailmobile.app.Interfaces.IModel;
import com.example.trailmobile.app.POJO.JsonResponse;
import com.example.trailmobile.app.POJO.MainEvent;
import com.example.trailmobile.app.POJO.Result;
import com.example.trailmobile.app.POJO.User;

import java.io.BufferedReader;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Cesar Ferreira on 14/03/2016.
 */
public class ConnectionManager   {

    private static IConnection sInstance;
    private BufferedReader response;
    private String link;

    public ConnectionManager(String link) {
        this.link = link;
    }



    public static boolean connectionSMS(String phone,String message)
    {
        SmsManager sms = SmsManager.getDefault();
        try {
            sms.sendTextMessage(phone, null, message, null, null);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static void createConnectionEvents(final IModel model, String url )
    {

        IConnection taskService = ServiceGenerator.createService(IConnection.class);
        Call<JsonResponse<MainEvent>> call = taskService.getEvents(url);
        call.enqueue(new Callback<JsonResponse<MainEvent>>() {

            @Override
            public void onResponse(Call<JsonResponse<MainEvent>> call, retrofit2.Response<JsonResponse<MainEvent>> response) {

                //IModel saved_model = model.saveUncachedList(response.body());
                JsonResponse<MainEvent> results  = response.body();
                if(!results.getError()) {
                    IModel saved_model = model.saveUncachedList(response.body());
                }
            }

            @Override
            public void onFailure(Call<JsonResponse<MainEvent>> call, Throwable t) {
                // something went completely south (like no internet connection)
                //Log.d("Error", t.getMessage());
            }
        });
    }

    public static void createConnectionUsers(final IModel model, String url, String email)
    {

        IConnection taskService = ServiceGenerator.createService(IConnection.class);
        Call<JsonResponse<User>> call = taskService.getUsers(url, email);
        call.enqueue(new Callback<JsonResponse<User>>() {

            @Override
            public void onResponse(Call<JsonResponse<User>> call, retrofit2.Response<JsonResponse<User>> response) {

                //IModel saved_model = model.saveUncachedList(response.body());
                try {
                    JsonResponse<User> result = response.body();

                    if(!result.getError()) {
                        IModel saved_model = model.saveUncachedList(result.getResult());
                        DataSource.getInstance().setUser_id(saved_model.getModelId());
                    }
                } catch (Exception e) {
                    String erro = e.toString();
                }

            }

            @Override
            public void onFailure(Call<JsonResponse<User>> call, Throwable t) {
                // something went completely south (like no internet connection)
                Log.d("Error", t.getMessage());
            }
        });
    }

}
