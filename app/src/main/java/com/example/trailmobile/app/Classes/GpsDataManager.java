package com.example.trailmobile.app.Classes;

import com.example.trailmobile.app.Classes.ServiceGenerator;
import com.example.trailmobile.app.Interfaces.IConnection;
import com.example.trailmobile.app.Interfaces.IModel;
import com.example.trailmobile.app.Models.Gps;
import com.example.trailmobile.app.Models.UserData;
import com.example.trailmobile.app.POJO.GpsData;
import com.example.trailmobile.app.POJO.JsonResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by utilizador on 14/04/2017.
 */

public class GpsDataManager {



    public GpsDataManager() {
    }

    public JsonResponse<Gps> getUserTrailGpsData(long trail_id, long user_id, long trail_server_id, long user_server_id)
    {
        UserData gps = new UserData();

        long id_user_data = gps.getUserDataId(user_id,trail_id);

        JsonResponse<Gps> response = new JsonResponse<>();

        response.setResult(Gps.getUserDataById(id_user_data));

        return response;
    }


}
