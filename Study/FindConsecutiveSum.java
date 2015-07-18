package Study;

public class FindConsecutiveSum {

	//	Given an array of positive integers and  a target integer, 
	//	find if there is a consecutive subarray that sums to the target.
	//	- {5, 6, 4, 12} findsum(10)=true, findsum(11)=false
	public static boolean findSum(int[] nums, int target) {
		int tempSum = 0;
		for (int i = 0; i < nums.length; i++) {
			tempSum = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				tempSum += nums[i];
				if (tempSum == target) return true;
				if (tempSum > target) break;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] nums = {5, 6, 4, 12};
		System.out.println("FindSum(10): ");
		if (findSum(nums, 10)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
		System.out.println("FindSum(11): ");
		if (findSum(nums, 11)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}
}