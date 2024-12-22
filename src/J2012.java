import java.util.ArrayList;
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
	
/*
3
FXAB
 */
	public static void j4BigBang2() {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		sc.nextLine();
//		String codeTable = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String input = sc.nextLine();
		sc.close();
		
		for (int index = 0; index < input.length(); index++){
			char S = input.charAt(index);
			int shift = (index + 1) * 3 + K;
//			System.out.println(shift);
//			int posS = codeTable.indexOf(S) + 1;
			int posS = (S - 'A') + 1;
//			System.out.println(posS);
			int posP = ((posS - shift - 1) + 26) % 26;
//			System.out.println(posP);
//			char P = codeTable.charAt(posP);
			char P = (char) ('A' + posP);
			System.out.print(P + "");
		}
	}


/*
3
FXAB
 */
	
	// S = 3P + K
	public static void j4BigBang1() {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		sc.nextLine();
		String codeTable = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String input = sc.nextLine();
		sc.close();
		
		for (int index = 0; index < input.length(); index++){
			char S = input.charAt(index);
			int shift = (index + 1) * 3 + K;
//			System.out.println(shift);
			int posS = codeTable.indexOf(S) + 1;
//			System.out.println(posS);
			int posP = ((posS - shift - 1) + 26) % 26;
//			System.out.println(posP);
			char P = codeTable.charAt(posP);
			System.out.print(P + "");
		}
	}

}
