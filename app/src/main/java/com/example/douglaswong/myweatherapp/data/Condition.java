package com.example.douglaswong.myweatherapp.data;

import org.json.JSONObject;

/**
 * Created by Douglas Wong on 5/18/2016.
 */
public class Condition implements JSONPopulator {

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private int temperature;
    private int code;
    private String description;

    @Override
    public void populate(JSONObject data) {
        code = data.optInt("code");
        temperature = data.optInt("temp");
        description = data.optString("text");
    }
}
