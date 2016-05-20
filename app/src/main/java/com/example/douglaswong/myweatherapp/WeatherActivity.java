package com.example.douglaswong.myweatherapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.douglaswong.myweatherapp.data.Channel;
import com.example.douglaswong.myweatherapp.service.WeatherServiceCallback;
import com.example.douglaswong.myweatherapp.service.YahooWeatherService;

public class WeatherActivity extends AppCompatActivity implements WeatherServiceCallback {

    ImageView imV;
    TextView tvT, tvC, tvL;
    EditText etL;
    Button btGo, btnWidget;
    YahooWeatherService yahooWeatherService;
    ProgressDialog progressDialog;
    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        tvT = (TextView) findViewById(R.id.tvT);
        tvC = (TextView) findViewById(R.id.tvC);
        tvL = (TextView) findViewById(R.id.tvL);
        etL = (EditText) findViewById(R.id.etLocation);
        btGo = (Button) findViewById(R.id.btnGo);
        btnWidget = (Button) findViewById(R.id.btnOw);

        imV = (ImageView) findViewById(R.id.iM);

    }

    public void onClick(View v)
    {
        value = etL.getText().toString();
        yahooWeatherService = new YahooWeatherService(WeatherActivity.this);

        yahooWeatherService.refreshWeather(value,"c");

        progressDialog = new ProgressDialog(WeatherActivity.this);

        progressDialog.setMessage("Loading...");

        progressDialog.show();
    }

    public void OpenWidget(View v)
    {
        Intent i = new Intent(WeatherActivity.this, MyWeatherAppWidgetConfigureActivity.class);
        startActivity(i);
    }

    @Override
    public void serviceSuccess(Channel channel) {
        progressDialog.dismiss();
        int resourceID = getResources().getIdentifier("drawable/icon_" + channel.getItem().getCondition().getCode(), null, getPackageName());
        //noinspection deprecation
        Drawable weatherIcon = getResources().getDrawable(resourceID);
        imV.setImageDrawable(weatherIcon);
        tvT.setText(channel.getItem().getCondition().getTemperature() + "\u00B0 " + channel.getUnits().getTemperature());
        String city = channel.getLocation().getCity();
        String country = channel.getLocation().getCountry();
        tvL.setText(city+", "+ country);
        tvC.setText(channel.getItem().getCondition().getDescription());
    }

    @Override
    public void serviceFailure(Exception exception) {
        progressDialog.hide(); Toast.makeText(WeatherActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.menuTemp:
                Toast.makeText(WeatherActivity.this, "Menu Temp", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuClose:
                Toast.makeText(WeatherActivity.this, "Menu Close", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
