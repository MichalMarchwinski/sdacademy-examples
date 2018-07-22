package pl.sdacademy.Car_Visitor;

public class Car implements CarElement {
	CarElement[] elements;

	public Car() {
		this.elements = new CarElement[]{
			new Wheel("Front left"), new Wheel("Front right"),
			new Wheel("Back left"), new Wheel("Back right"),
			new Body(), new Engine()
		};
	}

	public void accept(final CarElementVisitor visitor) {
		for (CarElement elem: elements) {
			elem.accept(visitor);
		}
		visitor.visit(this);
	}
}

