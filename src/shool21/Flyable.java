package shool21;

public interface Flyable {
	void updateConditions();
	void registerTower(WeatherTower weatherTower);
	Coordinates getCoordinates();
}