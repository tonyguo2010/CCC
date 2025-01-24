import java.util.Scanner;

public class J2011 {

	public static void J3SumacSequences() {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		sc.close();
		// check every step
		while (true){
			System.out.println(n1);
			int next = n1 - n2;
			n1 = n2;
			     n2 = next;
			     
		    if (next < 0){
		    	System.out.println(n1);
		    	break;
		    }
		}
	}

}
