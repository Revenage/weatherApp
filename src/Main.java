import org.json.simple.parser.ParseException;
import services.WeatherData;
import ui.WeatherFrame;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        new WeatherFrame();
        new WeatherData();
    }

}
