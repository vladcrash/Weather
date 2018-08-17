package ru.vladislav.razgonyaev.weather.ui.weather;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class WeatherViewModelFactory implements ViewModelProvider.Factory {

    private WeatherViewModel viewModel;

    public WeatherViewModelFactory(WeatherViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) viewModel;
    }
}
