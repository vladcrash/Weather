package ru.vladislav.razgonyaev.data.network;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import ru.vladislav.razgonyaev.domain.model.Weather;


public interface WeatherWebService {

    @Headers("X-Yandex-API-Key: " + ApiConstants.KEY)
    @GET("forecast?lat=" + ApiConstants.LATITUDE + "&lon=" + ApiConstants.LONGITUDE +
            "&hours=true&limit=" + ApiConstants.NUMBER_OF_DAYS)
    Single<Weather> getWeather();
}
