package com.example.douglaswong.myweatherapp.service;

import com.example.douglaswong.myweatherapp.data.Channel;

/**
 * Created by Douglas Wong on 5/18/2016.
 */
public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);
    void serviceFailure(Exception exception);
}
