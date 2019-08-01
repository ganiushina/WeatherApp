package com.example.weatherapp;

import java.io.Serializable;

public class Parcel implements Serializable {

    private String temperature;
    private String water;
    private String wet;
    private String wind;
    private String pressure;

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

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public Parcel(){
        this.temperature = "";
        this.water = "";
        this.wet = "";
        this.wind = "";
        this.newCity = "";
        this.temperValue = false;
        this.waterValue = false;
        this.wetValue = false;
        this.windValue = false;
        this.pressure = "";

    }

    private int imageIndex;
    private String cityName;

    public int getImageIndex() {
        return imageIndex;
    }

    public String getCityName() {
        return cityName;
    }

    public void setImageIndex(int imageIndex) {
        this.imageIndex = imageIndex;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

}

