package shool21;

import shool21.aircraft.Aircraft;

import java.util.logging.Logger;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    private Logger logger = Logger.getLogger("Logger");

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();

        switch (this.weatherTower.getWeather(this.coordinates)) {
            case "RAIN":
                coordinates = new Coordinates(longitude, latitude, height - 5);
                logger.info(toString() + " \u26C8 Rain, rain go away");
                break;
            case "FOG":
                coordinates = new Coordinates(longitude, latitude, height - 3);
                logger.info(toString() + " \uD83C\uDF2B Fog off");
                break;
            case "SUN":
                coordinates = new Coordinates(longitude + 2, latitude, height + 4);
                logger.info(toString() + " \uD83C\uDF1E Praise the sun");
                break;
            case "SNOW":
                coordinates = new Coordinates(longitude, latitude, height - 15);
                logger.info(toString() + " \u1F3C Winter is coming");
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
        return "shool21.Baloon " + super.toString();
    }
}
