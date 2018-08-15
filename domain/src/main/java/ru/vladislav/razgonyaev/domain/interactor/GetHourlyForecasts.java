package ru.vladislav.razgonyaev.domain.interactor;

import java.util.List;

import io.reactivex.Single;
import ru.vladislav.razgonyaev.domain.model.Hour;
import ru.vladislav.razgonyaev.domain.repository.ForecastRepository;

public class GetHourlyForecasts extends UseCase<List<Hour>, GetHourlyForecasts.Params> {

    private ForecastRepository repository;

    public GetHourlyForecasts(ForecastRepository repository) {
        this.repository = repository;
    }

    @Override
    public Single<List<Hour>> run(Params params) {
        return repository.getHourlyForecasts(params.dayId);
    }

    public static final class Params {

        private final Long dayId;

        private Params(Long dayId) {
            this.dayId = dayId;
        }

        public static Params getParams(Long dayId) {
            return new Params(dayId);
        }
    }
}
