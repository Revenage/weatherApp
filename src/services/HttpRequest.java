package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {

    String url = "http://api.openweathermap.org/data/2.5/forecast/daily?id=706483&units=metric&cnt=7&appid=27f693b51368734b5e94c3fd9972b4db";

    // HTTP GET request
    /*public HttpRequest(String url) {
        this.url = url;
    }*/

    public WeatherData getData() throws IOException {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = con.getResponseCode();

        //System.out.println("\nSending 'GET' request to URL : " + url);
        //System.out.println("Response Code : " + responseCode);

        String inputLine;
        StringBuffer response = new StringBuffer();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream())
        );

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print result
        //System.out.println(response.toString());

        return new WeatherData(response.toString());
    }
}