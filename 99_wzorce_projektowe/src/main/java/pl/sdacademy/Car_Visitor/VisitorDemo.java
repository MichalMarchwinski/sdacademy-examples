package pl.sdacademy.Car_Visitor;

public class VisitorDemo {
	public static void main(String[] args) {
		final Car car = new Car();

		car.accept(new CarElemntPrintVisitor());
		car.accept(new CarElemntDoVisitor());
	}
}
