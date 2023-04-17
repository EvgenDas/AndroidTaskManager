package com.dashencko.androidtaskmanager.retrofit;

import com.dashencko.androidtaskmanager.Models.Task;

import java.time.LocalDate;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TaskApi {

    @GET("/AllTask")
    Call<List<Task>> AllTask();


    @POST("/AllTask/add")
    Call<Task> TaskAddObject(@Body Task task);

    }


