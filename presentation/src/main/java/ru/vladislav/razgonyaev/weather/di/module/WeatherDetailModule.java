package ru.vladislav.razgonyaev.weather.di.module;

import dagger.Module;
import dagger.Provides;
import ru.vladislav.razgonyaev.domain.interactor.GetHourlyForecasts;
import ru.vladislav.razgonyaev.domain.repository.ForecastRepository;
import ru.vladislav.razgonyaev.weather.di.ActivityScope;
import ru.vladislav.razgonyaev.weather.ui.weather.WeatherViewModelFactory;
import ru.vladislav.razgonyaev.weather.ui.weatherdetail.WeatherDetailAdapter;
import ru.vladislav.razgonyaev.weather.ui.weatherdetail.WeatherDetailViewModel;
import ru.vladislav.razgonyaev.weather.ui.weatherdetail.WeatherDetailViewModelFactory;

@Module
public class WeatherDetailModule {

    @Provides
    @ActivityScope
    public WeatherDetailViewModelFactory provideWeatherViewModelFactory(WeatherDetailViewModel viewModel) {
        return new WeatherDetailViewModelFactory(viewModel);
    }

    @Provides
    @ActivityScope
    public WeatherDetailViewModel provideWeatherDetailViewModel(WeatherDetailAdapter adapter, GetHourlyForecasts getHourlyForecastsUseCase) {
        return new WeatherDetailViewModel(adapter, getHourlyForecastsUseCase);
    }

    @Provides
    @ActivityScope
    public GetHourlyForecasts provideGetHourlyForecasts(ForecastRepository repository) {
        return new GetHourlyForecasts(repository);
    }

    @Provides
    @ActivityScope
    public WeatherDetailAdapter provideWeatherDetailAdapter() {
        return new WeatherDetailAdapter();
    }
}
