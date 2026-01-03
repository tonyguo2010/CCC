import java.util.Scanner;

public class J2017 {

	public static void j3ExactlyElectrical() {
		Scanner sc = new Scanner(System.in);
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int distance = sc.nextInt();
		sc.close();
		
		int xDist = Math.abs(x1 - x2);
		int yDist = Math.abs(y1 - y2);
		distance -= xDist;
		distance -= yDist;
		if (distance < 0){
			System.out.println("N");
		} else if (distance % 2 == 1) {
			System.out.println("N");
		} else {
			System.out.println("Y");
		}
	}

	public static void j4FavouriteTimes() {
		Scanner sc = new Scanner(System.in);
		int times = sc.nextInt();
		sc.close();
		
		int base = 12 * 60;
		int count = 0;
		for (int i = 1; i <= times; i++){
			base ++;
			base = (base - 60) % (12 * 60) + 60;
			int fakeTime = base / 60 * 100 + base % 60;
//			System.out.println(fakeTime);
			if (checkDiff(fakeTime)){
				count ++;
			}
		}
		System.out.println(count);
	}

	private static boolean checkDiff(int fakeTime) {
		int temp = fakeTime;
		int diff = (fakeTime % 100) / 10 - (fakeTime % 100) % 10;
		while (true){
			if (fakeTime / 10 == 0)
				break;
			int newDiff = (fakeTime % 100) / 10 - (fakeTime % 100) % 10;
			if (newDiff != diff)
				return false;
			fakeTime /= 10;
		}
		return true;
	}

}
