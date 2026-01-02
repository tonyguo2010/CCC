import java.util.Scanner;

public class J2019 {

/*
4
+++===!!!!
777777......TTTTTTTTTTTT
(AABBC)
3.1415555
*/
	public static void j3ColdCompress() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < count; i++){
			handleLine(sc.nextLine());
		}
		sc.close();
	}

	private static void handleLine(String nextLine) {
		char last = 0;
		int count = 0;
		
		for (int i = 0; i < nextLine.length(); i++){
			char current = nextLine.charAt(i);
			boolean state = (last == current);
			
			if (state == true){
				count ++;
			}
			else{
				if (last != 0){
					System.out.print("" + count + last);
				}
				last = current;
				count = 1;
			}
		}
		
		if (count > 0)
			System.out.println("" + count + last);
	}

}
