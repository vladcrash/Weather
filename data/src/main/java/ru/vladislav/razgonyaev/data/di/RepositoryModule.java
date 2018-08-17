package ru.vladislav.razgonyaev.data.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.vladislav.razgonyaev.data.db.WeatherDatabase;
import ru.vladislav.razgonyaev.data.network.WeatherWebService;
import ru.vladislav.razgonyaev.data.repository.ForecastRepositoryImpl;
import ru.vladislav.razgonyaev.domain.repository.ForecastRepository;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public ForecastRepository provideForecastRepository(WeatherWebService weatherWebService, WeatherDatabase weatherDatabase) {
        return new ForecastRepositoryImpl(weatherWebService, weatherDatabase);
    }
}
