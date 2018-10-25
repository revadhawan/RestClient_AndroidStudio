package edu.upc.eetac.dsa.restclient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.DELETE;
import retrofit2.http.Body;
import retrofit2.http.Query;

public interface RestAPI {

    String BASE_URL = "http://147.83.7.155:8080/dsaAPP/";

    @GET("tracks")
    Call<List<Tracks>> getAllTracks();

    @POST("tracks")
    Call<List<Tracks>> addTrack(@Body Tracks tracks);




}