package ArrayAndString;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysAndStrings {
	
	// 1.1
	// Implement an algorithm to determine if a string has all unique characters. What if you
	// can not use additional data structures?
	public static boolean isUniqueChars(String str) {
		boolean [] charSet = new boolean[128];
		if (str.length() > 128) return false;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if(charSet[val]) return false;
			charSet[val] = true;
		}
		return true;
	}

	// 1.3
	// Design an algorithm and write code to remove the duplicate characters in a string
	// without using any additional buffer. NOTE: One or two duplicate variables are fine.
	// An extra copy of the array is not.
	// FOLLOW UP
	// Write the test cases for this method
	public static void removeDuplicates(char[] str) {
		if (str == null) return;
		int len = str.length;
		if (len < 2) return;
		boolean[] hit = new boolean[256];
		for (int i = 0; i < 256; i++) {
			hit[i] = false;
		}
		hit[str[0]] = true;
		int tail = 1;
		for (int i = 1; i < len; i++) {
			if (!hit[str[i]]) {
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
			}
		}
		str[tail] = 0;
	}
	
	// 1.4
	// Write a method to decide if two strings are anagrams or not.
	// Given two strings, decide if one is a permutation of the other
	public static boolean isPermutation(String s1, String s2) {
		String sortedOne, sortedTwo;
		sortedOne = sortString(s1);
		sortedTwo = sortString(s2);
		if (sortedOne.equalsIgnoreCase(sortedTwo)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static String sortString(String str) {
		char[] chars = str.toLowerCase().toCharArray();
		Arrays.sort(chars);
		String sorted = new String(chars);
		return sorted;
	}
	
	// 1.5
	// Replace all spaces in a string with '%20'. You may assume that the string has sufficient
	// space at the end of the string to hold the additional characters, and that you are given
	// the "true" length of the string. (User a character array so that the operation can perform
	// this operation in place)
	public static String replaceSpaces(String str, int length) {
		int spacesCount = 0, i, newLength;
		newLength = length;
		for (i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				spacesCount++;
				newLength = newLength + 2;
			}
		}
		
		char[] newString = new char[newLength];
		newString[newLength] = '\0';
		for (i = length; i > 0; i--) {
			if (str.charAt(i) == ' ') {
				newString[newLength-1] = '0';
				newString[newLength-2] = '2';
				newString[newLength-3] = '%';
				newLength = newLength - 3;
			} else {
				newString[newLength-1] = str.charAt(i);
				newLength--;
			}
		}
		return new String(newString);
	}
	
	// Perform basic string compression using the counts of repeated characters.
	// For example: the string aabcccccaaa would be come a2b1c5a3. If the "compressed" string
	// would not become smaller than the original string, your method should return the original
	// string. You can assume the string has only upper and lower case letters (a-z).
	public static String compressString(String str) {
		StringBuilder newString = new StringBuilder();
		char temp, prevChar;
		int charCount = 1;
		prevChar = '\0';
		for (int i = 0; i < str.length(); i++) {
			temp = str.charAt(i);
			if (prevChar != '\0') {
				if (temp == prevChar) {
					charCount++;
				} else {
					newString.append(prevChar);
					newString.append(charCount);
					// 
					charCount = 1;
					prevChar = temp;
				}
			}
			prevChar = temp;
		}
		newString.append(prevChar);
		newString.append(charCount);
		System.out.println("New String: " + newString.toString());
		return newString.toString();
	}
	
	// 1.6
	// Given an image represented by an NxN matrix, where each pixel is 4 bytes, write a method
	// to rotate the image by 90 degrees. Can you do this in place?
	// 1 0 0 2	4 0 0 1
	// 0 0 0 0  0 0 0 0 
	// 0 0 0 0  0 0 0 0 
	// 4 0 0 3  3 0 0 2
	public static void rotateMatrix(int[][] initialMatrix, int length) {
		int temp;
		System.out.println("Rotate Matrix - Initial Matrix:");
		displayMatrix(initialMatrix, length);
		for(int i = 0; i < length; i++) {
			temp = initialMatrix[i][i];
			initialMatrix[i][i] = initialMatrix[i][length - i - 1];
			initialMatrix[i][length - i - 1] = initialMatrix[length - i - 1][length - i - 1];
			initialMatrix[length - i - 1][length - i - 1] = initialMatrix[length - i - 1][i];
			initialMatrix[length - i - 1][i] = temp;
			//for (int j = 0; j < length; j++) {
				//temp = initialMatrix[i][j];
				//initialMatrix[i][j] = initialMatrix[i][length - j - 1];
				//initialMatrix[i][length - j - 1] = initialMatrix[length - i - 1][length - j - 1];
				//initialMatrix[length - i - 1][length - j - 1] = initialMatrix[length - i - 1][j];
				//initialMatrix[length - i - 1][j] = temp;
			//}
		}
		System.out.println("Rotate Matrix - Rotated Matrix:");
		displayMatrix(initialMatrix, length);
	}
	
	// 1.7
	// If an element in an MxN matrix is 0, it's entire row and column are set to 0
	public static void eigenVector(int[][]initialMatrix) {
		int M = initialMatrix.length;
		int N = initialMatrix[0].length;
		displayMatrix(initialMatrix, M);
		ArrayList<Integer> rows = new ArrayList<Integer>();
		ArrayList<Integer> cols = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				if (initialMatrix[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		
		for (Integer i : rows) {
			for (int j = 0; j < N; j++) {
				initialMatrix[i][j] = 0;
			}
		}
		for (Integer j : cols) {
			for (int i = 0; i < M; i++) {
				initialMatrix[i][j.intValue()] = 0;
			}
		}
		displayMatrix(initialMatrix, M);
	}
	
	public static void displayMatrix(int[][] matrix, int n) {
		System.out.println("Displaying Matrix");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	
	public static boolean threeSum(int[] numbers) {
		int j, k;
		for (int i = 0; i < numbers.length - 2; i++) {
			j = i + 1;	// Start right after i
			k = numbers.length - 2;		// Start at the end of the array.
			
			while (k >= j) {
				// If found match
				if (numbers[i] + numbers[j] + numbers[k] == 0) {
					System.out.println(String.format("Found ThreeSum: (%d, %d, %d)", numbers[i], numbers[j], numbers[k]));
					return true;
				}
				
				// No match try to get a little closer
				if (numbers[i] + numbers[j] + numbers[k] > 0) {
					k--;
					j++;
				}
			}
		}
		return false;
	}
}
