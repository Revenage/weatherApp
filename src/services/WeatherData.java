package services;

import model.WeatherModel;

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

    public ArrayList getData() throws ParseException, IOException {
        String respondJSON;
        respondJSON = respond;

        Object obj = parser.parse(respondJSON);
        JSONObject jsonObj = (JSONObject) obj;

        JSONArray weekList = (JSONArray) jsonObj.get("list");
        ArrayList<WeatherModel> weekData = new ArrayList<WeatherModel>();

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
            long deg = (Long) day.get("deg");
            long clouds = (Long) day.get("clouds");

            weekData.add(new WeatherModel(dayNum, dayTemp, nightTemp, morningTemp, eveningTemp, pressure, humidity, weather, typeWeather, windSpeed, deg, clouds));
        }
        return weekData;
    }
}
