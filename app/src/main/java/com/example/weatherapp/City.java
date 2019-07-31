package com.example.weatherapp;

import java.util.Date;

public class City {
    private String cityName;
    private String degree;
    private Date year;

    public City(String cityName, String degree, Date year) {
        this.cityName = cityName;
        this.degree = degree;
        this.year = year;

    }

    public String getCityName() {
        return cityName;
    }

    public String getDegree() {
        return degree;
    }

    public Date getYear() {
        return year;
    }


}
