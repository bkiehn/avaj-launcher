package shool21.aircraft;

import shool21.Coordinates;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    public Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId() {
        return ++idCounter;
    }

    @Override
    public String toString() {
        return "#" + name + " (" + id + ")";
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
