package com.example.weatherapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CustomViewHolder> {

    private List<City> citys;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView cityName, year, degree;

        public CustomViewHolder(View view) {
            super(view);
            cityName = view.findViewById(R.id.cityName);
            degree = view.findViewById(R.id.degree);
            year = view.findViewById(R.id.year);
        }
    }

    public CityAdapter(List<City> citys) {
        this.citys = citys;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.city_list, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        City city = citys.get(position);
        holder.cityName.setText(city.getCityName());
        holder.degree.setText(city.getDegree());
        holder.year.setText(String.valueOf(city.getYear()));

    }

    @Override
    public int getItemCount() {
        return citys.size();
    }


}
