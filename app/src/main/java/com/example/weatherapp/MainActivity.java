package com.example.weatherapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    private static final int REQUEST_CODE_ACTIVITY2 = 1;
    public static final String NAME = "degree";

    private Parcel parcel;
    private ImageView imageViewButtonSamara;
    private ImageView imageViewButtonMoscow;
    private ImageView imageViewButtonPiter;
    private ImageView imageViewButtonAddCity;

    private static final String TAG = "myLogs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);



        imageViewButtonSamara = findViewById(R.id.imageView);
        imageViewButtonMoscow = findViewById(R.id.imageView2);
        imageViewButtonPiter = findViewById(R.id.imageView3);
        imageViewButtonAddCity = findViewById(R.id.imageView5);

        final CheckBox checkBoxDegree = findViewById(R.id.checkBox);
        final CheckBox checkBoxWind = findViewById(R.id.checkBox2);
        final CheckBox checkBoxWater = findViewById(R.id.checkBox3);
        final CheckBox checkBoxWet = findViewById(R.id.checkBox4);

        parcel = new Parcel();

        imageViewButtonSamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTemper(imageViewButtonSamara);
                Log.d(TAG, "ButtonSamara");
            }
        });

        Button go = findViewById(R.id.button);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://ru.wikipedia.org/wiki/%D0%A1%D0%B0%D0%BC%D0%B0%D1%80%D0%B0";
                Uri uri = Uri.parse(url);
                Intent browser = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(browser);
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
                parcel.setTemperValue(checkBoxDegree.isChecked());
            }
        });

        checkBoxWind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parcel.setTemperValue(checkBoxWind.isChecked());
            }
        });

        checkBoxWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parcel.setTemperValue(checkBoxWater.isChecked());
            }
        });

        checkBoxWet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parcel.setTemperValue(checkBoxWet.isChecked());
            }
        });
    }





    public void setTemper(ImageView imageView){
        Intent intent = new Intent(getApplicationContext(), DegreeActivity.class);
        TextView textViewCity = findViewById(R.id.editText3);
        String newCity = textViewCity.getText().toString();
        parcel.setNewCity(newCity);
        if (imageView == imageViewButtonSamara){
            parcel.setTemperature("+35");
            parcel.setWater("+23");
            parcel.setWet("80%");
            parcel.setWind("5 м/с");
            parcel.setCityName("Самара");
        }
        if (imageView == imageViewButtonMoscow){
            parcel.setTemperature("+25");
            parcel.setWater("+20");
            parcel.setWet("75%");
            parcel.setWind("10 м/с");
            parcel.setCityName("Москва");
        }
        if (imageView.equals(findViewById(R.id.imageView2))){
            parcel.setTemperature("+20");
            parcel.setWater("+18");
            parcel.setWet("90%");
            parcel.setWind("15 м/с");
            parcel.setCityName("Санкт-Петербург");

        }
        intent.putExtra(NAME, parcel);
        startActivityForResult(intent, REQUEST_CODE_ACTIVITY2);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode != REQUEST_CODE_ACTIVITY2){
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        if(resultCode == RESULT_OK){
            TextView textViewCity = findViewById(R.id.editText3);
            textViewCity.setText(data.getStringExtra("cityNew"));
        }
    }

}
