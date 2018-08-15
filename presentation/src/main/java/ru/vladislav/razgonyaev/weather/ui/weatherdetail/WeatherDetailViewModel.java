package ru.vladislav.razgonyaev.weather.ui.weatherdetail;

import android.databinding.ObservableField;

import java.util.List;

import io.reactivex.observers.DisposableSingleObserver;
import ru.vladislav.razgonyaev.domain.interactor.GetHourlyForecasts;
import ru.vladislav.razgonyaev.domain.model.Hour;

public class WeatherDetailViewModel {

    private WeatherDetailAdapter adapter;
    private GetHourlyForecasts getHourlyForecastsUseCase;
    private ObservableField<List<Hour>> hourlyForecasts = new ObservableField<>();

    public WeatherDetailViewModel(WeatherDetailAdapter adapter, GetHourlyForecasts getHourlyForecastsUseCase) {
        this.adapter = adapter;
        this.getHourlyForecastsUseCase = getHourlyForecastsUseCase;
    }

    public void loadHourlyForecasts(Long dayId) {
        getHourlyForecastsUseCase.execute(new WeatherDetailViewModel.HourlyForecastsObserver(),
                GetHourlyForecasts.Params.getParams(dayId));
    }

    public ObservableField<List<Hour>> getHourlyForecasts() {
        return hourlyForecasts;
    }

    public WeatherDetailAdapter getAdapter() {
        return adapter;
    }

    private class HourlyForecastsObserver extends DisposableSingleObserver<List<Hour>> {

        @Override
        public void onSuccess(List<Hour> hourlyForecastList) {
            hourlyForecasts.set(hourlyForecastList);
        }

        @Override
        public void onError(Throwable e) {

        }
    }
}
