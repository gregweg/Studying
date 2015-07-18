package Study;

public class QuickSort {
	private int array[];
	private int length;
	
	public void sort(int[] inputArr) {
		if (inputArr == null || inputArr.length == 0) {
			return;
		}
		this.array = inputArr;
		length = inputArr.length;
		quickSort(0, length - 1);
	}

	private void quickSort(int lowerIndex, int higherIndex) {
		int i = lowerIndex;
		int j = higherIndex;
		//	find pivot
		int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
		// Split into two arrays
		while (i <= j) {
			/**
			 * In each iteration, we identify a number from left side
			 * which is greater than the pivot, and identify a number
			 * from right side which is less than the pivot. Once search
			 * is done, we exchange both numbers
			 */
			while (array[i] < pivot) {
				i++;
			}
			
			while (array[j] > pivot) {
				j--;
			}
			
			if (i <= j) {
				exchangeNumbers(i, j);
				// move index to next position on both sides
				i++;
				j--;
			}
		}
		// call quickSort() method recursively
		if (lowerIndex < j) {
			quickSort(lowerIndex, j);
		}
		if (i < higherIndex) {
			quickSort(i, higherIndex);
		}
	}
	
	private void exchangeNumbers(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
