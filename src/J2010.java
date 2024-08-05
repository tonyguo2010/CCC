import java.util.Scanner;

// https://www.cemc.uwaterloo.ca/contests/computing/past_ccc_contests/2010/stage1/juniorEn.pdf
public class J2010 {

	public static void q1WhatIsN() {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		System.out.println(input / 2 + 1);
		sc.close();
	}

	public static void q2UpAndDown() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int s = sc.nextInt();
		sc.close();

		int nikkyTotalSteps = s;
		int nikkyDistance = 0;
		
		boolean forward = true;
		
		while(true){
			if (nikkyTotalSteps <= 0){
				break;
			}
			if (forward){
				nikkyDistance += Math.min(a, nikkyTotalSteps);
				nikkyTotalSteps -= Math.min(a, nikkyTotalSteps);
			} else {
				nikkyDistance -= Math.min(b, nikkyTotalSteps);
				nikkyTotalSteps -= Math.min(b, nikkyTotalSteps);
			}
			forward = !forward;
		}
		
		int byronTotalSteps = s;
		int byronDistance = 0;

		forward = true;
		while(true){
			if (byronTotalSteps <= 0){
				break;
			}
			
			if (forward){
				byronDistance += Math.min(c, byronTotalSteps);
				byronTotalSteps -= Math.min(c, byronTotalSteps);
			} else {
				byronDistance -= Math.min(d, byronTotalSteps);
				byronTotalSteps -= Math.min(d, byronTotalSteps);
			}
			forward = !forward;
		}
		
		if (nikkyDistance > byronDistance)
			System.out.println("Nikky");
		else if (nikkyDistance < byronDistance)
			System.out.println("Byron");
		else
			System.out.println("Tie");
	}

}
