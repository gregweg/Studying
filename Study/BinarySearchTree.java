package Study;

import java.io.IOException;
import java.io.OutputStream;
import java.util.NoSuchElementException;

public class BinarySearchTree {
	
	private Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public boolean lookup(int data) {
		return (lookup(root, data));
	}
	
	public boolean lookup(Node node, int data) {
		if (node == null) {
			return false;
		}
		
		if (data == node.data) {
			return(true);
		}
		else if (data < node.data) {
			return(lookup(node.left, data));
		}
		else {
			return(lookup(node.right, data));
		}
	}
	
	public void insert(int data) {
		insert(root, data);
	}
	
	public void insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
		}
		if (node.getData() > data) {
			insert(node.right, data);
		} else if(node.getData() < data) {
			insert(node.left, data);
		}
	}
	
	// MIN/MAX
	public Node maxHelper(Node current) {
		if (current == null) return null;
		
		while (current.right != null)
			current = current.right;
		return current;
	}
	
	public Node minHelper(Node current) {
		if (current == null) return null;
		
		while (current.left != null)
			current = current.left;
		return current;
	}
	
	// Predecessor in In-Order
	public Node predecessor(Node node) {
		if (node.left != null) return maxHelper(node.left);
		
		Node parent = node.parent;
		/*
		 * or a different checking approach
		 * while (parent != null && parent.data > node.value) {
		 * 		parent = parent.parent;
		 * }
		 */
		
		while (parent != null && parent.left == node) {
			node = parent;
			parent = parent.parent;
		}
		
		return parent;
	}
	
	// Successor in In-Order
	public Node successor(Node node) {
		if (node == null) return null;
		
		// min of right subtree
		if (node.right != null) return minHelper(node.right);
		
		// ancestor of node without right subtree
		Node parent = node.parent;
		
		while (parent != null && parent.right == node) {
			node = parent;
			parent = parent.parent;
		}
		
		return parent;
	}
	
	
	protected Node removeHelper(Node current, Node target) {
		if (current == null) return null;
		if (target.data < current.data)
			current.left = removeHelper(current.left, target);
		else if (target.data > current.data)
			current.right = removeHelper(current.right, target);
		else {
			if (current.isLeaf()) {
				return null;
			}
			if (current.left == null && current.right != null) {
				Node right = current.right;
				current.data = right.data;
				current.left = right.left;
				current.right = right.right;
				
				right.left = right.right = null;	// release it
			} else if (current.right == null && current.left != null) {
				Node left = current.left;
				current.data = left.data;
				current.left = left.left;
				current.right = left.right;
				
				left.left = left.right = null;		// release it
			} else {
				Node p = current.right;
				if (p.isLeaf()) {
					current.data = p.data;
					current.right = null;
				} else if (p.left == null) {
					current.data = p.data;
					current.right = p.right;
					
					p.right = null;					// release p
				} else {
					while (p.left != null) {
						p = p.left;
					}
					
					current.data = p.data;
					removeHelper(current.right, p);
				}
			}
		}
		return current;
	}
	
	
	// Convert a binary tree to a circularly doubly linked list
	public static void join(Node a, Node b) {
		a.large = b;
		b.small = a;
	}
	
	public static Node append(Node a, Node b) {
		// if either is null, return the other
		if (a == null) return(b);
		if (b == null) return(a);
		
		// find the last node in each using the previous pointer
		Node aLast = a.left;
		Node bLast = b.left;
		
		// join the two together to make it connected and circular
		join(aLast, b);
		join(bLast, a);
		
		return (a);
	}
	
	public static Node treeToList(Node root) {
		// base case: empty tree -> empty list
		if (root == null) return null;
		
		// Recursively do the subtrees (leap of faith!)
		Node aList = treeToList(root.left);
		Node bList = treeToList(root.right);
		
		// Make the single root node into a list length-1
		// in preparation for the appending
		root.small = root;
		root.large = root;
		
		// At this point we have three lists, and it's
		// just a matter of appending them together
		// in the right order (aList, root, bList)
		aList = append(aList, root);
		aList = append(aList, bList);
		
		return (aList);
	}
	
	
	// Print all paths of a binary tree
	void printAllPaths(Node root, String currentPath) {
		// base case: empty tree -> no print
		if (root == null) return;
		
		// If empty make start to be 'S'
		if (currentPath == null) {
			currentPath = "S";
		}
		
		// If at leaf
		if (root.left == null && root.right == null) {
			System.out.println(currentPath);
		}
		
		if (root.left != null) printAllPaths(root.left, currentPath + " - L");
		if (root.right != null) printAllPaths(root.right, currentPath + " - R");
	}
	
	// Write an iterator class which can in-order traverse the binary tree
	// implement two operations: next() and hasnext()
	
	private class TreeIterator {
		private Node next;
		
		TreeIterator(Node root) {
			next = root;
			if (next == null)
				return;
			while (next.left != null)
				next = next.left;
		}
		
		public boolean hasNext() {
			return next != null;
		}
		
		public Node next() {
			if (!hasNext()) throw new NoSuchElementException();
			Node r = next;
			// if you can walk right, walk right, then fully left.
			// otherwise, walk up until you come from left
			if (next.right != null) {
				next = next.right;
				while (next.left != null)
					next = next.left;
				return r;
			} else {
				while(true) {
					if (next.parent == null) {
						next = null;
						return r;
					}
					if (next.parent.left == next) {
						next = next.parent;
						return r;
					}
					next = next.parent;
				}
			}
		}
	}
	
	// Serialization
	void writeBinaryTree(Node p, OutputStream out) throws IOException {
		if (p == null) {
			out.write('#');
		} else {
			out.write(p.data);
			writeBinaryTree(p.left, out);
			writeBinaryTree(p.right, out);
		}
	}
	
	private class CurrentPosition {
		int index;
		public CurrentPosition() { index = 0; }
		public void advance() { index++; }
		public int value() { return index; }
	}
	
	public void readBinaryTree(StringBuffer in) {
		root = readBinaryTree(in , new CurrentPosition());
	}
	
	// Since we have two child nodes for every node, index will never be out of boundary
	Node readBinaryTree(StringBuffer in, CurrentPosition index) {
		char c = in.charAt(index.value());
		index.advance();
		
		if (c == '#') {
			return null;
		} else {
			Node p = new Node(c - '0');
			p.left = readBinaryTree(in, index);
			p.right = readBinaryTree(in , index);
			
			return p;
		}
	}
	
	private class Node {
		Node left;
		Node right;
		Node parent;
		Node small;
		Node large;
		int data;
		
		public Node(int dataValue) {
			data = dataValue;
			left = null;
			right = null;
			parent = null;
			small = null;
			large = null;
		}
		
		public Node(int dataValue, Node left, Node right) {
			data = dataValue;
			this.left = left;
			this.right = right;
			left.setParent(this);
			right.setParent(this);
			small = null;
			large = null;
		}
		
		public int getData() {
			return data;
		}
		
		public void setData(int dataValue) {
			data = dataValue;
		}
		
		public Node getLeft() {
			return left;
		}
		
		public void setLeft(Node leftNode) {
			left = leftNode;
			leftNode.setParent(this);
		}
		
		public Node getRight() {
			return right;
		}
		
		public void setRight(Node rightNode) {
			right = rightNode;
			rightNode.setParent(this);
		}
		
		public void setParent(Node parent) {
			this.parent = parent;
		}
		
		public Node getParent() {
			return parent;
		}

		public boolean isLeaf() {
			if (left == null && right == null) return true;
			return false;
		}
	}
}