package ru.vladislav.razgonyaev.data.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.vladislav.razgonyaev.data.R;
import ru.vladislav.razgonyaev.data.network.WeatherWebService;


@Module
public class NetworkModule {

    @Provides
    @Singleton
    public WeatherWebService provideWeatherWebService(Context context) {
        return new Retrofit.Builder()
                .baseUrl(context.getString(R.string.endpoint))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherWebService.class);
    }
}
