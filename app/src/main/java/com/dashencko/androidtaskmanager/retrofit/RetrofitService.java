package com.dashencko.androidtaskmanager.retrofit;

import static retrofit2.converter.gson.GsonConverterFactory.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private Retrofit retrofit;


    public RetrofitService() {
        initializeRetrofit();
        
    }

    private void initializeRetrofit() {
        Gson gson = new GsonBuilder().setLenient().create();

        OkHttpClient client = new OkHttpClient();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.98:8081")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public  Retrofit getRetrofit() {
        return retrofit;
    }

}
