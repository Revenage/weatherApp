package services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by revenage on 4/28/16.
 */
public class WeatherData {

    String url = "http://api.openweathermap.org/data/2.5/forecast/daily?id=706483&units=metric&cnt=7&appid=27f693b51368734b5e94c3fd9972b4db";
    HttpGetData respond = new HttpGetData(url);
    JSONParser parser = new JSONParser();
    public WeatherData() throws ParseException, IOException {
        String respondJSON = respond.getData();

        Object obj = parser.parse(respondJSON);
        JSONObject jsonObj = (JSONObject) obj;

        //JSONArray weekData = new JSONArray(jsonStr);
        Object weekData = jsonObj.get("list");
        System.out.println(weekData);
        /*for (int i = 0; i < weekData.length; i++) {
            System.out.println(weekData[i]);
        }*/
        //ArrayList<String> list = new ArrayList<String>();
        /*JSONArray jsonArray = (JSONArray) weekData;
        System.out.println(jsonArray);
        if (jsonArray != null) {
            int len = jsonArray.length();
            for (int i=0;i<len;i++){
                //list.add(jsonArray.get(i).toString());
                System.out.println(jsonArray.get(i).toString());
            }
        }*/

    }




}
