package TreesAndGraphs;

import TreesAndGraphs.BinaryTree.Node;

import org.junit.Test;

public class TreesAndGraphsTest {

	public BinaryTree createBinaryTree() {
		BinaryTree bt = new BinaryTree();
		bt.insert('M');
		bt.insert('D');
		bt.insert('P');
		bt.insert('A');
		bt.insert('J');
		bt.insert('N');
		bt.insert('T');
		return bt;
	}
	@Test
	public void createTestTree() {
		
		//				M
		//		D				P
		//	A		J		N		T
		//
		BinaryTree bt = createBinaryTree();
		Node root = bt.getRoot();
		//bt.printTree(root);
		System.out.println("In Order");
		bt.printInOrder();
		System.out.println("Pre Order");
		bt.printPreOrder();
		System.out.println("Post Order");
		bt.printPostOrder();
		org.junit.Assert.assertEquals('M', root.getData());
	}
	@Test
	public void testGetTreeHeight() {
		BinaryTree bt = createBinaryTree();
		Node root = bt.getRoot();
		org.junit.Assert.assertEquals(3, bt.getHeight(root));
	}
	
	@Test
	public void testBalancedTree() {
		BinaryTree bt = createBinaryTree();
		Node root = bt.getRoot();
		org.junit.Assert.assertTrue(bt.isTreeBalanced());
	}
	
	//@Test
	//public void testCreateBinaryTree() {
	//	char[] sortedChars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
	//}
}
