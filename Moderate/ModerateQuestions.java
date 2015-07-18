package Moderate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class ModerateQuestions {

	//	19.1	Write a function to swap a number in place without temporary variables
	public static void swapInts(int a, int b) {
		System.out.println("Initially: a = " + a + " b = " + b);
		b = a + b;
		a = b - a;
		b = b - a;
		System.out.println("After Swap: a = " + a + " b = " + b);
	}
	
	//	19.2	Design an algorithm to figure out if someone has won in a game of tic-tac-toe
	public boolean wonTicTacToe(int[][] game) {
		int playerOneH = 0;
		int playerOneV = 0;
		int playerTwoH = 0;
		int playerTwoV = 0;
		for (int i = 0; i < game.length; i++) {
			playerOneH = 0;
			playerOneV = 0;
			playerTwoH = 0;
			playerTwoV = 0;
			for (int j = 0; j < game[0].length; j++) {
				// Check Horizontal
				if (game[i][j] == 1) {
					playerOneH++;
				} else if(game[i][j] == 2) {
					playerTwoH++;
				}
				// Check Vertical
				if (game[j][i] == 1) {
					playerOneV++;
				} else if (game[j][i] == 2) {
					playerTwoV++;
				}
			}
			if (playerOneH == 3 || playerOneV == 3 
					|| playerTwoH == 3 || playerTwoH == 3) return true;
		}
		
		// Check Diagonals
		int playerOneD1 = 0;
		int playerOneD2 = 0;
		int playerTwoD1 = 0;
		int playerTwoD2 = 0;
		for (int i = 0; i < game.length; i++) {
			if (game[i][i] == 1) {
				playerOneD1++;
			} else if (game[i][i] == 2) {
				playerTwoD1++;
			}
			if (game[game.length - i][game.length - i] == 1) {
				playerOneD2++;
			} else if(game[game.length - i][game.length - i] == 1){
				playerTwoD2++;
			}
		}
		
		return false;
	}
	
	//	19.3	Write an algorithm which computes the number of trailing zeros in n factorial
	public int countFactorialZeros(int n) {
		int fact = factorial(n);
		int trailingZeros = 0;
		while(fact % 10 != 0) {
			trailingZeros++;
			fact /= 10;
		}
		return trailingZeros;
	}
	
	public int factorial(int n) {
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}
	
	//	19.4	Write a method which finds the maximum of two numbers. 
	//	You should not use if-else or any other comparison operator.
	//	EXAMPLE
	//	Input: 5, 10
	//	Output: 10
	public int findMaximum(int a, int b) {
		// 1: If a > b; returen  a; else return a.
		// 2: If (a - b) is negative, return b; else, return a
		// 3: If (a - b) is negative, let k = 1; else, k = 0. Return a - l * (a - b)
		// 4: Let c = a - b. Let k = the most significant bit of c. Return a - k * c.
		int c = a - b;
		int k = (c >> 31) & 0x1;
		int max = a - k * c;
		return max;
	}
	
	//	19.5	The Game of Master Mind is played as follows:
	//	The computer has four slots containing balls that are red (R), yellow (Y), green (G), or blue (B).
	//	For example, the computer might have RGGB (e.g.,  Slot #1 is red, Slots # 2 and Slots # are green,Slots #4 is blue)
	//	You the user, are trying to guess the solution. You might, for example, guess YRGB.
	//	When you guess the correct color for the correct slot, you get a "hit". If you guess a color that exists
	//	but is in the wrong slot, you get a "pseudo-hit". For example, the guess YRGB has 2 hits and one pseudo hit.
	//	For each guess, you are told the number of hits and pseudo-hits
	//	Write a method that, given a guess and a solution, returns the number of hits and pseudo hits.
	public static class Result {
		public int hits;
		public int pseudoHits;
	};
	
	public static Result estimate(String guess, String solution) {
		Result res = new Result();
		int solution_mask = 0;
		for (int i = 0; i < 4; ++i) {
			solution_mask |= 1 << (1 + solution.charAt(i) - 'A');
		}
		for (int i = 0; i < 4; ++i) {
			if (guess.charAt(i) == solution.charAt(i)) {
				++res.hits;
			} else if ((solution_mask & (1 << (1 + guess.charAt(i) - 'A'))) >= 1) {
				++res.pseudoHits;
			}
		}
		return res;
	}
	
	public void checkMasterMind(int a, int b, int c, int d) {
		return;
	}
	
	//	19.6	Given an integer between 0 and 999,999, print an English phrase that describes the
	//	integer (eg, "One Thousand, Two Hundred and Thirty Four");
	public void printValue(int n) {
		int remainder = 0;
		int thousandCount = 0;
		int hundredCount = 0;
		int tensCount = 0;
		int onesCount = 0;
		
		
		thousandCount = n / 1000;
		remainder = n % 1000;
		hundredCount = remainder / 100;
		remainder = n % 100;
		tensCount = remainder / 10;
		onesCount = remainder % 10;
	}
	
	public static String numToString(int num) {
		StringBuilder sb = new StringBuilder();
		
		// Count the number of digits in num
		int len = 1;
		while (Math.pow((double)10, (double)len) < num) {
			len++;
		}
		
		String[] wordarr1 = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
		String[] wordarr11 = {"", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
		String[] wordarr10 = {"", "Ten ", "Twenty ", "Thirty ", "Fourty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
		String[] wordarr100 = {"", "Hundred ", "Thousand "};
		int tmp;
		if (num == 0) {
			sb.append("Zero");
		} else {
			if (len > 3 && len % 2 == 0) {
				len++;
			}
			do {
				// Number greater than 999
				if (len > 3) {
					tmp = (num / (int)Math.pow((double)10, (double)len - 2));
					// If tmp is 2 digit number and not a multiple of 10
					if (tmp / 10 == 1 && tmp%10 != 0) {
						sb.append(wordarr1[tmp % 10]);
					} else {
						sb.append(wordarr10[tmp / 10]);
						sb.append(wordarr1[tmp % 10]);
					}
					if (tmp > 0) {
						sb.append(wordarr100[len / 2]);
					}
					num = num % (int)(Math.pow((double)10, (double)len - 2));
					len = len - 2;
				} else {	// Number is less than 1000
					tmp = num / 100;
					if (tmp != 0) {
						sb.append(wordarr1[tmp]);
						sb.append(wordarr100[len / 2]);
					}
					tmp = num % 100;
					if (tmp / 10 == 1 &&  tmp % 10 != 0) {
						sb.append(wordarr11[tmp % 10]);
					} else {
						sb.append(wordarr10[tmp / 10]);
						sb.append(wordarr1[tmp % 10]);
					}
					len = 0;
				}
			} while (len > 0);
		}
		return sb.toString();
	}
	
	/*public void printValue(int thousands, int hundreds, int tends, int ones) {
		if (thousands > 0) {
			switch (thousands) {
			case
			}
		}
	}*/
	
	//	19.7	You are given an array of integers (both positive and negative). Find the continuous
	//	sequence with the largest sum. Return the sum.
	//	EXAMPLE
	//	Input: {2, -8, 3, -2, -4, -10}
	//	Output: 5 (i.e., {3, -2, 4} )
	public int findLargestSequence(int[] seq) {
		int largestSum = -1;
		int tempMax = seq[0];
		for (int i = 1; i < seq.length; i++) {
			if (seq[i] > 0) {
				tempMax += seq[i];
				if (tempMax > largestSum) {
					largestSum = tempMax;
				}
			} else {
				if (tempMax + seq[i] > 0) {
					tempMax += seq[i];
				} else {
					tempMax = 0;
				}
			}
		}
		return largestSum;
	}
	
	public static int getMaxSum(int[] a) {
		int maxsum = 0;
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (maxsum < sum) {
				maxsum = sum;
			} else if (sum < 0){
				sum = 0;
			}
		}
		return maxsum;
	}
	
	//	19.8	Design a method to find the frequency of occurences of any given word in a book
	public void frequencyCount(ArrayList<String> words) {
		Map<String, Integer> bookWords = new HashMap<String, Integer>();
		for (String word : words) {
			if (bookWords.containsKey(word)) {
				bookWords.put(word, bookWords.get(word) + 1);
			} else {
				bookWords.put(word, 1);
			}
		}
	}
	
	Hashtable<String, Integer> setupDictionary(String[] book) {
		Hashtable<String, Integer> table = new Hashtable<String, Integer>();
		for (String word : book) {
			word = word.toLowerCase();
			if (word.trim() != "") {
				if (!table.containsKey(word)) table.put(word, 0);
				table.put(word,  table.get(word) + 1);
			}
		}
		return table;
	}
	int getFrequency(Hashtable<String, Integer> table, String word) {
		if (table == null || word == null) return -1;
		word = word.toLowerCase();
		if (table.containsKey(word)) {
			return table.get(word);
		}
		return 0;
	}
	
	//	19.9
	//	Since XML is very verbose, you are given a way of encoding it where each tag gets mapped to a pre-defined integer value.
	//	The language/grammar is as follows:
	//		Element --> Element Attr* END Element END [aka, encode the element tag, then its attributes, then tack on an END character,
	//		then encode its children, then encode another tag]
	//		Attr --> Tag Value [assume all values are strings]
	//		END	--> 01
	//		Tag --> some predefined mapping to int
	//		Value --> string value END
	//	Write code to print the encoded version of an xml element (passed in as string).
	//	FOLLOW UP
	//	Is there anything else you could do to (in many cases) compress this even further?
	
	//	19.10
	//	Write a method to generate a random number between 1 and 7, given a method that generates a random number between 1 and 5 (i.e., implement rand7()
	//	using rand5()).
	//public static int rand7() {
	//	while (true) {
	//		int num = 5 * (rand5() - 1) + (rand5() - 1);
	//		if (num < 21) return (num % 7 + 1);
	//	}
	//}
	
	
	//	19.11	Design an algorithm to find all pairs of integers within an array which sum to a specified value.
	public void findAlgPairs(int[] nums, int val) {
		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>(); 
		for (int i = 0; i < nums.length; i++) {
			numMap.put((Integer) nums[i], 1);
			int pairValue = val - nums[i];
			if (numMap.containsKey(pairValue)) {
				System.out.println("Found Pair: (" + nums[i] + ", " + pairValue + ")");
			}
		}
	}
	
	public static void printPairSums(int[] array, int sum) {
		Arrays.sort(array);
		int first = 0;
		int last = array.length - 1;
		while (first < last) {
			int s = array[first] + array[last];
			if (s == sum) {
				System.out.println(array[first] + " " + array[last]);
				++first;
				--last;
			} else {
				if (s < sum) ++first;
				else --last;
			}
		}
	}
}
