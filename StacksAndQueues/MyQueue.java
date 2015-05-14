package StacksAndQueues;

import java.util.Stack;

public class MyQueue <T> {
	// Implement a MyQueue class which implements a queue using two stacks.
	//	Stack LIFO
	// 	Queue FIFO
	//		enqueue -> push s1
	//		dequeue -> pop
	Stack<T> s1, s2;
	
	// s1, s2, s3
	// push s1
	// f - s1
	// b -
	// f - 
	// b - s1
	// push s2
	// f - s2, s1
	// b -
	// f - s3, s2, s1
	// b -
	public MyQueue() {
		s1 = new Stack<T>();
		s2 = new Stack<T>();
	}
	
	public int size() {
		return s1.size() + s2.size();
	}
	
	public void add(T value) {
		s1.push(value);
	}
	
	public T peek() {
		if (!s2.isEmpty()) return s2.peek();
		while (!s1.empty()) s2.push(s1.pop());
		return s2.peek();
	}
	
	public T remove() {
		if (!s2.isEmpty()) return s2.pop();
		while (!s1.empty()) s2.push(s1.pop());
		return s2.pop();
	}
}
