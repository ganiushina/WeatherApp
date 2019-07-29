package com.example.weatherapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class ArmsPic extends Fragment {

    boolean isExistCoatOfArms;  // Можно ли расположить рядом фрагмент с гербом
    //+ Меняем текущую позицию на объект Parcel
    Parcel currentParcel;       // Текущая посылка (номер города и название)

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewHierarchy = inflater.inflate(R.layout.arms, container, false);
        return viewHierarchy;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    //    initList(view);
    }

    private void initList(View view) {
        LinearLayout layoutView = (LinearLayout) view;
        String[] cities = getResources().getStringArray(R.array.cities);

        LayoutInflater ltInflater = getLayoutInflater();

        // В этом цикле создаем элемент TextView,
        // заполняем его значениями,
        // и добавляем на экран.
//        // Кроме того, создаем обработку касания на элемент
//        for (int i = 0; i < cities.length; i++) {
//            String city = cities[i];
//          //  View item = ltInflater.inflate(R.layout.item, layoutView, false);
//            TextView tv = new TextView(getContext());
//            tv.setText(city);
//            tv.setTextSize(30);
//            layoutView.addView(tv);
//            final int fi = i;
//            tv.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    //+ Теперь опираемся на Parcel, а не на текущую позицию
//                    currentParcel = new Parcel();
//                    currentParcel.setCityName(getResources().getStringArray(R.array.cities)[fi]);
//                    currentParcel.setImageIndex(fi);
//                    showCoatOfArms(currentParcel);
//                }
//            });
//        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Определение, можно ли будет расположить рядом герб в другом фрагменте
        isExistCoatOfArms = getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;

        // Если это не первое создание, то восстановим текущую позицию
        //+ Здесь также востанавливаем Parcel
        if (savedInstanceState != null) {
            // Восстановление текущей позиции.
            currentParcel = (Parcel) savedInstanceState.getSerializable("degree");
        } else {
            //+ Если воcстановить не удалось, то сделаем объект с первым индексом
            currentParcel = new Parcel();
            currentParcel.setCityName(getResources().getStringArray(R.array.cities)[0]);
            currentParcel.setImageIndex(0);
        }

        // Если можно нарисовать рядом герб, то сделаем это
        if (isExistCoatOfArms) {
            showCoatOfArms(currentParcel);
        }
    }
//
    // Сохраним текущую позицию (вызывается перед выходом из фрагмента)
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        //+ Также меняем текущую позицию на Parcel
        outState.putSerializable("degree", currentParcel);
        super.onSaveInstanceState(outState);
    }


//    private void changeData(WeatherDetailsData data) {
//        Fragment fragment = DetailsWeatherFragment.create(data);
//        getFragmentManager().beginTransaction().replace(R.id.weather_details_container, fragment) .commit();
//        showForecast(null, data.getForecast());
//    }

    private void showCoatOfArms(Parcel parcel) {
//
//                if (isExistCoatOfArms) {
//            // Проверим, что фрагмент с гербом существует в activity
//            CoatOfArmsFragment detail = (CoatOfArmsFragment)
//                    getFragmentManager().findFragmentById(R.id.coat_of_arms);
//            // Если есть необходимость, то выведем герб
//            //+ Здесь также применяем Parcel
//            if (detail == null || detail.getParcel().getImageIndex() != parcel.getImageIndex()) {
//                // Создаем новый фрагмент с текущей позицией для вывода герба
//                detail = CoatOfArmsFragment.create(parcel);
//
//                // Выполняем транзакцию по замене фрагмента
//                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                ft.replace(R.id.coat_of_arms, detail);  // замена фрагмента
//                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//                ft.commit();
//            }
//        } else {
//            // Если нельзя вывести герб рядом, откроем вторую activity
//            Intent intent = new Intent();
//            intent.setClass(getActivity(), CoatOfArmsActivity.class);
//            //+ и передадим туда Parcel
//            intent.putExtra(PARCEL, parcel);
//            startActivity(intent);


//        }
    }

}
