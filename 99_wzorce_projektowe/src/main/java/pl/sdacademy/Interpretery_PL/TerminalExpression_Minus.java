package pl.sdacademy.Interpretery_PL;

import java.util.Stack;

public class TerminalExpression_Minus implements Expression {
	public void interpret(Stack<Integer> s)  { s.push( - s.pop() + s.pop() ); }
}
