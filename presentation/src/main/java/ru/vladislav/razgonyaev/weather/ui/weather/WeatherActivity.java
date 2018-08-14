package ru.vladislav.razgonyaev.weather.ui.weather;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import ru.vladislav.razgonyaev.weather.App;
import ru.vladislav.razgonyaev.weather.R;
import ru.vladislav.razgonyaev.weather.databinding.ActivityWeatherBinding;


public class WeatherActivity extends AppCompatActivity {

    @Inject
    WeatherViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setup();
        init();
        load();
    }

    private void setup() {
        App.get(this)
            .plusWeatherComponent()
            .inject(this);
    }

    private void init() {
        ActivityWeatherBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_weather);
        binding.setViewModel(viewModel);
    }

    private void load() {
        viewModel.loadDailyForecasts();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.get(this).releaseWeatherComponent();
    }
}
