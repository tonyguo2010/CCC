import java.util.ArrayList;
import java.util.Scanner;

public class J2014 {

	public static void q4PartyInvitation() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		ArrayList<Integer> church = new ArrayList<Integer>();
		for (int i = 0; i < count; i++) {
			church.add(i + 1);
		}
		
		int round = sc.nextInt();
		for (int i = 0; i < round; i++){
			int skip = sc.nextInt();
			ArrayList<Integer> hotel = new ArrayList<Integer>();
			for (int index = 0; index < church.size(); index ++){
				if ((index + 1) % skip != 0){
					hotel.add(church.get(index));
				}
			}
			church = hotel;
		}
		
		sc.close();
		
		System.out.println(church);
		
	}

}
