package ru.vladislav.razgonyaev.domain.interactor;

import java.util.List;

import io.reactivex.Single;
import ru.vladislav.razgonyaev.domain.model.Forecast;
import ru.vladislav.razgonyaev.domain.repository.ForecastRepository;

public class GetDailyForecasts extends UseCase<List<Forecast>, Boolean> {

    private ForecastRepository repository;

    public GetDailyForecasts(ForecastRepository repository) {
        this.repository = repository;
    }

    @Override
    public Single<List<Forecast>> run(Boolean isRefresh) {
        return repository.getDailyForecasts(isRefresh);
    }
}
