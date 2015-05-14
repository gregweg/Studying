package StacksAndQueues;


// Design a stack which, in addition to push and pop, also has a function
// min which returns the minimum element. 
//	Push, pop, and min should all operate in O(1) time

public class ImprovedStack {
	NodeWithMin top;
	
	public void push(int value) {
		int newMin = Math.min(value,  min());
		NodeWithMin t = new NodeWithMin(value, newMin);
		t.next = top;
		top = t;
	}
	
	public int min() {
		if (this.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return ((NodeWithMin)peek()).min;
		}
	}
	
	NodeWithMin pop() {
		if (top != null) {
			NodeWithMin node = top;
			top = top.next;
			return node;
		}
		return null;
	}
	
	NodeWithMin peek() {
		if (top != null) {
			return top;
		} else {
			return null;
		}
	}
	boolean isEmpty() {
		if (top == null) {
			return true;
		} else {
			return false;
		}
	}
	
	class NodeWithMin {
		NodeWithMin next;
		public int value;
		public int min;
		public NodeWithMin(int v, int min) {
			this.value = v;
			this.min = min;
		}
	}
}
