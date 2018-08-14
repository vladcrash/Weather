package ru.vladislav.razgonyaev.weather.ui.weatherdetail;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import ru.vladislav.razgonyaev.weather.App;
import ru.vladislav.razgonyaev.weather.R;

import ru.vladislav.razgonyaev.weather.databinding.ActivityWeatherDetailBinding;

public class WeatherDetailActivity extends AppCompatActivity {

    private static final String ID = "ru.vladislav.razgonyaev.weather.ui.weatherdetail.WeatherDetailActivity.ID";

    @Inject
    WeatherDetailViewModel viewModel;

    public static final Intent newIntent(Context context, Long forecastId) {
        Intent intent = new Intent(context, WeatherDetailActivity.class);
        intent.putExtra(ID, forecastId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_detail);
        setup();
        init();
        load();
    }

    private void setup() {
        App.get(this)
            .plusWeatherDetailComponent()
            .inject(this);
    }

    private void init() {
        ActivityWeatherDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_weather_detail);
        binding.setViewModel(viewModel);
    }

    private void load() {
        Long dayId = getIntent().getLongExtra(ID, 0);
        viewModel.loadHourlyForecasts(dayId);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.get(this).releaseWeatherDetailComponent();
    }
}
