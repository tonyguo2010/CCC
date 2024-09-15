import java.util.Scanner;

public class J2012 {

	public static void j3IconScaling() {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		sc.close();
		
		int side = k * 3;
//		for (int row = 1; row <= side; row++){
//			for (int col = 1; col <= side; col ++){
//				System.out.print("#");
//			}
//			System.out.println();
//		}
		for (int row = 1; row <= side; row++){
			for (int col = 1; col <= side; col ++){
				int state = translate(row, col, k);
				
				if (state == 1 || state == 3 || state == 7 || state == 9){
					System.out.print("*");
				}
				else if (state == 2 || state == 5 || state == 6){
					System.out.print("X");
				}
				else if (state == 4 || state == 8){
					System.out.print(" ");
				}
				else{
					System.out.print("#");
				}
			}
			System.out.println();
		}
	}
	private static int translate(int row, int col, int k) {
		int newrow = (row - 1) / k + 1;
		int newcol = (col - 1) / k + 1;
		return (newrow - 1) * 3 + newcol;
//		if (1 <= row && row <= k && 1 <= col && col <= k){
//			return 1;
//		}
//		if (1 <= row && row <= k && k + 1 <= col && col <= 2 * k){
//			return 2;
//		}
//		if (1 <= row && row <= k && 2 * k + 1 <= col && col <= 3 * k){
//			return 3;
//		}
//		
//		if (k + 1 <= row && row <= 2 * k &&  1 <= col && col <= k){
//			return 4;
//		}
//		if (k + 1 <= row && row <= 2 * k &&  k + 1 <= col && col <= 2 * k){
//			return 5;
//		}
//		if (k + 1 <= row && row <= 2 * k && 2 * k + 1 <= col && col <= 3 * k){
//			return 6;
//		}
//		
//		if (2 * k + 1 <= row && row <= 3 * k &&  1 <= col && col <= k){
//			return 7;
//		}
//		if (2 * k + 1 <= row && row <= 3 * k &&  k + 1 <= col && col <= 2 * k){
//			return 8;
//		}
//		if (2 * k + 1 <= row && row <= 3 * k && row <= 3 * k && 2 * k + 1 <= col && col <= 3 * k){
//			return 9;
//		}
//		return -1;
	}



}
