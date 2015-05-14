package StacksAndQueues;

import java.util.Stack;

public class StacksAndQueues {
	
	// Write a program to sort a stack in ascending order. You should not make nay assumptions
	// about how the stack is implemented. The following are the only functions that should be
	// used to write this program: push | pop | peek | isEmpty
	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while (!s.isEmpty()) {
			int tmp = s.pop();
			while (!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		return r;
	}
}
