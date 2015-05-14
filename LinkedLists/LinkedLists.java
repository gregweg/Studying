package LinkedLists;

public class LinkedLists {

	class Node {
		Node next = null;
		int data;
		boolean visited = false;
		public Node(int d) { data = d; }
		void appendToTail(int d) {
			Node end = new Node(d);
			Node n = this;
			while (n.next != null) { n = n.next; }
			n.next = end;
		}
		
		void appendToTail(Node d) {
			Node n = this;
			while (n.next != null) {n = n.next; }
			n.next = d;
		}
	}
	
	Node deleteNode(Node head, int d) {
		Node n = head;
		if (n.data == d) {
			return head.next; /* moved head */
		}
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				return head; /* head didn't chang */
			}
			n = n.next;
		}
		return head;
	}
	
/*	public boolean containsNode(Node head, int d) {
		Node n = head;
		if (n == null) { return false; }
		while (n != null) {
			if (n.data == d) { return true; }
			n = n.next;
		}
		return false;
	}
	*/
	// Write code to remove duplicates from an unsorted linked list
	public void removeDuplicates(Node head) {
		Node n = head;
		Node clean;
		if (head != null) {
			clean = new Node(n.data);
		} else {
			return;
		}
		while (n.next != null) {
			if (!containsNode(head, n.data)) {
				clean.appendToTail(n.data);
			}
			n = n.next;
		}
		head = clean;
	}
	
	// How would you solve this problem if a temporary buffer wasn't allowed?
	public void removeDuplicatesTwo(Node head) {
		Node n = head;
		if (head == null) {
			return;
		}
		while (n.next != null) {
			if (containsNode(n.next, n.data)) {
				n = deleteNode(n.next, n.data); 
			}
			n = n.next;
		}
	}
	
	public boolean containsNode(Node head, int d) {
		Node n = head;
		if (n == null) {
			return false;
		}
		if (n.data == d) {
			return true;
		}
		while (n != null) {
			if (n.data == d) {
				return true;
			}
			n = n.next;
		}
		return false;
	}
	
	// Implement an algorithm to find the kth to last element of a singly linked list
	public Node findKth(Node head, int k) {
		Node n = head;
		Node kth = head;
		if (head == null) {
			return head;
		}
		for (int i = 0; i < k; i++) {
			n = n.next;
		}
		while (n.next != null) {
			n = n.next;
			kth = kth.next;
		}
		return kth;
	}
	
	public void printLinkedList(Node head) {
		Node n = head;
		while(n != null) {
			System.out.print(n.data);
			if (n.next != null) {
				System.out.print(" -> ");
			} else {
				System.out.print("\n");
			}
			n = n.next;
		}
	}
	
	// Delete a node in the middle of a singly linked list, given only access to that node
	// EX.
	// Input: the node C from A -> B -> C -> D ->E
	// Result: Nothing is returned, but the new linked list looks like A -> B -> D -> E
	public void deleteMiddleNode(Node m) {
		// Since no access to the head of the LL, can make it to C becoems D and D becomes E
		if (m.next != null) {
			m.data = m.next.data;
			m.next = m.next.next;
		}
	}
	
	// Partition a linked list around a value X, such that all nodes less than X come before
	// all nodes greater than or equal to x
	public Node partitionNodes(Node head, int x) {
		Node n = head;
		Node less = null;
		Node gte = null;
		if (head == null) {
			return head;
		}
		while (n.next != null) {
			if (n.data < x) {
				if (less == null) {
					less = new Node(n.data);
				} else {
					less.appendToTail(n.data);
				}
			} else {
				if (gte == null) {
					gte = new Node(n.data);
				} else {
					gte.appendToTail(n.data);
				}
			}
			n = n.next;
		}
		head = less;
		while (less.next != null) {
			less = less.next;
		}
		less.next = gte;
		return head;
	}
	
	// Each node contains a single digit. The digits are stored in reverse order, such that the 1's
	// digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked
	// list.
	// EX. (3 -> 1 -> 5) + (5 -> 9 -> 2) = 713 + 295
	// Output: (8 -> 0 -> 8) = 808
	public Node addLists(Node n1, Node n2) {
		int val1 = countListValue(n1);
		int val2 = countListValue(n2);
		int sum = val1 + val2;
		return sumToNode(sum);
	}
	
	public int countListValue(Node n) {
		int power = 1;
		int sum = 0;
		while (n != null) {
			sum = sum + n.data * power;
			power = power * 10;
			n = n.next;
		}
		return sum;
	}
	
	public Node sumToNode(int sum) {
		Node n = null;
		while (sum > 0) {
			int digit = sum % 10;
			sum = sum - digit;
			sum = sum / 10;
			if (n == null) {
				n = new Node(digit);
			} else {
				n.appendToTail(digit);
			}
		}
		//printLinkedList(n);
		return n;
	}
	
	// Given a circular linked list, implement an algorithm which returns node at the beginning of the loop
	// EX.
	// Input:  A -> B -> C -> D -> E -> C (the same C as earlier)
	// Output: C
	public Node findCircularLoop(Node head) {
		if (head == null) return null;
		Node n = head;
		while(n.next != null) {
			if (!n.visited) {
				n.visited = true;
				n = n.next;
			} else {
				return n;
			}
		}
		return null;
	}
	public Node FindBeginning(Node head) {
		Node n1 = head;
		Node n2 = head;
		
		// Find meeting point
		while (n2.next != null) {
			n1 = n1.next;
			n2 = n2.next.next;
			if (n1 == n2) {
				break;
			}
		}
		
		// Error check - there is no meeting point and therfore no loop
		if (n2.next == null) {
			return null;
		}
		
		/* Move n1 to Head. Keep n2 at Meeting Point. Each are k steps
		 * from the Loop Start. If they move at the same pace, they muse meet at Loop Start.
		 * 
		 */
		n1 = head;
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		
		// Now n2 points to the start of the loop
		return n2;
	}
}
