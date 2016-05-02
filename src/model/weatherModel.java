package model;

/**
 * Created by revenage on 5/2/16.
 */
public class WeatherModel {
    int dayOfMonth;
    double dayTemp;
    double nigthTemp;
    double morningTemp;
    double eveningTemp;
    double pressure;
    long humidity;
    String wether;
    String typeOfWether;
    double windSpeed;
    long windDirection;
    long cloudiness;

    public WeatherModel(int dayOfMonth, double dayTemp, double nigthTemp, double morningTemp, double eveningTemp, double pressure, long humidity, String wether, String typeOfWether, double windSpeed, long windDirection, long cloudiness) {
        this.dayOfMonth = dayOfMonth;
        this.dayTemp = dayTemp;
        this.nigthTemp = nigthTemp;
        this.morningTemp = morningTemp;
        this.eveningTemp = eveningTemp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.wether = wether;
        this.typeOfWether = typeOfWether;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.cloudiness = cloudiness;
    }
};
