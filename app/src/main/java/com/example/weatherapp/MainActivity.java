package com.example.weatherapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MainPresenter presenter;
    ImageView imageViewButtonSamara;
    ImageView imageViewButtonMoscow;
    ImageView imageViewButtonPiter;

    String instanceState;

    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        Log.d(TAG, "найдем View-элементы");
        imageViewButtonSamara = findViewById(R.id.imageView);
        imageViewButtonMoscow = findViewById(R.id.imageView2);
        imageViewButtonPiter = findViewById(R.id.imageView3);

        final CheckBox checkBoxDegree = findViewById(R.id.checkBox);
        final CheckBox checkBoxWind = findViewById(R.id.checkBox2);
        final CheckBox checkBoxWater = findViewById(R.id.checkBox3);
        final CheckBox checkBoxWet = findViewById(R.id.checkBox4);

        presenter = MainPresenter.getInstance();

        imageViewButtonSamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTemper(imageViewButtonSamara);
                Log.d(TAG, "ButtonSamara");
            }
        });

        imageViewButtonMoscow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTemper(imageViewButtonMoscow);
                Log.d(TAG, "ButtonMoscow");
            }
        });

        imageViewButtonPiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTemper(imageViewButtonPiter);
                Log.d(TAG, "ButtonPiter");
            }
        });

        checkBoxDegree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setTemperValue(checkBoxDegree.isChecked());
            }
        });

        checkBoxWind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setTemperValue(checkBoxWind.isChecked());
            }
        });

        checkBoxWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setTemperValue(checkBoxWater.isChecked());
            }
        });

        checkBoxWet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setTemperValue(checkBoxWet.isChecked());
            }
        });
    }

    public void setTemper(ImageView imageView){
        setContentView(R.layout.activiti_degree);
        TextView textView_degree = findViewById(R.id.textView10);
        TextView textView_water = findViewById(R.id.textView11);
        TextView textView_wet = findViewById(R.id.textView13);
        TextView textView_wind = findViewById(R.id.textView14);
        if (imageView == imageViewButtonSamara){
            presenter.setTemperature("+35");
            presenter.setWater("+23");
            presenter.setWet("80%");
            presenter.setWind("5 м/с");
        }
        if (imageView == imageViewButtonMoscow){
            presenter.setTemperature("+25");
            presenter.setWater("+20");
            presenter.setWet("75%");
            presenter.setWind("10 м/с");
        }
        if (imageView.equals(findViewById(R.id.imageView2))){
            presenter.setTemperature("+20");
            presenter.setWater("+18");
            presenter.setWet("90%");
            presenter.setWind("15 м/с");

        }
        textView_degree.setText(presenter.getTemperature());
        textView_water.setText(presenter.getWater());
        textView_wet.setText(presenter.getWet());
        textView_wind.setText(presenter.getWind());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), " onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), " onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), " onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), " onDestroy()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(getApplicationContext(), " onSaveInstanceState()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(), " onRestoreInstanceState()", Toast.LENGTH_SHORT).show();
    }

}
