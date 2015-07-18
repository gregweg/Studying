package BitManipulation;

public class BitManipulation {

	// You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a
	// method to set all bits between i and j in N equal to M (e.g., M becomes a substring of
	// N located at i and starting at j.)
	// EXAMPLE
	// Input: N = 10000000000, M = 10101, i = 2, j = 6
	// Output: N = 10001010100
	
	public static int updateBits(int n, int m, int i, int j) {
		int max = ~0;	/* All 1's */
		
		// 1's through position j, then 0's
		int left = max - ((1 << j) - 1);
		
		// 1's after position i
		int right = ((1 << i) - 1);
		
		// 1's, with 0s between i and j
		int mask = left | right;
		
		// Clear i through j, then put m in there
		return (n & mask) | (m << i);
	}
	
	
	
	// Given a (decimal - e.g 3.72) number that is passed in as a string, print the binary
	// representation. If the number can not be represented accurately in binary, print "ERROR"
	public static String printBinary(String n) {
		int intPart = Integer.parseInt(n.substring(0, n.indexOf('.')));
		double decPart = Double.parseDouble(n.substring(n.indexOf('.'), n.length()));
		String int_string = "";
		while (intPart > 0) {
			int r = intPart % 2;
			intPart >>= 1;
			int_string = r + int_string;
		}
		
		StringBuffer dec_string = new StringBuffer();
		while (decPart > 0) {
			if (dec_string.length() > 32) return "ERROR";
			if (decPart == 1) {
				dec_string.append((int)decPart);
				break;
			}
			double r = decPart * 2;
			if (r >= 1) {
				dec_string.append(1);
				decPart = r - 1;
			} else {
				dec_string.append(0);
				decPart = r;
			}
		}
		return int_string + "." + dec_string.toString();
	}
	
	
	// Given an integer, print the next smallest and next largest number that have the same
	// number of 1 bits in their binary representation.
	public void printSmallerAndLarger(int num) {
		//					10010011
		//	Next Smallest	10001011
		//	Next Largest	10010101
		//  				10010010
		//	Next Smallest	10010001	// 
		// 	Next Largest 	10010100
	}
	
	public static boolean GetBit(int n, int index) {
		return ((n & (1 << index)) > 0);
	}
	
	public static int SetBit(int n, int index, boolean b) {
		if (b) {
			return n | (1 << index);
		} else {
			int mask = ~(1 << index);
			return n & mask;
		}
	}
	
	public static int GetNext_NP(int n) {
		if (n <= 0) return -1;
		
		int index = 0;
		int countOnes = 0;
		
		// Find first one.
		while (!GetBit(n, index)) index++;
		
		// Turn on next zero.
		while (GetBit(n, index)) {
			index++;
			countOnes++;
		}
		n = SetBit(n, index, true);
		
		// Turn off previous one
		index--;
		n = SetBit(n, index, false);
		countOnes--;
		
		// Set zeros
		for (int i = index - 1; i >= countOnes; i--) {
			n = SetBit(n, i, false);
		}
		
		// Set ones
		for (int i = countOnes; i >= 0; i--) {
			n = SetBit(n, i, true);
		}
		
		return n;
	}
	
	public static int GetPrevious_NP(int n) {
		if (n <= 0) return -1;	// Error
		
		int index = 0;
		int countZeros = 0;
		
		// Find first zero.
		while (GetBit(n, index)) index++;
		
		// Turn off next 1.
		while (!GetBit(n, index)) {
			index++;
			countZeros++;
		}
		n = SetBit(n, index, false);
		
		// Turn on previous zero
		index--;
		n = SetBit(n, index, true);
		countZeros--;
		
		// Set ones
		for (int i = index - 1; i >= countZeros; i--) {
			n = SetBit(n, i, true);
		}
		
		// Set zeros
		for (int i = countZeros - 1; i >= 0; i--) {
			n = SetBit(n, i, false);
		}
		
		return n;
	}
	
	// Explain what the following code does: ((n & (n - 1)) == 0).
	
	
	// Write a function to determine the number of bits required to convert integer A to integer B.
	// Input: 31, 14
	// Output: 2
	
	
	public static int bitSwapRequired(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c >> 1) {
			count += c & 1;
		}
		return count;
	}
	
	
	// Write a program to swap odd and even bits in an integer with as few instructions as possible
	// (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, etc)."
	
	public static int swapOddEvenBits(int x) {
		return ( ((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1) );
	}
	
	
	// An array A[1..n] contains all the integers from 0 to n except for one number which is
	// missing. In this problem, we cannot access an entier integer in A with a single operation.
	// The elements of A are represented in binary, and the only operation we can use to access
	// them is "fetch the jth bit of A[i]", which takes constant time. Write code to find the missing
	// integer. Can you do it in O(n) time?
	
	int findMissing(ArrayList<BitInteger> array) {
		return findMissing(array, BitInteger.INTEGER_SIZE - 1);
	}
	int findMissing(ArrayList<BitInteger> input, int column) {
		if (column < 0) {	// Base case and error condition
			return 0;
		}
		ArrayList<BitInteger> oddIndices = new ArrayList<BitInteger>();
		ArrayList<BitInteger> evenIndices = new ArrayList<BitInteger>();
		for (BitInteger t : input) {
			if (t.fetch(column) == 0) {
				evenIndices.add(t);
			} else {
				oddIndices.add(t);
			}
		}
		if (oddIndices.size() >= evenIndices.size()) {
			return (findMissing(evenIndices, column - 1)) << 1 | 0;
		} else {
			return (findMissing(oddIndices, column - 1)) << 1 | 1;
		}
	}
}
