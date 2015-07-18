package Study;

public class LongDivision {

	//	Divide a number by another number and print result and remainder if any, not allowed to use "/" aned "%" operation
	public void longDivide(int number, int divisor) {
		int result = 0;
		int remainder = 0;
		for (int i = 0; i < divisor; i++) {
			if (number > divisor) {
				number = number - divisor;
				result++;
			} else {
				remainder = number;
			}
		}
		if (result > 0) {
			if (remainder > 0) {
				System.out.println(number + " / " + divisor + " = " + result);
			} else {
				System.out.println(number + " / " + divisor + " = " + result + " with remainder: " + remainder);
			}
		} else {
			System.out.println("Was not able to divide " + number + " by " + divisor);
		}
	}
}