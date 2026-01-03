import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class msg
{
	public boolean success;
	public String message;
}
public class Main {
	static ArrayList<char[][]> results = new ArrayList<char[][]>();
	
	public static void main(String[] args) {		
		J2010.q3Punchy();
	}

	/*
1 3
3 2
5 1
2 3
	 */
	private static void test() {
		Scanner sc = new Scanner(System.in);
		int temp = sc.nextInt();
		int count = sc.nextInt();
		HashSet<Integer> ans = new HashSet<>();
		
		for (int i = 0; i < count; i++){
			int hot = sc.nextInt();
			int fresh = sc.nextInt();
			int days = hot - temp;
			if (days <= fresh){
				while (true){
					if (ans.contains(days) == false){
						ans.add(days);
						break;
					}
					days --;
					if (days == 0){
						break;
					}
				}
			}
		}
		sc.close();
		
		System.out.println(ans.size());
	}

	private static void print(char[][] board, int cnt) {
		for (int row = 0; row < cnt; row++){
			for (int col = 0; col < cnt; col++){
				System.out.print(board[row][col]);
			}
			System.out.println();
		}
	}

	private static void recur(char[][] board, int cnt) {
		if (cnt == 0){
			print(board, 3);
			System.out.println();
			return;
		}
		
		for (int row = 0; row < cnt; row++){
			for (int col = 0; col < cnt; col++){
				if (board[row][col] == 'O'){
					char[][] sub = new char[3][3];
					copy(sub, board, 3);
					sub[row][col] = 'X';
					recur(sub, cnt - 1);
				}
			}
		} 
	}

	private static void copy(char[][] sub, char[][] board, int cnt) {
		for (int row = 0; row < cnt; row++){
			for (int col = 0; col < cnt; col++){
				sub[row][col] = board[row][col];
			}
		}
	}
}
