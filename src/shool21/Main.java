package shool21;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Main {
    private static int iterations;

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IncorrectScenarioFileException("Scenario file was not passed");
        }
        createLogger();
        WeatherTower weatherTower = WeatherTower.getWeatherTower();
        List<Flyable> airCrafts = parseScenarioFile(args[0]);
        for (Flyable airCraft : airCrafts) {
            airCraft.registerTower(weatherTower);
        }
        for (int i = 0; i < iterations; i++) {
            weatherTower.simulate();
        }
    }

    private static List<Flyable> parseScenarioFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner sc = new Scanner(file);
            List<Flyable> airCrafts = new ArrayList<>();

            iterations = Integer.parseInt(sc.nextLine());

            if (iterations <= 0) {
                throw new IncorrectScenarioFileException("The number of times the simulation is run cannot be negative or zero");
            }
            while (sc.hasNext()) {
                airCrafts.add(getAirCraft(sc.nextLine().split(" ")));
            }
            sc.close();
            return airCrafts;
        } catch (FileNotFoundException e) {
            throw new IncorrectScenarioFileException("Scenario file is not found");
        } catch (NumberFormatException e) {
            throw new IncorrectScenarioFileException("Incorrect number of times the simulation is run");
        }
    }

    private static Flyable getAirCraft(String[] aircraftData) {
        if (aircraftData.length != 5) {
            throw new AirCraftCreateException("Incorrect shool21.aircraft data");
        }
        String name = aircraftData[1];
        Coordinates coordinates = checkAndGetCoordinates(aircraftData[2], aircraftData[3], aircraftData[4]);

        return AirCraftFactory.newAircraft(aircraftData[0], name, coordinates.getLongitude(), coordinates.getLongitude(), coordinates.getHeight());
    }

    private static Coordinates checkAndGetCoordinates(String stringLongitude, String stringLatitude, String stringHeight) {
        try {
            int longitude = Integer.parseInt(stringLongitude);
            int latitude = Integer.parseInt(stringLatitude);
            int height = Math.min(Integer.parseInt(stringHeight), 100);

            if (longitude < 0 || latitude < 0 || height < 0) {
                throw new IncorrectScenarioFileException("Incorrect coordinates");
            }
            return new Coordinates(longitude, latitude, height);
        } catch (Exception e) {
            throw new IncorrectScenarioFileException("Incorrect coordinates");
        }
    }

    public static void createLogger() {
        Logger logger = Logger.getLogger("Logger");
        try {
            FileHandler fileHandler = new FileHandler("./simulation.txt");
            logger.addHandler(fileHandler);
            fileHandler.setFormatter(new Formatter() {
                @Override
                public String format(LogRecord record) {
                    return record.getMessage() + "\n";
                }
            });
            logger.setUseParentHandlers(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
