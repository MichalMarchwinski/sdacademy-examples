package pl.sdacademy.printer.PizzaBuilder;

import lombok.Builder;
import lombok.ToString;

@Builder (builderMethodName = "stworzPizze")
@ToString
public class PizzaLombok {
	String dough = " ";
	private String sauce = "";
	private String topping = "";
}
