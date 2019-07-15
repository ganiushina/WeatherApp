package com.example.weatherapp;

public final class MainPresenter {

    private static MainPresenter instance = null;

    private static final Object syncObj = new Object();

    private String temperature;
    private String water;
    private String wet;
    private String wind;

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

    private MainPresenter(){
        temperature = "";
        water = "";
        wet = "";
        wind = "";
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
