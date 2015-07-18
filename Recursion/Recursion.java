package Recursion;

import java.util.ArrayList;

public class Recursion {

	//	Write a method to generate the nth Fibonacci number.
	public static int genNthFib(int n) {
		if (n == 0) return 0;
		if (n == 1) return 0;
		if (n > 1) {
			return genNthFib(n - 1) + genNthFib(n - 2);
		} else {
			return -1;
		}
	}
	
	
	// Imagine a robot sitting on the upper left hand corner of a NxN grid. The robot can
	// only move in two directions: right and down. How many possible paths are there for the robot?
	//	FOLLOW UP
	//	Imagine certain squares are "off limits", such that the robot can not step on them.
	//	Design an alrogithm to get all possible paths for the robot.
	
	// Each path has (X-1) + (Y-1) steps. Imagine the following paths:
	//		X X Y Y X (move right -> right -> down -> down -> right)
	//		X Y X Y X (move right -> down -> right -> down -> right)
	//	Since you must always move right X - 1 times, and you have X  - 1 + Y - 1 total steps,
	//  you have to pick X-1 times to move right out of X-1+Y-1 choices. Thus, there are
	//  C(X-1, X-1+Y-1) paths
	class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<Point> current_path = new ArrayList<Point>();
	public static boolean getPaths(int x, int y) {
		Point p = new Point(x, y);
		current_path.add(p);
		if (0 == x && 0 == y) return true; // current_path
		boolean success = false;
		if (x >= 1) {
		//if (x >= 1 && is_free(x - 1, y)) {
			success = getPaths(x - 1, y);	// Go Right
		}
		if (!success && y >= 1) {
		//if (!success && y >= 1 && is_free(x, y - 1)) {
			success = getPaths(x, y - 1);	// Go down
		}
		if (!success) {
			current_path.remove(p);	// wrong way!
		}
		return success;
	}
	
	public int makeMove(int x, int y, int n, int moves) {
		if (x == n && y == n) {
			return moves;
		}
		// move right
		if (x < n) {
			moves++;
			x++;
		}
		// move down
		if (y < n) {
			moves++;
			y++;
		}
	}
	
	
	//	Write a method that returns all subsets of a set
	public void genAllSubsets() {
		
	}

	
	ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allsubsets;
		if (set.size() == index) {
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());	// Empty set
		} else {
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allsubsets) {
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}
	
	ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size();
		for (int i = 0; i < max; i++) {
			ArrayList<Integer> subset = new ArrayList<Integer>();
			int k = i;
			int index = 0;
			while (k > 0) {
				if ((k & 1) > 0) {
					subset.add(set.get(index));
				}
				k >>= 1;
				index++;
			}
			allsubsets.add(subset);
		}
		return allsubsets;
	}
	
	//	Write a method to compute all permutations of a string.
	public int genAllPermutations(String str) {
		char[] characters = str.toCharArray();
		
	}
	
	// If our string is "abc"
	//1.	Let first = "a" and let remainder = "bc"
	//2.	Let list = permute(bc) = ("bc", "cb")
	//3.	Push "a" into each location of "bc" (--> "abc", "bac", "bca") and "cb" (--> "acb", "cab", "cba")
	//4.	return our new list
	public static ArrayList<String> getPerms(String s) {
		ArrayList<String> permutations = new ArrayList<String>();
		if (s == null) {
			return null;
		} else if(s.length() == 0) { // base case
			permutations.add("");
			return permutations;
		}
		
		char first = s.charAt(0);	// get the first character
		String remainder = s.substring(1);	// remove the first character
		ArrayList<String> words = getPerms(remainder);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				permutations.add(insertCharAt(word, first, j));
			}
		}
		return permutations;
	}
	
	public static String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}
	
	
	
	//	Implement an algorithm to print all valid (e.g... properly opened and closed) combinations
	//	of n-pairs of parentheses.
	//	EXAMPLE:
	//	Input: 3 (e.g., 3 pairs of parenthesis)
	//	Output: ()()(), ()(()), (())(), ((()))
	public void printAllValidParentheses(int n) {
		if (n == 0) return;
		if (n == 1) {
			System.out.print("()");
		} else if(n > 1) {
			
		}
	}
	
	//	Left: As long as we haven't used up all the left parenthesis, we can always insert a left paren
	// 	Right: We can insert a right paren as long as it won't lead to a syntax error. When will we get
	//	a syntax error? We will get a syntax error if there are more right parentheses than left.
	public static void printPar(int l, int r, char[] str, int count) {
		if (l < 0 || r < 1) return;	// invalid state
		if (l == 0 && r == 0) {
			System.out.println(str);	// found one, so print it
		} else {
			if (l > 0) {	// try a left paren, if there are some available
				str[count] = '(';
				printPar(l - 1, r, str, count + 1);
			}
			if (r > l) {	// try a right paren, if there's a matching left
				str[count] = ')';
				printPar(1, r - 1, str, count + 1);
			}
		}
	}
	
	public static void printPar(int count) {
		char[] str = new char[count*2];
		printPar(count, count, str, 0);
	}
	
	//	Implement the "paint fill" function that one might see on many image editing programs. That is,
	//	given a screen (represented by a 2 dimensional array of Colors), a point, and a new color,
	//	fill in the surrounding area until you hit a border of that color
	enum Color {
		Black, White, Red, Yellow, Green
	}
	boolean PaintFill(Color[][] screen, int x, int y, Color ocolor, Color ncolor) {
		if (x < 0 || x >= screen[0].length || 
				y < 0 || y >= screen.length) {
			return false;
		}
		if (screen[y][x] == ocolor) {
			screen[y][x] = ncolor;
			PaintFill(screen, x - 1, y, ocolor, ncolor);	// left
			PaintFill(screen, x + 1, y, ocolor, ncolor);	// right
			PaintFill(screen, x, y - 1, ocolor, ncolor);	// top
			PaintFill(screen, x, y + 1, ocolor, ncolor);	// bottom
		}
		return true;
	}
	
	boolean PaintFill(Color[][] screen, int x, int y, Color ncolor) {
		return PaintFill(screen, x, y, screen[y][x], ncolor);
	}
	
	
	//	Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies
	//	(1 cent), write code to calculate the number of ways of representing n cents.
	
	public static int makeChange(int n, int denom) {
		int next_denom = 0;
		switch(denom) {
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
			break;
		case 5:
			next_denom = 1;
			break;
		case 1:
			return 1;
		}
		int ways = 0;
		for (int i = 0; i * denom <= n; i++) {
			ways += makeChange(n - i * denom, next_denom);
		}
		return ways;
	}
	//System.out.writeln(makeChange(n, 25));
	
	//	Write an algorithm to print all ways of arranging eight queens on a chess board so that none of
	// them share the same row, column, or diagonal.
	// 1. Store the column of the queen in each row as soon as we have finalized it. LetColumnForRow[] be the array
	// which stores the column number for each row.
	// 2. The checks required for the three given conditions are:
	//		* On same Column:	ColumnForRow[i] == ColumnForRow[j]
	//		* On same Diagonal:	(ColumnForRow[i] - ColumnForRow[j] == (i - j) or
	//		*					(ColumnForRow[j] - ColumnForRow[i] == (i - j)
	int columnForRow[] = new int [8];
	boolean check(int row) {
		for (int i = 0; i < row; i++) {
			int diff = Math.abs(columnForRow[i] - columnForRow[row]);
			if (diff == 0 || diff == row - i) return false;
		}
		return true;
	}
	
	void PlaceQueen(int row) {
		if (row == 8) {
			printBoard();
			return;
		}
		for (int i = 0; i < 8; i++) {
			columnForRow[row]=i;
			if (check(row)) {
				PlaceQueen(row+1);
			}
		}
	}
}
