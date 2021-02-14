package shool21;

import shool21.aircraft.Aircraft;

import java.util.logging.Logger;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    private Logger logger = Logger.getLogger("Logger");

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();

        switch (this.weatherTower.getWeather(this.coordinates)) {
            case "RAIN":
                coordinates = new Coordinates(longitude, latitude + 5, height);
                logger.info(toString() + " \u26C8 One day it started raining, and it didn't quit for four months.");
                break;
            case "FOG":
                coordinates = new Coordinates(longitude, latitude + 1, height);
                logger.info(toString() + " \uD83C\uDF2B There is something in the fog.");
                break;
            case "SUN":
                coordinates = new Coordinates(longitude, latitude + 10, height + 2);
                logger.info(toString() + " \uD83C\uDF1E The sun is rising.");
                break;
            case "SNOW":
                coordinates = new Coordinates(longitude, latitude, height - 7);
                logger.info(toString() + " \u1F3C You know nothing, Jon Snow");
                break;
        }
    }

    // Можно перенсти в AirCraft, требования UML
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }

    @Override
    public String toString() {
        return "shool21.JetPlane " + super.toString();
    }
}
