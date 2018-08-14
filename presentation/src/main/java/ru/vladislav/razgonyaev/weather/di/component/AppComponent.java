package ru.vladislav.razgonyaev.weather.di.component;

import javax.inject.Singleton;

import dagger.Component;
import ru.vladislav.razgonyaev.weather.di.module.AppModule;
import ru.vladislav.razgonyaev.weather.di.module.DatabaseModule;
import ru.vladislav.razgonyaev.weather.di.module.NetworkModule;
import ru.vladislav.razgonyaev.weather.di.module.RepositoryModule;

@Singleton
@Component(modules = {AppModule.class, DatabaseModule.class, NetworkModule.class,
        RepositoryModule.class})
public interface AppComponent {

    WeatherComponent.Builder weatherComponentBuilder();
    WeatherDetailComponent.Builder weatherDetailComponentBuilder();
}
