package com.example.weatherapp;

import android.content.Intent;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.weatherapp.MainActivity.NAME;

public class DegreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_degree);

        final MainPresenter presenter = (MainPresenter) getIntent().getExtras().getSerializable("degree");

        TextView textView_degree = findViewById(R.id.textView10);
        TextView textView_water = findViewById(R.id.textView11);
        TextView textView_wet = findViewById(R.id.textView13);
        TextView textView_wind = findViewById(R.id.textView14);
        textView_degree.setText(presenter.getTemperature());
        textView_water.setText(presenter.getWater());
        textView_wet.setText(presenter.getWet());
        textView_wind.setText(presenter.getWind());

        Button buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentResult = new Intent();
                intentResult.putExtra("cityNew", presenter.getNewCity());
               // intentResult.putExtra("degree", presenter);
                setResult(RESULT_OK, intentResult);
                finish();
            }

        });

    }
}
