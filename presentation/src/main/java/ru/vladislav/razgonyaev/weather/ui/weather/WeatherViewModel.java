package ru.vladislav.razgonyaev.weather.ui.weather;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import java.util.List;

import io.reactivex.observers.DisposableSingleObserver;
import ru.vladislav.razgonyaev.domain.interactor.GetDailyForecasts;
import ru.vladislav.razgonyaev.domain.model.Forecast;


public class WeatherViewModel {

    private WeatherAdapter adapter;
    private GetDailyForecasts getDailyForecastsUseCase;
    private ObservableField<List<Forecast>> dailyForecasts = new ObservableField<>();
    private ObservableBoolean isLoading = new ObservableBoolean();

    public WeatherViewModel(WeatherAdapter adapter, GetDailyForecasts getDailyForecastsUseCase) {
        this.adapter = adapter;
        this.getDailyForecastsUseCase = getDailyForecastsUseCase;
    }

    public void loadDailyForecasts() {
        getDailyForecastsUseCase.execute(new DailyForecastsObserver(),
                GetDailyForecasts.Params.getParams(true));
    }

    public void onRefresh() {
        isLoading.set(true);
        getDailyForecastsUseCase.execute(new DailyForecastsObserver(),
                GetDailyForecasts.Params.getParams(false));
    }

    public ObservableField<List<Forecast>> getDailyForecasts() {
        return dailyForecasts;
    }

    public WeatherAdapter getAdapter() {
        return adapter;
    }

    public ObservableBoolean getIsLoading() {
        return isLoading;
    }

    private class DailyForecastsObserver extends DisposableSingleObserver<List<Forecast>> {

        @Override
        public void onSuccess(List<Forecast> dailyForecastList) {
            dailyForecasts.set(dailyForecastList);
            isLoading.set(false);
        }

        @Override
        public void onError(Throwable e) {

        }
    }
}
