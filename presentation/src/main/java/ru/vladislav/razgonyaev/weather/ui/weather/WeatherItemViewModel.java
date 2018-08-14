package ru.vladislav.razgonyaev.weather.ui.weather;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import ru.vladislav.razgonyaev.domain.model.Forecast;


public class WeatherItemViewModel {

    private ObservableField<String> date = new ObservableField<>();
    private ObservableInt temperature = new ObservableInt();
    private ObservableInt temperatureFeelsLike = new ObservableInt();

    public WeatherItemViewModel(Forecast forecast) {
        date.set(forecast.getDate());
        temperature.set(forecast.getParts().getDay().getTemp());
        temperatureFeelsLike.set(forecast.getParts().getDay().getFeelsLike());
    }

    public ObservableField<String> getDate() {
        return date;
    }

    public ObservableInt getTemperature() {
        return temperature;
    }

    public ObservableInt getTemperatureFeelsLike() {
        return temperatureFeelsLike;
    }
}
