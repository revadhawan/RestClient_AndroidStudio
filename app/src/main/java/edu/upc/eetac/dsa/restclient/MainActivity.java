package edu.upc.eetac.dsa.restclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity{

    RestAPI restAPI;
    String title;
    String singer;
    Button tracksbutton;

    private RecyclerView recyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tracksbutton = (Button) findViewById(R.id.TracksButton);
        recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        createRestAPI();
        tracksbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                restAPI.getAllTracks().enqueue(tracksCallback);
            }
        });
    }

        private void createRestAPI() {
        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(restAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        restAPI = retrofit.create(RestAPI.class);
    }



    Callback<List<Tracks>> tracksCallback = new Callback<List<Tracks>>() {
        @Override
        public void onResponse(Call<List<Tracks>> call, Response<List<Tracks>> response) {
            if (response.isSuccessful()) {
                List<Tracks> data = new ArrayList<>();
                data.addAll(response.body());
                recyclerView.setAdapter(new RecyclerViewAdapter(data));
            } else {
                Log.d("QuestionsCallback", "Code: " + response.code() + " Message: " + response.message());
            }
        }

        @Override
        public void onFailure(Call<List<Tracks>> call, Throwable t) {
            t.printStackTrace();
        }
    };
}


















