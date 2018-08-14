package ru.vladislav.razgonyaev.domain.repository;

import java.util.List;

import io.reactivex.Single;
import ru.vladislav.razgonyaev.domain.model.Forecast;
import ru.vladislav.razgonyaev.domain.model.Hour;


public interface ForecastRepository {

    Single<List<Forecast>> getDailyForecasts(Boolean isRefresh);
    Single<List<Hour>> getHourlyForecasts(Long dayId);
}
