package Study;

public class LinkedList {
	
	private Node head;
	private int listCount;
	
	public LinkedList() {
		head = new Node(null);
		listCount = 0;
	}
	
	public void add(Object data) {
		Node temp = new Node(data);
		Node current = head;
		// move to the end of the list
		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(temp);
		listCount++;
	}
	
	public void add(Object data, int index) {
		Node temp = new Node(data);
		Node current = head;
		
		for (int i = 1; i < index && current.getNext() != null; i++) {
			current = current.getNext();
		}
		
		temp.setNext(current.getNext());
		
		current.setNext(temp);
		listCount++;
	}
	
	public Object get(int index) {
		// index must be 1 or higher
		if (index <= 0)
			return null;
		
		Node current = head.getNext();
		for (int i = 1; i < index; i++) {
			if (current.getNext() == null)
				return null;
			
			current = current.getNext();
		}
		return current.getData();
	}
	
	public boolean remove(int index) {
		// Check range of index
		if (index < 1 || index > size())
			return false;
		
		Node current = head;
		for (int i = 1; i < index; i++) {
			if (current.getNext() == null)
				return false;
			
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		listCount--;
		return true;
	}
	
	public int size() {
		return listCount;
	}
	
	public String toString() {
		Node current = head.getNext();
		String output = "";
		while (current != null) {
			output += "[" + current.getData().toString() + "]";
			current = current.getNext();
		}
		return output;
	}
	
	// [1] > [2] > [3] > [4]
	//  c     r
	// [1] < [2] < [3] < [4]
	public void reverse() {
		Node current = head;
		Node runner = head.next;
		// Make head tail
		current.next = null;
		while (runner != null) {
			Node temp = runner.next;
			runner.next = current;
			current = runner;
			runner = temp;
		}
	}

	private class Node {
		Node next;
		
		Object data;
		
		public Node(Object dataValue) {
			next = null;
			data = dataValue;
		}
		
		public Node(Object dataValue, Node nextValue) {
			next = nextValue;
			data = dataValue;
		}
		
		public Object getData() {
			return data;
		}
		
		public void setData(Object dataValue) {
			data = dataValue;
		}
		
		public Node getNext() {
			return next;
		}
		
		public void setNext(Node nextValue) {
			next = nextValue;
		}
	}
}
