package ru.vladislav.razgonyaev.weather.ui.weatherdetail;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ru.vladislav.razgonyaev.domain.model.Hour;
import ru.vladislav.razgonyaev.weather.R;
import ru.vladislav.razgonyaev.weather.databinding.ListItemWeatherDetailBinding;


public class WeatherDetailAdapter extends RecyclerView.Adapter<WeatherDetailAdapter.DetailInfoViewHolder> {

    private List<Hour> hourlyForecasts;

    @NonNull
    @Override
    public DetailInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new DetailInfoViewHolder(inflater.inflate(R.layout.list_item_weather_detail,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DetailInfoViewHolder holder, int position) {
        Hour hourlyForecast = hourlyForecasts.get(position);
        holder.setHourlyForecast(hourlyForecast);
    }

    @Override
    public void onViewAttachedToWindow(@NonNull DetailInfoViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull DetailInfoViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    @Override
    public int getItemCount() {
        return hourlyForecasts != null ? hourlyForecasts.size() : 0;
    }

    public void setHourlyForecasts(List<Hour> hourlyForecasts) {
        this.hourlyForecasts = hourlyForecasts;
        notifyDataSetChanged();
    }

    public class DetailInfoViewHolder extends RecyclerView.ViewHolder {

        private ListItemWeatherDetailBinding binding;

        public DetailInfoViewHolder(View itemView) {
            super(itemView);
            bind();
        }

        public void setHourlyForecast(Hour hourlyForecast) {
            setViewModel(new WeatherDetailItemViewModel(hourlyForecast));
        }

        public void setViewModel(WeatherDetailItemViewModel viewModel) {
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
    }
}
