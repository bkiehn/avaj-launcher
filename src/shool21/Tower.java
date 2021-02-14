package shool21;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public abstract class Tower {
	private List<Flyable> observers = new ArrayList<>();
	private Logger logger = Logger.getLogger("Logger");

	void register(Flyable flyable) {
		observers.add(flyable);
		logger.info("shool21.Tower says: " + flyable.toString() + " registered to weather tower");
	}

	void unregister(Flyable flyable) {
		observers.remove(flyable);
		logger.info("shool21.Tower says: " + flyable.toString() + " landed");
	}

	protected void conditionsChanged() {
		List<Flyable> unregistered = new ArrayList<>();
		for (Flyable flyable : observers) {
			flyable.updateConditions();
			if (flyable.getCoordinates().getHeight() <= 0) {
				unregistered.add(flyable);
			}
		}
		for (Flyable flyable : unregistered) {
			unregister(flyable);
		}
	}
}