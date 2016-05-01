package services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * Created by revenage on 4/28/16.
 */
public class WeatherData {

    String url = "http://api.openweathermap.org/data/2.5/forecast/daily?id=706483&units=metric&cnt=7&appid=27f693b51368734b5e94c3fd9972b4db";
    HttpGetData respond = new HttpGetData(url);
    JSONParser parser = new JSONParser();

    public static class DayData {
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
        int windDirection;
        int cloudiness;

        public DayData(int dayOfMonth, double dayTemp, double nigthTemp, double morningTemp, double eveningTemp, double pressure, long humidity, String wether, String typeOfWether, double windSpeed, int windDirection, int cloudiness) {
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

    public ArrayList WeatherData() throws ParseException, IOException {
        String respondJSON = respond.getData();

        Object obj = parser.parse(respondJSON);
        JSONObject jsonObj = (JSONObject) obj;

        JSONArray weekList = (JSONArray) jsonObj.get("list");
        ArrayList<DayData> weekData = new ArrayList<DayData>();

        for(int i = 0 ; i < weekList.size(); i++) {
            JSONObject day = (JSONObject) weekList.get(i);

            //date
            long dateValue = (Long) day.get("dt") ;
            Calendar dayDate = Calendar.getInstance();
            dayDate.setTimeInMillis(dateValue * 1000);
            //System.out.println(dayDate.get(Calendar.YEAR));
            //System.out.println(dayDate.get(Calendar.MONTH));

            JSONObject tempData = (JSONObject) day.get("temp");
            int dayNum = dayDate.get(Calendar.DAY_OF_MONTH);

            double dayTemp = (Double) tempData.get("day");
            double nightTemp = (Double) tempData.get("night");
            double eveningTemp = (Double) tempData.get("eve");
            double morningTemp = (Double) tempData.get("morn");

            double pressure = (Double) day.get("pressure");
            long humidity = (long) day.get("humidity");

            JSONArray dayWeather = (JSONArray) day.get("weather");
            JSONObject dayWeatherObj = (JSONObject) dayWeather.get(0);
            String weather = (String) dayWeatherObj.get("description");
            String typeWeather = (String) dayWeatherObj.get("main");

            double windSpeed = (Double) day.get("speed");
            int deg = (Integer) day.get("deg");
            int clouds = (Integer) day.get("clouds");

            weekData.add(new DayData(dayNum, dayTemp, nightTemp, morningTemp, eveningTemp, pressure, humidity, weather, typeWeather, windSpeed, deg, clouds));
        }
        return weekData;
    }




}
