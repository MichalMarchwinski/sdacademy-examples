package pl.sdacademy.Car_Visitor;

public class Body implements CarElement {
	public void accept(final CarElementVisitor visitor) {
		visitor.visit(this);
	}
}
