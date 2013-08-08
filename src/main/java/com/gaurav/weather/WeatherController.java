package com.gaurav.weather;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gaurav
 * Date: 6/8/13
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class WeatherController {


    private WeatherInputService weatherInputService = new WeatherInputService();

    public List<String> getWeatherDetails() {


        WeatherInput weatherInput = weatherInputService.getWeatherInput()   ;

        List<String> weatherDetails = forecastWeather(weatherInput);


         return weatherDetails;

    }

    private List<String> forecastWeather(WeatherInput weatherInput) {
        List<String> weatherDetails = new ArrayList<String>();

        if(weatherInput.isDay())
            weatherDetails.add("Sun");
        if(weatherInput.isNight())
            weatherDetails.add("Moon");
        if(weatherInput.isCloud())
            weatherDetails.add("Cloud");
        if (weatherInput.isRainy())
            weatherDetails.add("Raining");
        return weatherDetails;
    }


    public void setWeatherInputService(WeatherInputService weatherInputService) {
        this.weatherInputService = weatherInputService;
    }
}
