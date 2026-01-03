import java.util.Scanner;

public class J2016 {

	public static void j3HiddenPalindrome() {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		sc.close();
		
		int record = 0;
		for (int start = 0; start < word.length(); start++){
			for (int end = start + 1; end < word.length() + 1; end++){
				String subString = word.substring(start, end);
				String rev = new StringBuilder(subString).reverse().toString();
				if (subString.equals(rev)){
//					System.out.println(subString);
					if (record < subString.length())
						record = subString.length();
				}
			}
		}
		
		System.out.println(record);
	}

//	06:00 07:00 08:00 09:00 10:00 14:00 15:00 19:00 20:00 23:00
	public static void J4ArrivalTime() {
		Scanner sc = new Scanner(System.in);
		String time = sc.nextLine();
		sc.close();
		
		int now = convertMinutes(time);
		int minutesLeft = 120;
		// before first rush hour
		if (convertMinutes("07:00") > now){
			int minPassed = Math.min(minutesLeft, convertMinutes("07:00") - now);
			now += minPassed;
			minutesLeft -= minPassed;
		}
//		System.out.println(String.format("%s - %s", convertTime(now), convertTime(minutesLeft)));
		// the first rush hour
		if (convertMinutes("07:00") <= now && now < convertMinutes("10:00")){
			int minPassed = Math.min(minutesLeft * 2, convertMinutes("10:00") - now);
			now += minPassed;
			minutesLeft -= minPassed / 2;
		}
//		System.out.println(String.format("%s - %s", convertTime(now), convertTime(minutesLeft)));
		// between rush hours
		if (convertMinutes("10:00") <= now && now < convertMinutes("15:00")){
			int minPassed = Math.min(minutesLeft, convertMinutes("15:00") - now);
			now += minPassed;
			minutesLeft -= minPassed;
		}
//		System.out.println(String.format("%s - %s", convertTime(now), convertTime(minutesLeft)));
		// the second rush hour
		if (convertMinutes("15:00") <= now && now < convertMinutes("19:00")){
			int minPassed = Math.min(minutesLeft * 2, convertMinutes("19:00") - now);
			now += minPassed;
			minutesLeft -= minPassed / 2;
		}
//		System.out.println(String.format("%s - %s", convertTime(now), convertTime(minutesLeft)));
		// after the second rush hour
		if (convertMinutes("19:00") <= now){
			int minPassed = minutesLeft;
			now += minPassed;
			minutesLeft -= minPassed;
		}
//		System.out.println(String.format("%s - %s", convertTime(now), convertTime(minutesLeft)));
		now %= convertMinutes("24:00");
		System.out.println(convertTime(now));
	}

	private static String convertTime(int minutes) {
		return String.format("%02d:%02d", minutes / 60, minutes % 60);
	}

	private static int convertMinutes(String time) {
		String[] times = time.split(":");
//		System.out.println(Integer.valueOf(times[0]));
//		System.out.println(Integer.valueOf(times[1]));
		
		return Integer.valueOf(times[0]) * 60 + Integer.valueOf(times[1]);
	}

}
