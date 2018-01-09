package com.example.trailmobile.app.Classes;

import com.example.trailmobile.app.Interfaces.IConnection;
import com.example.trailmobile.app.Interfaces.IModel;
import com.example.trailmobile.app.Models.Gps;
import com.example.trailmobile.app.POJO.GpsData;
import com.example.trailmobile.app.POJO.JsonResponse;

/**
 * Created by utilizador on 18/04/2017.
 */

public class GpsConnectionManager {

    public static void uploadGpsData(final JsonResponse<Gps> data_gps, String url )
    {

        IConnection taskService = ServiceGenerator.createService(IConnection.class);
        taskService.sendCoordinates(data_gps);
        /*call.enqueue(new Callback<JsonResponse<MainEvent>>() {

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
        });*/
    }
}
