package ru.vladislav.razgonyaev.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Single;
import ru.vladislav.razgonyaev.domain.model.Forecast;

@Dao
public interface ForecastDao {

    @Query("SELECT * FROM FORECAST")
    Single<List<Forecast>> getAll();

    @Insert
    long[] insertAll(List<Forecast> forecasts);

    @Query("DELETE FROM FORECAST")
    void deleteAll();
}
