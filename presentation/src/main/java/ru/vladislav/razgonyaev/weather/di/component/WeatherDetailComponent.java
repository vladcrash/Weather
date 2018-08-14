package ru.vladislav.razgonyaev.weather.di.component;

import dagger.Subcomponent;
import ru.vladislav.razgonyaev.weather.di.ActivityScope;
import ru.vladislav.razgonyaev.weather.di.module.WeatherDetailModule;
import ru.vladislav.razgonyaev.weather.ui.weatherdetail.WeatherDetailActivity;


@ActivityScope
@Subcomponent(modules = {WeatherDetailModule.class})
public interface WeatherDetailComponent {

    @Subcomponent.Builder
    interface Builder {

        Builder weatherDetailModule(WeatherDetailModule weatherDetailModule);
        WeatherDetailComponent build();
    }

    void inject(WeatherDetailActivity weatherDetailActivity);
}
