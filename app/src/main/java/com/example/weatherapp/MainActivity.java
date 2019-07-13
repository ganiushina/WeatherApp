package com.example.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        final ImageView imageViewButtonSamara = findViewById(R.id.imageView);
        imageViewButtonSamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                setTemperature(imageViewButtonSamara);
                setContentView(R.layout.activiti_degree);
                TextView textView_degree = findViewById(R.id.textView10);
                textView_degree.setText("+35");
                TextView textView_water = findViewById(R.id.textView11);
                textView_water.setText("+23");
                TextView textView_wet = findViewById(R.id.textView13);
                textView_wet.setText("80%");
                TextView textView_wind = findViewById(R.id.textView14);
                textView_wind.setText("5 м/с");
            }
        });

        final ImageView imageViewButtonMoscow = findViewById(R.id.imageView2);
        imageViewButtonMoscow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                setTemperature(imageViewButtonMoscow);
                setContentView(R.layout.activiti_degree);
                TextView textView_degree = findViewById(R.id.textView10);
                textView_degree.setText("+25");
                TextView textView_water = findViewById(R.id.textView11);
                textView_water.setText("+18");
                TextView textView_wet = findViewById(R.id.textView13);
                textView_wet.setText("80%");
                TextView textView_wind = findViewById(R.id.textView14);
                textView_wind.setText("7 м/с");
            }
        });

        final ImageView imageViewButtonPiter = findViewById(R.id.imageView3);
        imageViewButtonPiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                setTemperature(imageViewButtonPiter);
                setContentView(R.layout.activiti_degree);
                TextView textView_degree = findViewById(R.id.textView10);
                textView_degree.setText("+20");
                TextView textView_water = findViewById(R.id.textView11);
                textView_water.setText("+18");
                TextView textView_wet = findViewById(R.id.textView13);
                textView_wet.setText("80%");
                TextView textView_wind = findViewById(R.id.textView14);
                textView_wind.setText("15 м/с");
            }
        });
    }

    public void setTemperature(ImageView imageView){
        String temperature = "";
        String water = "";
        String wet = "";
        String wind = "";
        setContentView(R.layout.activiti_degree);
        TextView textView_degree = findViewById(R.id.textView10);
        TextView textView_water = findViewById(R.id.textView11);
        TextView textView_wet = findViewById(R.id.textView13);
        TextView textView_wind = findViewById(R.id.textView14);
        if (imageView == findViewById(R.id.imageView3)){ // не нашла способ сравнить view
            temperature = "+20";
            water = "+18";
            wet = "90%";
            wind = "15 м/с";
        }
        if (imageView == findViewById(R.id.imageView)){
            temperature = "+35";
            water = "+23";
            wet = "80%";
            wind = "3 м/с";
        }
        if (imageView.equals(findViewById(R.id.imageView2))){
            temperature = "+25";
            water = "+20";
            wet = "800%";
            wind = "10 м/с";
        }
        textView_degree.setText(temperature);
        textView_water.setText(water);
        textView_wet.setText(wet);
        textView_wind.setText(wind);

    }
}
