import java.util.Scanner;

public class J2018 {

	public static void q1TeleMarketer() {
		Scanner sc = new Scanner(System.in);
		int digit1 = sc.nextInt(); 
		int digit2 = sc.nextInt(); 
		int digit3 = sc.nextInt(); 
		int digit4 = sc.nextInt();
		sc.close();
		
		if ( 	(digit1 == 8 || digit1 == 9)
			&&	(digit4 == 8 || digit4 == 9)
			&&	(digit2 == digit3)	){
			System.out.println("ignore");
		} else {
			System.out.println("answer");
		}
			
	}

	public static void q2OccupyParking() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		sc.nextLine();
		String upper = sc.nextLine();
		String lower = sc.nextLine();
		sc.close();
		
		int record = 0;
		for (int i = 0; i < count; i++){
			if (upper.charAt(i) == 'C' && lower.charAt(i) == 'C'){
				record ++;
			}
		}
		
		System.out.println(record);
	}

}
