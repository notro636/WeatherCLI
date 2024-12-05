package com.weathercli;

public class WeatherDataFormatter {
    public String formatWeatherData(WeatherData data) {
        return String.format("Weather in %s:\nTemperature: %.2f°C\nHumidity: %d%%\nDescription: %s", data.getCity(), data.getTemperature(), data.getHumidity(), data.getDescription());
    }
}
