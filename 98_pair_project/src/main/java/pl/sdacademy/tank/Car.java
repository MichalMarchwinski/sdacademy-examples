package pl.sdacademy.tank;

public class Car {
	private final Tank tank;

	public Car(Tank tank) {
		this.tank = tank;
	}


	final byte MAX_TANK = 42;
	byte currentTank;
	int howMuchIFill;

	public int fillUpTheTankAndKnowHowMuchIPaid(int currentTank) {
		howMuchIFill = MAX_TANK - currentTank;
		int price = (howMuchIFill) * tank.getCurrentPrice();
		return price;
	}


	public boolean fullTank() {

		return currentTank == MAX_TANK;
	}
}
