public class Main {

    public static void main(String[] args) throws Exception {
        new WeatherFrame();
        WeatherData weatherData = new WeatherData();
        weatherData.requestData();
    }

}
