package Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HardQuestions {
	//	20.1	Write a function that adds two numbers. You should not use + or any arithmetic operators.
	public int addNums(int a, int b) {
		// Probably have to do some bitwise comparison?
		int sum = 0;
		int remainder = 0;
		for (int i = 0; i < 32; i++) {
			
		}
	}
	
	int add_no_arithmetic(int a, int b) {
		if (b == 0) return a;
		//If I add two binary numbers together but forget to carry, bit[i] will be 0 
		//if bit[i] in a and b are both 0 or 1. This is an XOR
		int sum = a ^ b;	// add without carrying
		int carry = (a & b) << 1;	//carry, but don't add
		return add_no_arithmetic(sum, carry);
	}
	
	//	20.2	Write a method to shuffle a deck of cards. It must be a perfect shuffle - in other words,
	//	each 52! permutations of the deck has to be equally likely. Assume that you are given a randum number
	//	generator which is perfect.
	
	
	//	20.3	Write a method to randomly generate a set of m integers from an array of size n. Each element must
	//	have an equal probability of being chosen.
	
	
	//	20.4	Write a method to count the number of 2's between 0 and n
	
	//	20.5 You have a large text file containing words. Given any two words, find th eshortest distance (in terms of number of words)
	//	between them in the file. Can you make the searchign operation in O(1) time ? What about space complexity for your solution?
	public int findMinDistance(String wordOne, String wordTwo) {
		ArrayList<String> words = new ArrayList();
		HashMap<String, ArrayList<Integer>> wordHash;
		ArrayList<Integer> wordOneIndices;
		ArrayList<Integer> wordTwoIndices;
		int minDistance = Integer.MAX_VALUE;
		wordHash = storeWords(words);
		wordOneIndices = wordHash.get(wordOne);
		wordTwoIndices = wordHash.get(wordTwo);
		for (int index1 : wordOneIndices) {
			for (int index2 : wordTwoIndices) {
				if (Math.abs(index2 - index1) < minDistance) {
					minDistance = Math.abs(index2 - index1);
				}
			}
		}
		return minDistance;
	}
	public HashMap<String, ArrayList<Integer>> storeWords(ArrayList<String> words) {
		HashMap <String, ArrayList<Integer>> wordHash = new HashMap<String, ArrayList<Integer>>();
		int wordCount = 0;
		for (String word : words) {
			if (wordHash.containsKey(word)) {
				ArrayList<Integer> indices = wordHash.get(word);
				indices.add(wordCount);
				wordHash.put(word, indices);
			} else {
				ArrayList<Integer> indices = new ArrayList<Integer>();
				indices.add(wordCount);
				wordHash.put(word,  indices);
			}
		}
		return wordHash;
	}
	
	//	20.6	Describe an algorithm to find the largest 1 million numbers in 1 billion numbers. Assume that the computer memory can hold
	//	all one billion numbers.
	
	//	20.7	Write a program to find the longest word made of other words in a list of words.
	//	EXAMPLE
	//	Input: test, tester, testertest, testing, testingtester
	//	Output: testingtester
	
	//	20.8	Given a string s and an array of smaller strings T, design a method to search s for each small string in T.
	
	//	20.9	Numbers are randomly generated and passed to a method. Write a program to find and maintain the median value as new values are generated.
	
	//	20.10	Given two words of equal length that are in a dictionary, write a method to transform one word into another word by changing only one letter
	//	at a time. The new word you get in each step must be in the dictionary.
	//	EXAMPLE
	//	Input: DAMP, LIKE
	//	Output: DAMP -> LAMP -> LIMP -> LIME -> LIKE
	
	
	//	20.11	Imagine you have a square matrix, where each cell is filled with either black or white. Design an algorithm to find the maximum subsquare
	//	such that all four borders are filled with black pixels.
	
	//	20.12	Given an NxN matrix of positive and negative integers, write code to find the submatrix with the largest possible sum.
	
	//	20.13 	Given a dictionary of millions of words, give an algorithm to find the largest possible rectangle of letters such that every row forms
	//	a word (reading left to right) and every column forms a word (reading top to bottom).
}
