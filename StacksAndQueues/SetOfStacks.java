package StacksAndQueues;

import java.util.ArrayList;

// Implement a data structure SetOfStacks that mimics starting a new stack when the previous 
// stack exceeds a threshold. SetOfStacks should be composed of several stacks, and should create
// a new stack once the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should
// behave identically to a single stack (that is, pop() should return the same values as it would if there
// were just a single stack).

public class SetOfStacks {
	int STACK_THRESHOLD = 30;
	int stack_ptr;
	SimpleStack lastStack;
	ArrayList<SimpleStack> stacks = new ArrayList<SimpleStack>();

	SimpleStack getLastStack() {
		if (stacks.isEmpty()) return null;
		return stacks.get(stacks.size() - 1);
	}
	
	void push(int val) {
		SimpleStack last = getLastStack();
		if (last != null && last.getNodeCount() < STACK_THRESHOLD) {
			last.push(val);
		} else {
			SimpleStack stack = new SimpleStack();
			stack.push(val);
			stacks.add(stack);
		}
	}
	
	int peek() {
		if (lastStack == null) return -1;
		return lastStack.peek();
	}
	
	int pop() {
		SimpleStack last = getLastStack();
		int v = last.pop();
		if (last.getNodeCount() == 0) stacks.remove(stacks.size() - 1);
		return v;
	}
	
	// FOLLOW UP
	// Implement a function popAt(int index) which performs a pop operation on a specific sub-stack

	int popAt(int index) {
		if (stacks.isEmpty()) return -1;
		SimpleStack selected = stacks.get(index);
		int v = selected.pop();
		if (selected.getNodeCount() == 0) stacks.remove(index);
		return v;
	}
}
