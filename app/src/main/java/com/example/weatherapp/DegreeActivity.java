package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DegreeActivity extends AppCompatActivity {

    List<City> citys = new ArrayList<>();
    private RecyclerView recyclerView;
    private CityAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_degree);

        recyclerView = findViewById(R.id.recyclerView);
        mAdapter = new CityAdapter(citys);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        populateCityDetails();
        mAdapter.notifyDataSetChanged();

        final Parcel parcel = (Parcel) getIntent().getExtras().getSerializable("degree");

        TextView textView_degree = findViewById(R.id.textView10);
        TextView textView_water = findViewById(R.id.textView11);
        TextView textView_wet = findViewById(R.id.textView13);
        TextView textView_wind = findViewById(R.id.textView14);
        TextView textView_city = findViewById(R.id.textView12);
        textView_degree.setText(parcel.getTemperature());
        textView_water.setText(parcel.getWater());
        textView_wet.setText(parcel.getWet());
        textView_wind.setText(parcel.getWind());
        textView_city.setText(parcel.getCityName());


        Button buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentResult = new Intent();
                intentResult.putExtra("cityNew", parcel.getNewCity());
                setResult(RESULT_OK, intentResult);
                finish();
            }

        });

    }

    private void populateCityDetails() {
        Date currentTime = Calendar.getInstance().getTime();
        citys.add(new City("Samara", "35", currentTime));
        citys.add(new City("Moscow", "20", currentTime));
        citys.add(new City("Taganrog", "30", currentTime));
        citys.add(new City("Togliatty", "30", currentTime));
        citys.add(new City("Saratov", "33", currentTime));
        citys.add(new City("Rostov", "28", currentTime));
        citys.add(new City("Yeysk", "35", currentTime));
        citys.add(new City("London", "20", currentTime));
        citys.add(new City("Paris", "25", currentTime));
        citys.add(new City("Rome", "35", currentTime));
    }


}
