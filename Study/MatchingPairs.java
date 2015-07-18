package Study;

import java.util.Stack;


public class MatchingPairs {

	// Given a String with parenthesis like like "()()(()(()()" check to see if there are matching pairs. 
	//	If there are matching pairs return true, else return false.
	//	- EX. ()()() returns true; ()()()) returns false;
	boolean checkParenPairs(String str) {
		Stack<Character> charStack = new Stack<Character>();
		int index = 0;
		char [] parens = str.toCharArray();
		while (index < parens.length) {
			if (parens[index] == '(') {
				charStack.push(parens[index]);
			} else if (parens[index] == ')') {
				if (!charStack.empty()) {
					charStack.pop();
				}
			}
		}
		return charStack.empty();
	}
}