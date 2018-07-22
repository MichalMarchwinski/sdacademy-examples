package pl.sdacademy.Car_Visitor;

public interface CarElement {
	void accept(CarElementVisitor visitor);
}
