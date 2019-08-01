package com.example.weatherapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherapp.model.WeatherRequest;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity implements MyBottonSheetDialog.BottomSheetListener {

    private static final int REQUEST_CODE_ACTIVITY2 = 1;
    public static final String NAME = "degree";

    private Parcel parcel;
    private ImageView imageViewButtonSamara;
    private ImageView imageViewButtonMoscow;
    private ImageView imageViewButtonPiter;
    private ImageView imageViewButtonAddCity;

    private static final String TAG = "myLogs";

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    MyBottonSheetDialog bottonSheetDialog = new MyBottonSheetDialog();
                    bottonSheetDialog.show(getSupportFragmentManager(), "Диалог");
                    return true;
            }
            return false;
        }
    };


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


    public void setTemper(final ImageView imageView){

        String cityName = "";
        if (imageView == imageViewButtonSamara){
            cityName = "Samara";
        }
        if (imageView == imageViewButtonMoscow){
            cityName = "Moscow";
        }
        if (imageView.equals(findViewById(R.id.imageView2))) {
            cityName = "Sankt-Peterburg";
        }
        final String WEATHER_URL = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s,ru&appid=", cityName);

        try {
            final URL uri = new URL(WEATHER_URL + BuildConfig.WEATHER_API_KEY);
            final Handler handler = new Handler(); // Запоминаем основной поток
            new Thread(new Runnable() {
                public void run() {
                    HttpsURLConnection urlConnection = null;
                    try {
                        urlConnection = (HttpsURLConnection) uri.openConnection();
                        urlConnection.setRequestMethod("GET"); // установка метода получения данных -GET
                        urlConnection.setReadTimeout(10000); // установка таймаута - 10 000 миллисекунд
                        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream())); // читаем  данные в поток
                        String result = getLines(in);
                        // преобразование данных запроса в модель
                        Gson gson = new Gson();
                        final WeatherRequest weatherRequest = gson.fromJson(result, WeatherRequest.class);
                        // Возвращаемся к основному потоку
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                displayWeather(weatherRequest);
                            }
                        });
                    } catch (Exception e) {
                        Log.e(TAG, "Fail connection", e);
                        e.printStackTrace();
                    } finally {
                        if (null != urlConnection) {
                            urlConnection.disconnect();
                        }
                    }
                }
            }).start();
        } catch (MalformedURLException e) {
            Log.e(TAG, "Fail URI", e);
            e.printStackTrace();
        }
    }

    private String getLines(BufferedReader in) {
        return in.lines().collect(Collectors.joining("\n"));
    }

    private void displayWeather(WeatherRequest weatherRequest){
        Intent intent = new Intent(getApplicationContext(), DegreeActivity.class);
        parcel.setTemperature(String.format("%f2", weatherRequest.getMain().getTemp()));
        parcel.setWater("+20");
        parcel.setWet(String.format("%d", weatherRequest.getMain().getHumidity()));
        parcel.setWind(String.format("%d", weatherRequest.getWind().getSpeed()));
        parcel.setCityName(weatherRequest.getName());
        parcel.setPressure(String.format("%d", weatherRequest.getMain().getPressure()));
        intent.putExtra(NAME, parcel);
        startActivityForResult(intent, REQUEST_CODE_ACTIVITY2);
    }

    @Override
    public void onBottomClicked(String text) {
        mTextMessage.setText(text);
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
           // TextView textViewCity = findViewById(R.id.editText3);
           // textViewCity.setText(data.getStringExtra("cityNew"));
        }
    }

}
