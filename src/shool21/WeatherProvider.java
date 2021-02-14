package shool21;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String[] weather = new String[]{"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int randomInt = ((int) (Math.random() * (coordinates.getLongitude()) + coordinates.getLatitude() + coordinates.getHeight())) % 4;
        return weather[randomInt];
    }
}
