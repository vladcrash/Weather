package ru.vladislav.razgonyaev.weather.ui.weatherdetail;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import ru.vladislav.razgonyaev.domain.model.Hour;


public class WeatherDetailListBindings {

    @BindingAdapter({"adapter", "data"})
    public static void bind(RecyclerView recyclerView, WeatherDetailAdapter adapter, ObservableField<List<Hour>> hours) {
        recyclerView.setAdapter(adapter);
        adapter.setHourlyForecasts(hours.get());
    }
}
