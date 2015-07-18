package Study;

public class ThreeSum {

	public static void threeSum(int [] nums) {
		java.util.Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			int a = nums[i];
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int b = nums[start];
				int c = nums[end];
				if (a+b+c == 0) {
					System.out.println("Found Pairs: ( " + a + ", " + b + ", " + c + ")");
					start = start + 1;
					end = end - 1;
				} else if (a + b + c > 0) {
					end = end - 1;
				} else {
					start = start + 1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {-3, -7, 2, 4, -10, 8, -25, 10};
		threeSum(nums);
	}
}
