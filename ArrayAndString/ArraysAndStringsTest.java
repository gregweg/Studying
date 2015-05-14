package ArrayAndString;

import ArrayAndString.ArraysAndStrings;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Test;

public class ArraysAndStringsTest {
	
	//	1.3	Remove Duplicates
	@Test
	public void testRemoveDuplicates() {
		char[] test = {'c','r','a','b','a','p','p','l','e'};
		char[] result = {'c','r','a','b','p','l','e'};
		//String test = "crabapple";
		//String result = "crabple";
		ArraysAndStrings.removeDuplicates(test);
		System.out.println("Displaying Test: " + test);
		org.junit.Assert.assertArrayEquals(result, test);
	}
	
	@Test
	public void testAssertPermutations() {
		String p1 = "Libbe";
		String p2 = "Bible";
		org.junit.Assert.assertTrue(ArraysAndStrings.isPermutation(p1, p2));
	}
	
	@Test
	public void testAssertCompression() {
		String test = "aabcccccaaa";
		String result = "a2b1c5a3";
		org.junit.Assert.assertTrue(ArraysAndStrings.compressString(test).compareTo(result) == 0);
	}
	
	@Test
	public void testEigenVector() {
		int[][] testMatrix = {{1, 0, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
		int[][] resultMatrix = {{0, 0, 0, 0}, {1, 0, 1, 0}, {1, 0, 1, 0}, {1, 0, 1, 0}};
		//ArraysAndStrings.displayMatrix(testMatrix, 4);
		ArraysAndStrings.eigenVector(testMatrix);
		//ArraysAndStrings.displayMatrix(testMatrix, 4);
		org.junit.Assert.assertArrayEquals(testMatrix[0], resultMatrix[0]);
		org.junit.Assert.assertArrayEquals(testMatrix[1], resultMatrix[1]);
		org.junit.Assert.assertArrayEquals(testMatrix[2], resultMatrix[2]);
		org.junit.Assert.assertArrayEquals(testMatrix[3], resultMatrix[3]);
	}
	
	@Test
	public void testMatrixRotation() {
		int[][] testMatrix = {{1, 0, 0, 2},{0, 0, 0, 0},{0, 0, 0, 0}, {4, 0, 0, 3}};
		int[][] resultMatrix = {{4, 0, 0, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}, {3, 0, 0, 2}};
		ArraysAndStrings.rotateMatrix(testMatrix, 4);
		org.junit.Assert.assertArrayEquals(testMatrix[0], resultMatrix[0]);
		org.junit.Assert.assertArrayEquals(testMatrix[1], resultMatrix[1]);
		org.junit.Assert.assertArrayEquals(testMatrix[2], resultMatrix[2]);
		org.junit.Assert.assertArrayEquals(testMatrix[3], resultMatrix[3]);
	}
	/*
	@Test
	public void testThreeSum() {
		int[] test = {-5, -4, 3, 1, 0, -3, 10};
		org.junit.Assert.assertTrue(ArraysAndStrings.threeSum(test));
	}*/
	
}
