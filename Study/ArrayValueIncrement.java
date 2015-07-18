package Study;

public class ArrayValueIncrement {

	// Given an array a containing all digits 0-9
	// a = [1, 4, 2, 1] # which reperesents 1421
	// Add one to the number and return the array a = [1, 4, 2, 2] which represents 1422
	
	int arrayToNum(int[] arr) {
		int sum = 0;
		int place = 1;
		for (int i = arr.length; i > 0; i--) {
			sum += place * arr[i];
			place *= 10;
		}
		return sum;
	}
	
	int[] numToArray(int num) {
		int sizeCount = 0;
		int tempNum = num;
		while(tempNum > 0) {
			tempNum /= 10;
			sizeCount++;
		}
		int[] arr = new int[sizeCount];
		int multiple = (int) Math.pow(10, sizeCount);
		int remainder = num;
		for (int i = 0; i < sizeCount; i++) {
			arr[i] = remainder / multiple;
			remainder = remainder % multiple;
		}
		return arr;
	}
}
