package TreesAndGraphs;

public class BinaryTree {
	class Node {
		private char data;
		public Node left;
		public Node right;
		public Node(char data) {
			this.setData(data);
			this.left = null;
			this.right = null;
		}
		public Node(char data, Node left, Node right) {
			this.setData(data);
			this.left = left;
			this.right = right;
		}
		public char getData() {
			return data;
		}
		public void setData(char data) {
			this.data = data;
		}
	}
	
	private Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	public BinaryTree(char rootData) {
		root = new Node(rootData);
	}
	
	public Node getRoot() {
		return root;
	}
	
	public void insert(char c) {
		if (root == null) {
			root = new Node(c);
			return;
		}
		Node node = root;
		while (true) {
			if (node.getData() > c) {
				if (node.left == null) {
					node.left = new Node(c);
					return;
				} else {
					node = node.left;
				}
			} else {
				if (node.right == null) {
					node.right = new Node(c);
					return;
				} else {
					node = node.right;
				}
			}
		}
		
	}
	
	public int getHeight(Node head) {
		Node node = head;
		if (node == null) return 0;
		else {
			return 1 + Math.max(getHeight(node.left), getHeight(node.right));
		}
	}
	
	public boolean isTreeBalanced() {
		Node node = root;
		if (node == null) return false;
		
		if (Math.sqrt(Math.pow(getHeight(node.left) -  getHeight(node.right), 2)) > 1) {
			return false;
		} else {
			return true;
		}
	}
	

	
	public void printInOrder() {
		printTreeInOrder(root);
	}
	
	public void printPreOrder() {
		printTreePreOrder(root);
	}
	
	public void printPostOrder() {
		printTreePostOrder(root);
	}
	
	
	// In Order - Left, Current, Right
	public void printTreeInOrder(Node head) {
		Node node = head;
		if (node == null) return;
		//if (node.left != null) {
		printTreeInOrder(node.left);
		//}
		System.out.println("Node: " + node.getData());
		//if (node.right != null) {
		printTreeInOrder(node.right);
		//}
		
	}
	
	// Pre Order - Current, Left, Right
	public void printTreePreOrder(Node head) {
		Node node = head;
		if (node == null) return;
		System.out.println("Node: " + node.getData());
		printTreePreOrder(node.left);
		printTreePreOrder(node.right);
	}
	
	// Post Order - Left, Right, Current
	public void printTreePostOrder(Node head) {
		Node node = head;
		if (node == null) return;
		printTreePostOrder(node.left);
		printTreePostOrder(node.right);
		System.out.println("Node: " + node.getData());
	}
} 
