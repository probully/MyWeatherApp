package com.example.douglaswong.myweatherapp.data;

import org.json.JSONObject;

/**
 * Created by Douglas Wong on 5/18/2016.
 */
public class Units implements JSONPopulator {

    private String temperature;

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }


    @Override
    public void populate(JSONObject data) {
        temperature = data.optString("temperature");
    }
}
