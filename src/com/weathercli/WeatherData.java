package com.weathercli;

public class WeatherData {
    private final String city;
    private final double temperature;
    private final int humidity;
    private final String description;

    public WeatherData(String city, double temperature, int humidity, String description) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.description = description;
    }
    public String getCity() {
        return city;
    }
    public double getTemperature() {
        return temperature;
    }
    public int getHumidity() {
        return humidity;
    }
    public String getDescription() {
        return description;
    }
}
