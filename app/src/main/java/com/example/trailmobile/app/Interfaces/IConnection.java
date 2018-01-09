package com.example.trailmobile.app.Interfaces;

import com.example.trailmobile.app.Models.Gps;
import com.example.trailmobile.app.POJO.GpsData;
import com.example.trailmobile.app.POJO.JsonResponse;
import com.example.trailmobile.app.POJO.MainEvent;
import com.example.trailmobile.app.POJO.Result;
import com.example.trailmobile.app.POJO.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by Cesar Ferreira on 14/03/2016.
 */
public interface IConnection {

    @GET
    @Streaming
    Call<ResponseBody> getFile(@Url String url);


    @GET
    Call <JsonResponse<MainEvent>> getEvents(@Url String url);

    @FormUrlEncoded
    @POST
     Call<JsonResponse<User>>getUsers(@Url String url, @Field("email") String email);

    @FormUrlEncoded
    @POST("/sendCoordinates")
    void sendCoordinates(@Body JsonResponse<Gps> data);

}
