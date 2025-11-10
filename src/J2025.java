import java.util.ArrayList;
import java.util.Scanner;

class Cell{
	public int row;
	public int col;
	public int val;
}
public class J2025 {

	public static void J3ProductCodes() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] inputs = new String[N];
		sc.nextLine();
		for (int i = 0; i < N; i++){
			inputs[i] = sc.nextLine();
		}
		sc.close();
		
		for (int i = 0; i < N; i++){
			handle(inputs[i]);
		}
	}

	private static void handle(String in) {
		int state = -1;
		StringBuilder sb = new StringBuilder();
		int amt = 0;
		int accumulation = 0;
		int factor = 1;
		
		for (int i = 0; i < in.length(); i++){
			char ch = in.charAt(i);
			state = getState(ch, state);
			switch (state) {
			case 0:
				sb.append(ch);
				amt += (factor * accumulation);
				factor = 1;
				accumulation = 0;
				break;
			case 1: // keep numbering
			{
				int num = (ch - '0');
				accumulation = accumulation * 10 + num;
				break;
			}
			case 2: // -
				amt += (factor * accumulation);
				factor = 1;
				accumulation = 0;
				factor = -1;
				break;
			case 3:	// new digit
			{
				int num = (ch - '0');
//				factor = 1;
				accumulation = 0;
				accumulation = num;
				break;
			}
			default:
				amt += (factor * accumulation);
				factor = 1;
				accumulation = 0;
				break;
			}
//			System.out.println(".......");
//			System.out.println("parsing " + ch);
//			System.out.println(accumulation);
//			System.out.println(amt);
		}
//		PL12N-2G1234Duytrty8-86tyaYySsDdEe
		amt += (factor * accumulation);
		
		System.out.println(sb.append(String.valueOf(amt)));
	}

	private static int getState(char charAt, int state) {
		if ('a' <= charAt && charAt <= 'z')
			return -1;
		if ('A' <= charAt && charAt <= 'Z')
			return 0;
		if ('0' <= charAt && charAt <= '9' && (state == 1 || state == 3)) // keep number coming
			return 1;
		if ('0' <= charAt && charAt <= '9' && state != 1) // new number
			return 3;
		if ('-' == charAt)
			return 2;
		return 0;
	}

	public static void J4SunnyDays() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		String sb = "";
		for (int i = 0; i < N; i++){
			sb += sc.nextLine();
		}
		sc.close();
//		System.out.println(sb);
		
		String recordDays = ""; 
		for (int start = 0; start < N; start++){
			for (int end = start + 1; end < N + 1; end++){
//				System.out.println(sb.toString().substring(start, end));
				String sub = sb.substring(start, end);
				if (containsAtMost1P(sub) == true && sub.length() > recordDays.length()){
					recordDays = sub;
				}
			}
		}
		System.out.println(recordDays.length());
	}

	private static boolean containsAtMost1P(String sub) {
		int count = 0;
		for (int i = 0; i < sub.length(); i++){
			if (sub.charAt(i) == 'P')
				count ++;
		}
		return (count <= 1);
	}

	public static void J5ConnectingTerritories() {
		Scanner sc = new Scanner(System.in);
//		int rows = sc.nextInt();
//		int cols = sc.nextInt();
//		int cycle = sc.nextInt();
		int rows = 3;
		int cols = 5;
		int cycle = 7;
		sc.close();
		
		int[][] map = new int[rows][cols];
		int value = 0;
		for (int row = 0; row < rows; row++){
			for (int col = 0; col < cols; col++){
				value = value % cycle + 1;
				map[row][col] = value;
			}
		}
		
//		print(map, rows, cols);
		
		for (int i = 0; i < cols; i++){
			Cell root = new Cell();
			root.row = 0;
			root.col = i;
			root.val = map[0][i];
			recur(root, map, rows, cols, root.val);
		}
		
		System.out.println(record);
	}

	static int record = Integer.MAX_VALUE;
	private static void recur(Cell root, int[][] map, int rows, int cols, int amount) {
//		System.out.println(String.format("%d %d %d", root.row, root.col, root.val));
		if (root.row == rows -1){
//			System.out.println(amount);
			record = Math.min(record, amount);	
			return;
		}
		for (int i = root.col - 1; i <= root.col + 1; i++){
			try{
				Cell node = new Cell();
				node.row = root.row + 1;
				node.col = i;
				node.val = map[node.row][node.col];
				recur(node, map, rows, cols, amount + node.val);
//				return all;
			}
			catch(Exception e){
			}
		}
	}

	private static void print(int[][] map, int rows, int cols) {
		for (int row = 0; row < rows; row++){
			for (int col = 0; col < cols; col++){
				System.out.print(" " + map[row][col]);
			}
			System.out.println();
		}
	}

	public static void J2DonutShop() {
		Scanner sc = new Scanner(System.in);
		// get base number
		int base = sc.nextInt();
		// how many rounds to repeat/calculate
		int round = sc.nextInt();
		// check every operator
		for (int i = 0; i < round; i++){
			// use the operator to calculate
			String oper = sc.next();
			int number = sc.nextInt();
			if (oper.equals("+")){
				base = base + number;
			}
			if (oper.equals("-")){
				base = base - number;
			}
		}
		// output the result
		System.out.println(base);
		sc.close();
	}

}
