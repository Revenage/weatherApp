import org.json.simple.parser.ParseException;
//import services.WeatherData;
import services.HttpRequest;
import ui.WeatherFrame;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        new WeatherFrame();
        HttpRequest respond = new HttpRequest();

        System.out.println(respond.getData());
        /*WeatherData weatherData = new WeatherData();
        int listLength = weatherData.getData().size();
        for (int i = 0; i < listLength; i++) {
            Object dayData = weatherData.getData().get(i);
            System.out.println(dayData.getDayTemp());
        }*/
    }
}
