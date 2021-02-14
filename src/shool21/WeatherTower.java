package shool21;

class WeatherTower extends Tower {
    private static WeatherTower weatherTower;
    private static WeatherProvider weatherProvider = WeatherProvider.getProvider();

    private WeatherTower() {
    }

    public String getWeather(Coordinates coordinates) {
        return weatherProvider.getCurrentWeather(coordinates);
    }

    public void simulate() {
        changeWeather();
    }

    private void changeWeather() {
        this.conditionsChanged();
    }

    public static WeatherTower getWeatherTower() {
        if (weatherTower == null) {
            weatherTower = new WeatherTower();
        }
        return weatherTower;
    }
}