package model;

/**
 * Created by revenage on 5/2/16.
 */
public class DayWeather {
    private int dayOfMonth;
    private double dayTemp;
    private double nigthTemp;
    private double morningTemp;
    private double eveningTemp;
    private double pressure;
    private long humidity;
    private String wether;
    private String typeOfWether;
    private double windSpeed;
    private long windDirection;
    private long cloudiness;

    public DayWeather(int dayOfMonth, double dayTemp, double nigthTemp, double morningTemp, double eveningTemp, double pressure, long humidity, String wether, String typeOfWether, double windSpeed, long windDirection, long cloudiness) {
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

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public double getDayTemp() {
        return dayTemp;
    }

    public double getNigthTemp() {
        return nigthTemp;
    }

    public double getMorningTemp() {
        return morningTemp;
    }

    public double getEveningTemp() {
        return eveningTemp;
    }

    public double getPressure() {
        return pressure;
    }

    public long getHumidity() {
        return humidity;
    }

    public String getWether() {
        return wether;
    }

    public String getTypeOfWether() {
        return typeOfWether;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public long getWindDirection() {
        return windDirection;
    }

    public long getCloudiness() {
        return cloudiness;
    }
};
