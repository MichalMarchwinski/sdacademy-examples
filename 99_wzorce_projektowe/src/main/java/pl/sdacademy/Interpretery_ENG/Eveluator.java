package pl.sdacademy.Interpretery_ENG;

import java.util.Map;
import java.util.Stack;

public class Eveluator implements Expression{
	private Expression syntaxTree;

	public Eveluator(final String expression) {
		final Stack<Expression> expressionStack = new Stack<Expression>();
		for (final String token : expression.split(" ")) {
			if (token.equals("+")) {
				final Expression subExpression = new Plus(expressionStack.pop(), expressionStack.pop());
				expressionStack.push(subExpression);
			} else if (token.equals("-")) {
				final Expression right = expressionStack.pop();
				final Expression left = expressionStack.pop();
				final Expression subExpression = new Minus(left, right);
				expressionStack.push(subExpression);
			} else
				expressionStack.push(new Variable(token));
		}
		syntaxTree = expressionStack.pop();
	}

	public int interpret(final Map<String, Expression> context) {
		return syntaxTree.interpret(context);
	}
}
