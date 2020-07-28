package com.example.clima_app.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseFiveDays {
    @SerializedName("Headline")
    Headline headline;
    @SerializedName("DailyForecasts")
    List<DailyForecasts> dailyForecasts;

    public Headline getHeadline() {
        return headline;
    }

    public void setHeadline(Headline headline) {
        this.headline = headline;
    }

    public List<DailyForecasts> getDailyForecasts() {
        return dailyForecasts;
    }
}
