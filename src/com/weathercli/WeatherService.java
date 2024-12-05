package com.weathercli;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WeatherService {
    private static final String API_KEY = "";
    private static final String BASE_URI = "";

    public WeatherData getWeatherData(String location) {
        try {
            String urlString = BASE_URI + "?q=" + location + "&appid=" + API_KEY + "&units=metric";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();

            return parseWeatherData(content.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private WeatherData parseWeatherData(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        String city = jsonObject.getString("name");
        JSONObject main = jsonObject.getJSONObject("main");
        double temperature = main.getDouble("temp");
        int humidity = main.getInt("humidity");
        String description = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");

        return new WeatherData(city, temperature, humidity, description);
    }
}
