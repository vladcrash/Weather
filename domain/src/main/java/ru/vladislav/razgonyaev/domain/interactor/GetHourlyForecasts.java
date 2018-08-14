package ru.vladislav.razgonyaev.domain.interactor;

import java.util.List;

import io.reactivex.Single;
import ru.vladislav.razgonyaev.domain.model.Hour;
import ru.vladislav.razgonyaev.domain.repository.ForecastRepository;

public class GetHourlyForecasts extends UseCase<List<Hour>, Long> {

    private ForecastRepository repository;

    public GetHourlyForecasts(ForecastRepository repository) {
        this.repository = repository;
    }

    @Override
    public Single<List<Hour>> run(Long dayId) {
        return repository.getHourlyForecasts(dayId);
    }
}
