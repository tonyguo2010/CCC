import java.util.ArrayList;
import java.util.Scanner;

class Room {
	public int row;
	public int col;
	public int value;
}

public class J2020 {
	
	public static void J5EscapeRoom() {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		int[][] map = new int[rows + 1][cols + 1];
		for (int row = 1; row <= rows; row++){
			for (int col = 1; col <= cols; col++){
				map[row][col] = sc.nextInt();
			}
		}
		sc.close();
		
		ArrayList<Room> path = new ArrayList<Room>();
		Room root = new Room();
		root.row = 1;
		root.col = 1;
		root.value = map[1][1];
		path.add(root);
		
		int step = 0;
		while(true){
			if (step >= path.size())
				break;
			
			Room current = path.get(step);
			ArrayList<Room> subs = getSubs(current, map);
			for (Room sub : subs){
				if (contains(path, sub) == false){
					path.add(sub);
				}
			}
			step++;
		}
		
		Room ending = new Room();
		ending.row = rows;
		ending.col = cols;
		
		if (contains(path, ending)){
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	private static boolean contains(ArrayList<Room> path, Room sub) {
		for (Room node : path){
			if (node.row == sub.row && node.col == sub.col){
				return true;
			}
		}
		return false;
	}

	private static ArrayList<Room> getSubs(Room current, int[][] map) {
		ArrayList<Room> result = new ArrayList<Room>();
		for (int factor1 = 1; factor1 <= current.value; factor1++){
			for (int factor2 = 1; factor2 <= current.value; factor2++){
				if (factor1 * factor2 == current.value){
					try{
						Room next = new Room();
						next.row = factor1;
						next.col = factor2;
						next.value = map[factor1][factor2];
						result.add(next);
//						System.out.println("" + factor1 + " " + factor2);
					}
					catch(Exception e){
					}
				}
			}
		}
			
		return result;
	}

}
