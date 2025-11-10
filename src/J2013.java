import java.util.Arrays;
import java.util.Scanner;

public class J2013 {

	public static void j3DistinctNumber() {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		sc.close();
		
		// keep finding the next number
		while(true){
			// if this is a "distinct number", let us quit the loop
			start ++;
			if (isDistinct(start) == true){
				break;
			}
		}
		
		System.out.println(start);
	}

	private static boolean isDistinct(int start) {
		int[] counters = new int[10];
		while (true){
			int ones = start % 10;
//			System.out.println(ones);
			counters[ones] ++;
			start = start / 10;
			if (start == 0){
				break;
			}
		}
		
		for (int digit = 0; digit < 10; digit++){
//			System.out.println(counters[digit]);
			if (counters[digit] > 1)
				return false;
		}
		return true;
	}

	public static void q4TimeOnTask() {
		Scanner sc = new Scanner(System.in);
		int all = sc.nextInt();
		int count = sc.nextInt();
		int[] inputs = new int[count];
		for (int i = 0; i < count; i++){
			inputs[i] = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(inputs);
		
		int sum = 0;
		int record = 0;
		for (int i = 0; i < count; i++){
			System.out.println(inputs[i]);
			sum += inputs[i];
			if (sum <= all){
				record ++;
			}
		}
		
		System.out.println(record);
	}

}
