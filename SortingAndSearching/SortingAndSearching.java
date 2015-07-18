package SortingAndSearching;

import java.util.Arrays;

public class SortingAndSearching {

	// You are given two sorted arrays, A and B, and A has a large enough buffer at the end to hold B.
	// Write a method to merge B into A in sorted order
	public void mergeArrays(int[] a, int[] b) {
		for (int i = 0, j = 0; j < b.length; j++) {
			if (a[i] <= b[j]) {
				i++;
				continue;
			} else {
				// shift all a[i]
				int temp = a[i];
				a[i] = b[j];
			}
		}
	}
	public static void mergeArraysh(int[] a, int[] b, int n, int m) {
		int k = m + n - 1;	// Index of last location of array b
		int i = n - 1;	// Index of last element in array b
		int j = m - 1;	// Index of last element in array a
		
		// Start comparing from the last element and merge a and b
		while (i >= 0 && j >= 0) {
			if (a[i] > b[i]) {
				a[k--] = a[i--];
			} else {
				a[k--] = b[j--];
			}
		}
		while ( j >= 0) {
			a[k--] = b[j--];
		}
	}


//	9.2
//	Write a method to sort an array of strings so that all the anagrams are next to
//	each other.


//	9.3
//	Given a sorted array of n integers that has been rotated an unknown number of times,
//	give an O(log n) algorithm that finds an element in the array. You may assume that
//	the array was originally sorted in increasing order.
//	EXAMPLE
//	Input: find 5 in array (15 16 19 20 25 1 3 4 5 7 10 14)
//	Output: 8 (the index of 5 in the array)
	public static int search(int[] a, int l, int u, int x) {
		while (l <= u) {
			int m = (l + u) / 2;
			if (x == a[m]) {
				return m;
			} else if (a[l] <= a[m]) {
				if (x > a[m]) {
					l = m + 1;
				} else if (x >= a[l]) {
					u = m - 1;
				} else {
					l = m + 1;
				}
			}
			else if (x < a[m]) u = m-1;
			else if (x <=a[u]) l = m+1;
			else u = m - 1;
		}
		return -1;
	}
	
	public static int search(int[] a, int x) {
		return search(a, 0, a.length - 1, x);
	}
	


//	9.4
//	If you have a 2 GB file with one string per line, which sorting algorithm would you
//	use to sort the file and why?
	
	//Assuming we have X MB of memory available.
	//1. 	Divide the file into K chunks, where X * K = 2GB. Bring each chunk into memory and
	//		sort the lines as usual using any O(n log n) algorithm. Save the lines back to the file.
	//2.	Now bring the next chunk into memory and sort
	//3.	Once we're done, merge them one by one.
	// Algorithm above is called external sort. Step 3 is known as N-way merge.


//	9.5
//	Given a a sorted array of strings which is interspersed with empty strings, write
//	a method to find the location of a given string.
//	Example: find "ball" in ["at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""]
//	will return 4
//	Example: find "ballcar" in ["at", "", "", "", "", "ball", "car", "", "", "dad", "", ""]
	public int search(String[] strings, String str, int first, int last) {
		while (first <= last) {
			// Ensure that there is something at the end
			while (first <= last && strings[last] == "") {
				--last;
			}
			if (last < first) {
				return -1; // this block was empty, so fail
			}
			int mid = (last + first) >> 1;
			while (strings[mid] == "") {
				++mid;	// will always find one
			}
			int r = strings[mid].compareTo(str);
			if (r == 0) return mid;
			if (r < 0) {
				first = mid + 1;
			} else {
				last = mid - 1;
			}
		}
		return -1;
	}
	
	public int search(String[] strings, String str) {
		if (strings == null || str == null) return -1;
		if (str == "") {
			for(int i = 0; i < strings.length; i++) {
				if (strings[i] == "") return i;
			}
			return -1;
		}
		return search(strings, str, 0, strings.length - 1);
	}
	
//	9.6
//	Given a matrix in which each row and each column is sorted, write a method to find an element in it
	boolean findElem(int[][] mat, int elem, int M, int N) {
		int row = 0;
		int col = N - 1;
		while (row < M && col >= 0) {
			if (mat[row][col] == elem) {
				return true;
			} else if (mat[row][col] > elem) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}


//	9.7
//	A circus is designing a tower routing consisting of people standing atop one another's shoulders.
//	For practical and aesthetic reasons, each person must be both shorter and lighter than the person
//	below him or her. Given the heights and weights of each person in the circus, write a method to compute
//	the largest possible number of people in such a tower.
//	EXAMPLE
//	Input (ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
//	Output: The longest tower is length 6 and includes from top to bottom: (56, 90) (60, 95) (65, 100)
//	(68, 110) (70, 150) (75, 190)
	public class Question {
		ArrayList<HtWt> items;
		ArrayList<HtWt> lastFoundSeq;
		ArrayList<HtWt> maxSeq;
		
		// Returns longer sequence
		ArrayList<HtWt> seqWithMaxLength(ArrayList<HtWt> seq1, ArrayList<HtWt> seq2) {
			return seq1.size() > seq2.size() ? seq1 : seq2;
		}
		
		// Fills next seq w decreased wts&returns index of 1st unfit item.
		int fillNextSeq(int startFrom, ArrayList<HtWt> seq) {
			int firstUnfitItem = startFrom;
			if (startFrom < items.size()) {
				for (int i = 0; i < items.size(); i++) {
					HtWt item = items.get(i);
					if (i == 0 || items.get(i-1).isBefore(item)) {
						seq.add(item);
					} else {
						firstUnfitItem = i;
					}
				}
			}
			return firstUnfitItem;
		}
		
		// Find the maximum length sequence
		void findMaxSeq() {
			Collections.sort(item);
			int currentUnfit = 0;
			while (currentUnfit < items.size()) {
				ArrayList<HtWt> nextSeq = new ArrayList<HtWt>();
				int nextUnfit = fillNextSeq(currentUnfit, nextSeq);
				maxSeq = seqWithMaxLength(maxSeq, nextSeq);
				if (nextUnfit == currentUnfit) break;
				else currentUnfit = nextUnfit;
			}
		}
	}
}