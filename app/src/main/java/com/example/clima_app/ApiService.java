package com.example.clima_app;


import com.example.clima_app.Model.DailyForecasts;
import com.example.clima_app.Model.ResponseFiveDays;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("5day/7894?apikey=1IGb4ucn1oX803CdkJSdgOXscoUFvbwj&language=es-es")
    Call<ResponseFiveDays> getResponseFiveDays();


}
