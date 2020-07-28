package com.example.clima_app;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.RemoteViews;
import android.widget.TextClock;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clima_app.Model.DailyForecasts;
import com.example.clima_app.Model.ResponseFiveDays;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<DailyForecasts> dailyForecasts;
    RecyclerView recyclerView;
    TextClock textClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        textClock=findViewById(R.id.textOclock);

        animationBackground();

        initRetrofit();

        timeZome();

    }

    private void timeZome() {
       textClock.setTimeZone("America/Argentina/Buenos_Aires");
    }

    private void animationBackground() {
        ConstraintLayout constraintLayout = findViewById(R.id.main_dc);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        Adapter adapter = new Adapter(dailyForecasts);
        recyclerView.setAdapter(adapter);
    }


    private void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dataservice.accuweather.com/forecasts/v1/daily/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        Call<ResponseFiveDays> call = apiService.getResponseFiveDays();

        call.enqueue(new Callback<ResponseFiveDays>() {
            @Override
            public void onResponse(Call<ResponseFiveDays> call, Response<ResponseFiveDays> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Codigo: " + response.code(), Toast.LENGTH_SHORT).show();

                } else {
                    if (response.body() != null) {
                        dailyForecasts = response.body().getDailyForecasts();
                        initRecyclerView();
                    } else {
                        Toast.makeText(MainActivity.this, "Response.Body null", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseFiveDays> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error failure", Toast.LENGTH_SHORT).show();
            }
        });



    }
}


