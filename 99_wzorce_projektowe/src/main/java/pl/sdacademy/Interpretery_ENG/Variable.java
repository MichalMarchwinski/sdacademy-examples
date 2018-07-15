package pl.sdacademy.Interpretery_ENG;

import java.util.Map;

public class Variable implements Expression {
	private String name;
	public Variable(final String name) {this.name = name; }
	public int interpret(final Map<String, Expression> variables) {
		if (null == variables.get(name)) return 0;
		return variables.get(name).interpret(variables);
	}
}
