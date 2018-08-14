package ru.vladislav.razgonyaev.weather.di.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import ru.vladislav.razgonyaev.weather.di.module.DatabaseModule;
import ru.vladislav.razgonyaev.weather.di.module.NetworkModule;
import ru.vladislav.razgonyaev.weather.di.module.RepositoryModule;

@Singleton
@Component(modules = {DatabaseModule.class, NetworkModule.class,
        RepositoryModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder context(Context context);
        AppComponent build();
    }

    WeatherComponent.Builder weatherComponentBuilder();
    WeatherDetailComponent.Builder weatherDetailComponentBuilder();
}
