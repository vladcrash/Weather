package ru.vladislav.razgonyaev.data.di;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.vladislav.razgonyaev.data.R;
import ru.vladislav.razgonyaev.data.db.WeatherDatabase;


@Module
public class DatabaseModule {

    @Provides
    @Singleton
    public WeatherDatabase provideWeatherDatabase(Context context) {
        return Room.databaseBuilder(context, WeatherDatabase.class, context.getString(R.string.database_name))
                .build();
    }
}
