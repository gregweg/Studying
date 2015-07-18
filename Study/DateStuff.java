package Study;

import java.util.Calendar;
import java.util.Date;

public class DateStuff {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 2);
		cal.set(Calendar.HOUR_OF_DAY, 1);
		cal.set(Calendar.MINUTE, 30);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date start = cal.getTime();
		long startLong = start.getTime();
		cal.set(Calendar.MINUTE, 32);
		cal.set(Calendar.SECOND, 30);
		Date end = cal.getTime();
		long endLong = end.getTime();
		System.out.println("Start: " + startLong);
		System.out.println("End: " + endLong);
	}
}
