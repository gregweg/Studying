package StacksAndQueues;

public class SimpleStack {

	class Node {
		Node next = null;
		int data;
		public Node(int d) { 
			data = d; 
		}
	}
	
	Node top;
	int nodeCount;
	
	public SimpleStack() {
		top = null;
		nodeCount = 0;
	}
	
	int pop() {
		if (top != null) {
			int val = top.data;
			top = top.next;
			nodeCount--;
			return val;
		}
		return -1;
	}
	void push(int val) {
		Node n = new Node(val);
		n.next = top;
		top = n;
		nodeCount++;
	}
	int peek() {
		if (top != null) {
			return top.data;
		} else {
			return -1;
		}
	}
	int getNodeCount() {
		return nodeCount;
	}
}
