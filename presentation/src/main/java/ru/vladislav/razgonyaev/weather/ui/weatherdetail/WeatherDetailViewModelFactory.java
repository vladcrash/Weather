package ru.vladislav.razgonyaev.weather.ui.weatherdetail;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class WeatherDetailViewModelFactory implements ViewModelProvider.Factory {

    private WeatherDetailViewModel viewModel;

    public WeatherDetailViewModelFactory(WeatherDetailViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) viewModel;
    }
}
