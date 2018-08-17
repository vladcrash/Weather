package ru.vladislav.razgonyaev.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ru.vladislav.razgonyaev.data.db.dao.ForecastDao;
import ru.vladislav.razgonyaev.data.db.dao.HourDao;
import ru.vladislav.razgonyaev.domain.model.Forecast;
import ru.vladislav.razgonyaev.domain.model.Hour;
import ru.vladislav.razgonyaev.domain.model.Weather;


@Database(entities = {Weather.class, Forecast.class, Hour.class}, version = 1, exportSchema = false)
public abstract class WeatherDatabase extends RoomDatabase {

    public abstract ForecastDao forecastDao();
    public abstract HourDao hourDao();
}
