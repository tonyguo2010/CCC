import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class msg
{
	public boolean success;
	public String message;
}
public class Main {
	static ArrayList<char[][]> results = new ArrayList<char[][]>();
	
	public static void main(String[] args) {		
		J2024.q4BronzeCount();
	}

	private static void test() {
		char[][] board = new char[3][3];
		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 3; col++){
				board[row][col] = 'O';
			}
		}
		recur(board, 3);
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
