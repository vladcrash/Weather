package ru.vladislav.razgonyaev.weather.ui.weatherdetail;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import ru.vladislav.razgonyaev.domain.model.Hour;


public class WeatherDetailItemViewModel {

    private ObservableField<String> hour = new ObservableField<>();
    private ObservableInt temperature = new ObservableInt();
    private ObservableInt temperatureFeelsLike = new ObservableInt();

    public WeatherDetailItemViewModel(Hour hourlyForecast) {
        hour.set(hourlyForecast.getHour());
        temperature.set(hourlyForecast.getTemp());
        temperatureFeelsLike.set(hourlyForecast.getFeelsLike());
    }

    public ObservableField<String> getHour() {
        return hour;
    }

    public ObservableInt getTemperature() {
        return temperature;
    }

    public ObservableInt getTemperatureFeelsLike() {
        return temperatureFeelsLike;
    }
}
