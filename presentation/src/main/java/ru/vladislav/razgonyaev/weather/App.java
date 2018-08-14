package ru.vladislav.razgonyaev.weather;

import android.app.Application;
import android.content.Context;

import ru.vladislav.razgonyaev.weather.di.component.AppComponent;
import ru.vladislav.razgonyaev.weather.di.component.DaggerAppComponent;
import ru.vladislav.razgonyaev.weather.di.component.WeatherComponent;
import ru.vladislav.razgonyaev.weather.di.component.WeatherDetailComponent;
import ru.vladislav.razgonyaev.weather.di.module.AppModule;
import ru.vladislav.razgonyaev.weather.di.module.WeatherDetailModule;
import ru.vladislav.razgonyaev.weather.di.module.WeatherModule;


public class App extends Application {

    private AppComponent appComponent;
    private WeatherComponent weatherComponent;
    private WeatherDetailComponent weatherDetailComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = buildAppComponent();
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public WeatherComponent plusWeatherComponent() {
        if (weatherComponent == null) {
            weatherComponent = appComponent
                    .weatherComponentBuilder()
                    .weatherModule(new WeatherModule())
                    .build();
        }
        return weatherComponent;
    }

    public void releaseWeatherComponent() {
        weatherComponent = null;
    }

    public WeatherDetailComponent plusWeatherDetailComponent() {
        if (weatherDetailComponent == null) {
            weatherDetailComponent = appComponent
                    .weatherDetailComponentBuilder()
                    .weatherDetailModule(new WeatherDetailModule())
                    .build();
        }
        return weatherDetailComponent;
    }

    public void releaseWeatherDetailComponent() {
        weatherDetailComponent = null;
    }

    private AppComponent buildAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
