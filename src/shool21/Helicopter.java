package shool21;

import shool21.aircraft.Aircraft;

import java.util.logging.Logger;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    private Logger logger = Logger.getLogger("Logger");

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();

        switch (this.weatherTower.getWeather(this.coordinates)) {
            case "RAIN":
                coordinates = new Coordinates(longitude + 5, latitude, height);
                logger.info(toString() + " \u26C8 \"Rain\" what?");
                break;
            case "FOG":
                coordinates = new Coordinates(longitude + 1, latitude, height);
                logger.info(toString() + " \uD83C\uDF2B The fog lifted");
                break;
            case "SUN":
                coordinates = new Coordinates(longitude + 10, latitude, height + 2);
                logger.info(toString() + " \uD83C\uDF1E Is the sun coming up?");
                break;
            case "SNOW":
                coordinates = new Coordinates(longitude, latitude, height - 12);
                logger.info(toString() + " \u1F3C Danka, look at the snow. Look at the snow. Look at the snow!");
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
        return "shool21.Helicopter " + super.toString();
    }
}
