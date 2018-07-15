package pl.sdacademy.Interpretery_ENG;

import java.util.HashMap;
import java.util.Map;

public class IntepreterExample {
	public static void main(String[] args) {
		final String expression = "w x z - +";
		final Eveluator sentence = new Eveluator(expression);
		final Map<String, Expression> variables = new HashMap<String, Expression>();
		variables.put("w", new Number(5));
		variables.put("x", new Number(10));
		variables.put("z", new Number(42));
		final int result = sentence.interpret(variables);
		System.out.println(result);
	}
}

