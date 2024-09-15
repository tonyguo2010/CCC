import java.util.Scanner;

public class J2021 {

	public static void q2() {
		
		Scanner sc = new Scanner(System.in);
		int people = sc.nextInt();
		
		String[] names = new String[people];
		int[] orders = new int[people];
		sc.nextLine();
		
		for (int i = 0; i < people; i++){
			names[i] = sc.nextLine();
			orders[i] = sc.nextInt();
			sc.nextLine();
		}
		sc.close();
		
		int maxRecord = 0;
		String maxPerson = "";
		for (int i = 0; i < people; i++){
			if (maxRecord < orders[i]){
				maxPerson = names[i];
				maxRecord = orders[i];
			}
		}
		
		System.out.println(maxPerson);
	}

}
