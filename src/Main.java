import model.DayWeather;
import org.json.simple.parser.ParseException;
import services.HttpRequest;
import services.WeatherData;
import ui.WeatherFrame;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        new WeatherFrame();

        HttpRequest respond = new HttpRequest();
        WeatherData weatherData = respond.getData();
        ArrayList<DayWeather> days = weatherData.getDays();
        for (DayWeather dayData : days) {
            System.out.print(dayData.getDayTemp());
            System.out.print(" ");
            System.out.println(dayData.getMonthDay());
        }
    }
}
