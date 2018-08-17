package ru.vladislav.razgonyaev.weather.di.module;

import dagger.Module;
import dagger.Provides;
import ru.vladislav.razgonyaev.domain.interactor.GetDailyForecasts;
import ru.vladislav.razgonyaev.domain.repository.ForecastRepository;
import ru.vladislav.razgonyaev.weather.di.ActivityScope;
import ru.vladislav.razgonyaev.weather.ui.weather.WeatherAdapter;
import ru.vladislav.razgonyaev.weather.ui.weather.WeatherViewModel;
import ru.vladislav.razgonyaev.weather.ui.weather.WeatherViewModelFactory;

@Module
public class WeatherModule {

    @Provides
    @ActivityScope
    public WeatherViewModelFactory provideWeatherViewModelFactory(WeatherViewModel viewModel) {
        return new WeatherViewModelFactory(viewModel);
    }

    @Provides
    @ActivityScope
    public WeatherViewModel provideWeatherViewModel(WeatherAdapter adapter, GetDailyForecasts getDailyForecastsUseCase) {
        return new WeatherViewModel(adapter, getDailyForecastsUseCase);
    }

    @Provides
    @ActivityScope
    public WeatherAdapter provideWeatherAdapter() {
        return new WeatherAdapter();
    }

    @Provides
    @ActivityScope
    public GetDailyForecasts provideGetDailyForecasts(ForecastRepository repository) {
        return new GetDailyForecasts(repository);
    }
}
