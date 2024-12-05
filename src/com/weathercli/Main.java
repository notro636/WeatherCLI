package com.weathercli;


public class Main {
    public static void main(String[] args) {
        UserInputHandler inputHandler = new UserInputHandler();
        String location = inputHandler.getUserInput();

        WeatherService weatherService = new WeatherService();
        WeatherData weatherData = weatherService.getWeatherData(location);

        if (weatherData != null) {
            WeatherDataFormatter formatter = new WeatherDataFormatter();
            String formattedData = formatter.formatWeatherData(weatherData);
            System.out.println(formattedData);
        } else {
            System.err.println("Unable to fetch weather data. Please try again.");
        }
    }
}