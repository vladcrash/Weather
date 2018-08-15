package ru.vladislav.razgonyaev.domain.interactor;

import java.util.List;

import io.reactivex.Single;
import ru.vladislav.razgonyaev.domain.model.Forecast;
import ru.vladislav.razgonyaev.domain.repository.ForecastRepository;

public class GetDailyForecasts extends UseCase<List<Forecast>, GetDailyForecasts.Params> {

    private ForecastRepository repository;

    public GetDailyForecasts(ForecastRepository repository) {
        this.repository = repository;
    }

    @Override
    public Single<List<Forecast>> run(Params params) {
        return repository.getDailyForecasts(params.isRefresh);
    }

    public static final class Params {

        private final boolean isRefresh;

        private Params(boolean isRefresh) {
            this.isRefresh = isRefresh;
        }

        public static Params getParams(boolean isRefresh) {
            return new Params(isRefresh);
        }
    }
}
