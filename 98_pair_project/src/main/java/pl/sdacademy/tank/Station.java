package pl.sdacademy.tank;

import java.util.HashMap;
import java.util.Map;

public class Station {
	public Station(Car car) {

	}

	Map<Tank, Integer> priceForTankType = new HashMap<>();
	public Price() {
		priceForTankType.put(Tank.PETROL, 5);
		priceForTankType.put(Tank.DISEL, 4);
		priceForTankType.put(Tank.ELECTRIC, 2);
	}



}
