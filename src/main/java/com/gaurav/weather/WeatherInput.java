package com.gaurav.weather;

/**
 * Created with IntelliJ IDEA.
 * User: gaurav
 * Date: 6/8/13
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class WeatherInput {

    private boolean day;
    private boolean night;
    private boolean cloud;
    private boolean rainy;

    public boolean isDay() {
        return day;
    }

    public void setDay(boolean day) {
        this.day = day;
    }

    public boolean isNight() {
        return night;
    }

    public void setNight(boolean night) {
        this.night = night;
    }

    public boolean isCloud() {
        return cloud;
    }

    public void setCloud(boolean cloud) {
        this.cloud = cloud;
    }

    public boolean isRainy() {
        return rainy;
    }

    public void setRainy(boolean rainy) {
        this.rainy = rainy;
    }
}
