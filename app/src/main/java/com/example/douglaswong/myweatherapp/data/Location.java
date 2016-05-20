package com.example.douglaswong.myweatherapp.data;

import org.json.JSONObject;

/**
 * Created by Douglas Wong on 5/18/2016.
 */
public class Location implements JSONPopulator {

    private String city;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String country;

    @Override
    public void populate(JSONObject data) {
        city = data.optString("city");
        country = data.optString("country");
    }
}