package Study;

import java.util.Stack;


public class PrefixNotation {

	// Prefix Notation +*123 = 5
	//	+(1 * 2)3
	//	(1 * 2) + 3 = 5
	public static int prefixNotate(String notation) {
		char[] equation = notation.toCharArray();
		Stack<Character> operations = new Stack<Character>();
		int index = 0;
		while(!Character.isDigit(equation[index])) {
			operations.push(equation[index++]);
		}
		if (!Character.isDigit(equation[index])) {
			return -1;
		}
		int value = Character.getNumericValue(equation[index++]);
		while (index < equation.length && !operations.isEmpty()){
			char operator = operations.pop();
			int operand = Character.getNumericValue(equation[index++]);
			if (operator == '+') {
				value = value + operand;
			} else if(operator == '-') {
				value = value - operand;
			} else if(operator == '*') {
				value = value * operand;
			} else if(operator == '/') {
				value = value / operand;
			}
		}
		return value;
	}
	
	public static void main(String[] args) {
		System.out.println("+*123 = " + prefixNotate("+*123"));
	}
}