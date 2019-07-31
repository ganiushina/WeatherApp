package com.example.weatherapp;

import java.io.Serializable;

public final class MainPresenter implements Serializable {

    private static MainPresenter instance = null;

    private static final Object syncObj = new Object();

    private String temperature;
    private String water;
    private String wet;
    private String wind;

    private String newCity;

    private boolean temperValue;
    private boolean waterValue;
    private boolean wetValue;
    private boolean windValue;


    public void setTemperValue(boolean temperValue) {
        this.temperValue = temperValue;
    }

    public void setWaterValue(boolean waterValue) {
        this.waterValue = waterValue;
    }

    public void setWetValue(boolean wetValue) {
        this.wetValue = wetValue;
    }

    public void setWindValue(boolean windValue) {
        this.windValue = windValue;
    }

    public String getNewCity() {
        return newCity;
    }

    public void setNewCity(String newCity) {
        this.newCity = newCity;
    }

    private MainPresenter(){
        temperature = "";
        water = "";
        wet = "";
        wind = "";
        newCity = "";
        temperValue = false;
        waterValue = false;
        wetValue = false;
        windValue = false;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getWet() {
        return wet;
    }

    public void setWet(String wet) {
        this.wet = wet;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }


    public static MainPresenter getInstance(){
        synchronized (syncObj) {
            if (instance == null) {
                instance = new MainPresenter();
            }
            return instance;
        }
    }
}
