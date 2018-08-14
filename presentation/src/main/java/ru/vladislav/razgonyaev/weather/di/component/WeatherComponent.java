package ru.vladislav.razgonyaev.weather.di.component;

import dagger.Subcomponent;
import ru.vladislav.razgonyaev.weather.di.ActivityScope;
import ru.vladislav.razgonyaev.weather.di.module.WeatherModule;
import ru.vladislav.razgonyaev.weather.ui.weather.WeatherActivity;


@ActivityScope
@Subcomponent(modules = {WeatherModule.class})
public interface WeatherComponent {

    @Subcomponent.Builder
    interface Builder {
        WeatherComponent.Builder weatherModule(WeatherModule weatherModule);
        WeatherComponent build();
    }

    void inject(WeatherActivity weatherActivity);
}
