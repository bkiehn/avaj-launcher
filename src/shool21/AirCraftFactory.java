package shool21;

public class AirCraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        if (AirCraftType.BALLOON.getType().equals(type)) {
            return new Baloon(name, new Coordinates(longitude, latitude, height));
        } else if (AirCraftType.HELICOPTER.getType().equals(type)) {
            return new Helicopter(name, new Coordinates(longitude, latitude, height));
        } else if (AirCraftType.JETPLANE.getType().equals(type)) {
            return new JetPlane(name, new Coordinates(longitude, latitude, height));
        } else {
            throw new AirCraftCreateException("AirCraft of type \"" + type + "\" doesn't exist");
        }
    }
}
