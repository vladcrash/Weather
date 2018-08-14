package ru.vladislav.razgonyaev.weather.ui.weather;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import ru.vladislav.razgonyaev.domain.model.Forecast;


public class WeatherListBindings {

    @BindingAdapter({"adapter", "data"})
    public static void bind(RecyclerView recyclerView, WeatherAdapter adapter, ObservableField<List<Forecast>> forecasts) {
        recyclerView.setAdapter(adapter);
        adapter.setDailyForecasts(forecasts.get());
    }
}
