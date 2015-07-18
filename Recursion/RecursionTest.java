package Recursion;

import Recursion.Recursion;

import org.junit.Test;

public class RecursionTest {


	@Test
	public void testFibonacci() {
		org.junit.Assert.assertEquals(3, Recursion.genNthFib(5));
		org.junit.Assert.assertEquals(5, Recursion.genNthFib(6));
		org.junit.Assert.assertEquals(8, Recursion.genNthFib(7));
		org.junit.Assert.assertEquals(13, Recursion.genNthFib(8));
	}

}
