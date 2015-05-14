package StacksAndQueues;

public class SimpleQueue {

	class Node {
		Node next = null;
		int data;
		public Node(int d) {
			data = d;
		}
	}
	
	Node front, end;
	void enqueue(int val) {
		if (front == null) {
			end = new Node(val);
			front = end;
		} else {
			end.next = new Node(val);
			end = end.next;
		}
	}
	int dequeue() {
		if (front != null) {
			int val = front.data;
			front = front.next;
			return val;
		}
		return -1;
	}
}
