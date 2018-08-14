package ru.vladislav.razgonyaev.weather.di.module;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.vladislav.razgonyaev.data.db.WeatherDatabase;
import ru.vladislav.razgonyaev.weather.R;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    public WeatherDatabase provideWeatherDatabase(Context context) {
        return Room.databaseBuilder(context, WeatherDatabase.class, context.getString(R.string.database_name))
                .build();
    }
}
