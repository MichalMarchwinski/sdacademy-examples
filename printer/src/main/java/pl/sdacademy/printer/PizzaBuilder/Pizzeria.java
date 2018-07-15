package pl.sdacademy.printer.PizzaBuilder;

public class Pizzeria {
	public static void main(String[] args) {
		PizzaLombok pizza = PizzaLombok.stworzPizze()
			.dough("cross")
			.sauce("mild")
			.topping("ham + shroooms")
			.build();
		PizzaLombok margarita = PizzaLombok.stworzPizze()
			.dough("cross")
			.sauce("mild")
			.topping("cheese")
			.build();
		PizzaLombok hawaii = PizzaLombok.stworzPizze()
			.dough("cross")
			.sauce("mild")
			.topping("ham + pineapple")
			.build();
		PizzaLombok hotPizza = PizzaLombok.stworzPizze()
			.dough("cross")
			.sauce("hot")
			.topping("peperoni + salami")
			.build();

		System.out.println(hotPizza);
		System.out.println(hawaii);
		System.out.println(pizza);
		System.out.println(margarita);
	}
}
