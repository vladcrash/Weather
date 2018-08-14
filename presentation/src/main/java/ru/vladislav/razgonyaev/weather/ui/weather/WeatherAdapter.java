package ru.vladislav.razgonyaev.weather.ui.weather;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;
import java.util.List;

import ru.vladislav.razgonyaev.domain.model.Forecast;
import ru.vladislav.razgonyaev.weather.R;
import ru.vladislav.razgonyaev.weather.databinding.ListItemWeatherBinding;
import ru.vladislav.razgonyaev.weather.ui.weatherdetail.WeatherDetailActivity;


public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private List<Forecast> dailyForecasts;

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new WeatherViewHolder(inflater.inflate(R.layout.list_item_weather, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        Forecast dailyForecast = dailyForecasts.get(position);
        holder.setDailyForecast(dailyForecast);
    }

    @Override
    public void onViewAttachedToWindow(@NonNull WeatherViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull WeatherViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    @Override
    public int getItemCount() {
        return dailyForecasts != null ? dailyForecasts.size() : 0;
    }

    public void setDailyForecasts(List<Forecast> dailyForecasts) {
        this.dailyForecasts = dailyForecasts;
        notifyDataSetChanged();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private WeakReference<Context> context;
        private Long forecastId;
        private ListItemWeatherBinding binding;

        public WeatherViewHolder(View itemView) {
            super(itemView);
            context = new WeakReference<>(itemView.getContext());
            itemView.setOnClickListener(this);
            bind();
        }

        public void setDailyForecast(Forecast dailyForecast) {
            forecastId = dailyForecast.getId();
            setViewModel(new WeatherItemViewModel(dailyForecast));
        }

        public void setViewModel(WeatherItemViewModel viewModel) {
            if (binding != null) {
                binding.setViewModel(viewModel);
            }
        }

        public void bind() {
            if (binding == null) {
                binding = DataBindingUtil.bind(itemView);
            }
        }

        public void unbind() {
            if (binding != null) {
                binding.unbind();
            }
        }

        @Override
        public void onClick(View v) {
            Intent intent = WeatherDetailActivity.newIntent(context.get(), forecastId);
            context.get().startActivity(intent);
        }
    }
}