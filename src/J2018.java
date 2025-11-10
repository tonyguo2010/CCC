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

	// 3 10 12 5
	public static void q3AreWeThereYet() {
		Scanner sc = new Scanner(System.in);
		int[] dists = new int[4];
		for (int i = 0; i < 4; i++){
			dists[i] = sc.nextInt(); 
		}
		for (int start = 0; start < 5; start++){
			for (int end = 0; end < 5; end++){
				int sum = addDistance(start, end, dists);
				System.out.print(sum + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static int addDistance(int start, int end, int[] dists) {
		int sum = 0;
		for (int i = Math.min(start, end); i < Math.max(start, end); i++){
			sum += dists[i];
		}
		return sum;
	}

	/*
3
4 3 1
6 5 2
9 7 3
	 */
	public static void q4SunFlower() {
		Scanner sc = new Scanner(System.in);
		int side = sc.nextInt();
		int[][] matrix = new int[side][side];
		for (int row = 0; row < side; row++) {
			for (int col = 0; col < side; col++) {
				matrix[row][col] = sc.nextInt();
			}
		}
		sc.close();
		
		rotate(matrix, side);
		
		for (int row = 0; row < side; row++) {
			for (int col = 0; col < side; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}
	}

	private static void rotate(int[][] matrix, int side) {
		int[][] temp = new int[side][side];
		for (int row = 0; row < side; row++) {
			for (int col = 0; col < side; col++) {
				temp[col][side - row - 1] = matrix[row][col];
			}
		}
		for (int row = 0; row < side; row++) {
			for (int col = 0; col < side; col++) {
				matrix[row][col] = temp[row][col];
			}
		}
	}

}
