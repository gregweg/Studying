package LinkedLists;

import LinkedLists.LinkedLists;
import LinkedLists.LinkedLists.Node;

import org.junit.Test;

public class LinkedListsTest {
	
	//Input: the node C from A -> B -> C -> D ->E
	//Result: Nothing is returned, but the new linked list looks like A -> B -> D -> E
	@Test
	public void testDeleteMiddleNode() {
		LinkedLists ll = new LinkedLists();
		Node test = ll.new Node('A');
		test.appendToTail('B');
		Node middle = ll.new Node('C');
		test.appendToTail(middle);
		test.appendToTail('D');
		test.appendToTail('E');
		ll.deleteMiddleNode(middle);
		ll.printLinkedList(test);
		org.junit.Assert.assertFalse(ll.containsNode(test, Character.getNumericValue('C')));
		org.junit.Assert.assertTrue(ll.containsNode(test, Character.getNumericValue('D')));
	}
	
	// EX. (3 -> 1 -> 7) + (5 -> 9 -> 2) = 713 + 295
	// Output: (8 -> 0 -> 8) = 808
	@Test
	public void testCountListValue() {
		LinkedLists ll = new LinkedLists();
		//Node test = new LinkedLists().new Node(9);
		Node test = ll.new Node(3);
		test.appendToTail(1);
		test.appendToTail(7);
		int result = ll.countListValue(test);
		org.junit.Assert.assertEquals(713, result);
	}
	
	@Test
	public void testSumToNode() {
		LinkedLists ll = new LinkedLists();
		int sum = 808;
		Node nodeSum = ll.sumToNode(sum);
		int result = ll.countListValue(nodeSum);
		org.junit.Assert.assertEquals(808, result);
	}
	
	@Test
	public void testReverseOrderSum() {
		LinkedLists ll = new LinkedLists();
		
		Node val1 = ll.new Node(3);
		val1.appendToTail(1);
		val1.appendToTail(5);
		
		Node val2 = ll.new Node(5);
		val2.appendToTail(9);
		val2.appendToTail(2);
		
		Node sum = ll.addLists(val1, val2);
		int result = ll.countListValue(sum);
		org.junit.Assert.assertEquals(808, result);
	}
}
