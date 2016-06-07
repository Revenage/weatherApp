package services;

import model.DayWeather;

// try gson lib
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by revenage on 4/28/16.
 */

public class WeatherData {

    public String respond;
    JSONParser parser = new JSONParser();

    public WeatherData(String respond) {
        this.respond = respond;
    }

    public ArrayList<DayWeather> getDays() throws ParseException, IOException {
        String respondJSON;
        respondJSON = respond;

        Object obj = parser.parse(respondJSON);
        JSONObject jsonObj = (JSONObject) obj;

        JSONArray weekList = (JSONArray) jsonObj.get("list");
        ArrayList<DayWeather> weekData = new ArrayList<>();

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

            double dayTemp = getValue(tempData, "day");
            double nightTemp = getValue(tempData, "night");
            double eveningTemp = getValue(tempData, "eve");
            double morningTemp = getValue(tempData, "morn");

            double pressure = getValue(day, "pressure");
            long humidity = (long) day.get("humidity");

            JSONArray dayWeather = (JSONArray) day.get("weather");
            JSONObject dayWeatherObj = (JSONObject) dayWeather.get(0);
            String weather = (String) dayWeatherObj.get("description");
            String typeWeather = (String) dayWeatherObj.get("main");

            double windSpeed = getValue(day, "speed");
            long deg = (Long) day.get("deg");
            long clouds = (Long) day.get("clouds");

            weekData.add(new DayWeather(dayNum, dayTemp, nightTemp, morningTemp, eveningTemp, pressure, humidity, weather, typeWeather, windSpeed, deg, clouds));
        }
        return weekData;
    }

    private double getValue(JSONObject data, String name) {
        Object result = data.get(name);
        if (result instanceof Double)
            return (Double) result;
        if (result instanceof Long)
            return (Long) result;

        throw new IllegalArgumentException("tampData malformed");
    }
}
