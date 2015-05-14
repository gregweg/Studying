package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class TreesAndGraphs {
	Queue<TreeNode> queue = new LinkedList<TreeNode>();
	// Breadth First Search
	// Implemented with a Queue, 
	// 		If all of the edges in a graph are unweighted, then the first time visited is the
	//		shortest path to that node from the source node.
	//		Add all children to the queue, then pull the head and do a breadth first search on 
	//		it using the same queue
	// Search a node and it's siblings before going onto any children.
	/*
	public TreeNode breadthFirstSearch(TreeNode root, int data) {
		TreeNode node = root;
		if (node.data == data) {
			return node;
		} else {
			breadthFirstSearch(node.left, data);
			breadthFirstSearch(node.right, data);
		}
	}
	*/
	
	/*
	public void bFS(TreeNode root, int data) {
		if (root == null)
			return;
		queue.clear();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.remove();
			System.out.print(node.data + " ");
			if (node.left != null) queue.add(node.left);
			if (node.right != null) queue.add(node.right);
		}
	}
	*/
	
	/*
	 * void bfs(node start) {
	 * 	queue<node> s;
	 * 	s.push(start);
	 * 	mark start as visited
	 * 	while (s.empty() == false) {
	 * 		top = s.front();
	 * 		s.pop();
	 * 
	 * 		check for termination condition (have we reached the node we want to?)
	 * 
	 * 		add all of top's unvisited neighbors to the queue
	 * 		mark all of top's unvisited neighbors as visited
	 * 	}
	 * }
	 */
	
	// Depth First Search
	// 		Geared toward the problems where we want to find any solution to the problem.
	//		Add all children to the stack, then pop and do a dFS on that node, using the same stack
	// Search a node and all it's children before proceeding to it's siblings
	/*
	public TreeNode depthFirstSearch(TreeNode root, int data) {
		TreeNode node = root;
		if (node == null) return null;
		depthFirstSearch(node.left);
		depthFirstSearch(node.right);
		if (node.data == data) {
			return node;
		}
		
	}*/
	/*
	public static boolean dfs(TreeNode root, char goal) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			System.out.println("Checking node " + node.data);
			if (node.data == goal) {
				System.out.println("Found goal node: " + node.data);
				return true;
			}
			stack.addAll(node.left);
			stack.addAll(node.right);
			dump(stack);
		}
		return false;
	}*/
	
	/*
	 * dfs(node start) {
	 * 	stack<node> s;
	 * 	s.push(start);
	 * 	while (s.empty() == false) {
	 * 		top = s.top();
	 * 		s.pop();
	 * 
	 * 		if (top is not marked as visited) {
	 *			check for termination condition (have we reached the node we want to?)
	 *
	 *			mark node as visited
	 *			add all of top's neighbors to stack.
	 *		}
	 *	}
	 *}
	 */
	
	// 	Implement a function to check if a tree is balanced. A balanced tree is defined to be a tree
	// such that no two leaf nodes differ in distance from the root by more than one
	public static boolean isTreeBalanced(TreeNode root) {
		if(root == null) return false;
		TreeNode node = root;
		// 2  3
		// 2  4
		if (Math.sqrt(Math.pow(TreeNode.getHeight(node.left) - TreeNode.getHeight(node.right), 2)) > 1) {
			return false;
		} else {
			return true;
		}
	}
	
	//	Given a directed graph, design an algorithm to find out whether there is a route between two nodes
	//public boolean doesRouteExist(Graph dG, Vertex start, Vertex end) {
		// Some form of DFS
		
	//	return false;
	//}
	/*
	public static boolean search(Graph g, Node start, Node end) {
		LinkedList<Node> q = new LinkedList<Node>(); // operates as a Stack
		for (Node u : g.getNodes()) {
			u.state = State.Unvisited;
		}
		start.state = State.Visiting;
		q.add(start);
		Node u;
		while(!q.isEmpty()) {
			u = q.removeFirst();	// i.e., pop()
			if (u != null) {
				for (Node v : u.getAdjacent()) {
					if (v.state == State.Unvisited) {
						if (v == end) {
							return true;
						} else {
							v.state = State.Visiting;
							q.add(v);
						}
					}
				}
				u.state = State.Visited;
			}
		}
		return false;
	}*/
	
	
	//	Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal
	// height
	public BinaryTree createBinaryTree(char[] sortedArr) {
		BinaryTree bt = new BinaryTree();
		int middle = sortedArr.length / 2;
		for (int i = 0; i < sortedArr.length; i++) {
			bt.insert(sortedArr[i]);
			if (!isTreeBalanced(bt.getRoot())) {
				
			}
		}
		return bt;
	}
	
	public void balanceTree(TreeNode root) {
		if (root == null) return;
		TreeNode node = root;
		if (!isTreeBalanced(node)) {
			if (TreeNode.getHeight(node.left) > TreeNode.getHeight(node.right)) {
				// Left Sub-Tree unbalanced
				balanceTree(node.left);
			} else if(TreeNode.getHeight(node.left) < TreeNode.getHeight(node.right)) {
				// Right Sub-Tree unbalanced
				balanceTree(node.right);
			} else {
				return;
			}
		}
	}
	
	
	
	// Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth
	// (i.e, if you have a tree with depth D, you'll have D linked lists).
	public void createDepthLL(TreeNode root) {
		return;
	}
	
	ArrayList<LinkedList<TreeNode>> findLevelLinkList(TreeNode root) {
		int level = 0;
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		list.add(root);
		result.add(level, list);
		while (true) {
			list = new LinkedList<TreeNode>();
			for (int i = 0; i < result.get(level).size(); i++) {
				TreeNode n = (TreeNode) result.get(level).get(i);
				if (n != null) {
					if (n.left != null) list.add(n.left);
					if (n.right != null) list.add(n.right);
				}
			}
			if (list.size() > 0) {
				result.add(level + 1, list);
			} else {
				break;
			}
			level++;
		}
		return result;
	}
	
	
	// Write an algorithm to find the 'next' node (i.e., in-order successor) of a given node in
	// a binary search tree where each node has a link to it's parent
	public TreeNodeWithParent findNextNode(TreeNodeWithParent node) {
		TreeNodeWithParent parent = node.getParent();
		//		5
		//	  3    8
		//   1  4 6  9
		if (node.data > parent.data) {
			//	node > parent -> node is in right subtree
			//		successor should be left sub tree if it exists
			//		else should be nodes parent parent
			if (node.left != null) return node.left;
			else return node.parent;
		} else if (node.data < parent.data) {
			//	node < parent -> node is in left subtree
			// 		successor should be right sub tree if it exists
			// 		else should be nodes parents parent
			if (node.right != null) return node.right;
			else return node.parent;
		}
		return null;
	}
	
	
	// Design an algorithm and write code to find the first common ancestor of two nodes in a binary
	// tree. Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary
	// search tree
	public TreeNode findCommonAncestor(TreeNode nodeOne, TreeNode nodeTwo) {
		
		return null;
	}
	
	/*
	public Tree commonAncestor(Tree root, Tree p, Tree q) {
		if (covers(root.left, p) && covers(root.left, q))
			return commonAncestor(root.left, p, q);
		if (covers(root.right, p) && coverts(root.right, q))
			return commonAncestor(root.right, p, q);
		return root;
	}
	
	public boolean covers(Tree root, Tree p) { /* is p a child of root? */
	/*
		if (root == null) return false;
		if (root == p) return true;
		return covers(root.left, p) || covers(root.right, p);
	}*/
	
	
	// You have two very large binary trees: T1, with millions of nodes and T2, with hundreds of nodes.
	// Create an algorithm to decide if T2 is a subtree of T1.
	public boolean isSubtree(TreeNode t1, TreeNode t2) {
		if (t1 == null) return false;
		if (t2 == null) return false;
		if (treeEquals(t1, t2)) {
			return true;
		} else {
			return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
		}
	}
	
	public boolean treeEquals(TreeNode t1, TreeNode t2) {
		if (t1.data != t2.data) return false;
		else {
			return treeEquals(t1.left, t2.left) && treeEquals(t1.right, t2.right); 
		}
	}
	
	
	// You are given a binary tree in which each node contains a value. Design an algorithm to print
	// all paths which sum up that value. Note that it can be any path in the tree - it does not have to start
	// at the root.
	public void findNodeSums(TreeNode root) {
		return;
	}
	
	// What if the path had to start at the root? In 
	
	public void findSum(TreeNode head, int sum, ArrayList<Integer> buffer, int level) {
		if (head == null) return;
		int tmp = sum;
		buffer.add(head.data);
		for (int i = level; i >= i; i--) {
			tmp -= buffer.get(i);
			if (tmp == 0) print(buffer, i, level);
		}
		ArrayList<Integer> c1 = (ArrayList<Integer>) buffer.clone();
		ArrayList<Integer> c2 = (ArrayList<Integer>) buffer.clone();
		findSum(head.left, sum, c1, level + 1);
		findSum(head.right, sum, c2, level + 1);
	}
	
	public void print(ArrayList<Integer> buffer, int level, int i2) {
		for (int i = level; i <= i2; i++) {
			System.out.print(buffer.get(i) + " ");
		}
		System.out.println();
	}
}
