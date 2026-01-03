import java.util.ArrayList;
import java.util.HashMap;
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

	static HashMap<String, Integer> vars = new HashMap<>();

	public static void q3Punchy() {
		Scanner sc = new Scanner(System.in);
		while(true){
			String line = sc.nextLine();
			String[] units = line.split(" ");
			if (units[0].equals("7"))
				break;
			switch (units[0]){
			case "1":
				vars.put(units[1], Integer.valueOf(units[2]));
				break;
			case "2":
				System.out.println(vars.get(units[1]));
				break;
			case "3":
				vars.put(units[1], vars.get(units[1]) + vars.get(units[2]));
				break;
			case "4":
				vars.put(units[1], vars.get(units[1]) * vars.get(units[2]));
				break;
			case "5":
				vars.put(units[1], vars.get(units[1]) - vars.get(units[2]));
				break;
			case "6":
				vars.put(units[1], vars.get(units[1]) / vars.get(units[2]));
				break;
				}
		}
		sc.close();
	}

	public static void q4GlobalWarning() {
		Scanner sc = new Scanner(System.in);
		while(true){
			String line = sc.nextLine();
			if (line.equals("0"))
				break;

			// parse line
			String[] units = line.split(" ");
			ArrayList<Integer> nums = new ArrayList<>();
			for (String unit : units){
				nums.add(Integer.valueOf(unit));
			}
			// calc difference
			ArrayList<Integer> diff = new ArrayList<>();
			for (int i = 0; i < nums.size() - 1; i++){
				diff.add(nums.get(i + 1) - nums.get(i));
			}
			
			int record = Integer.MAX_VALUE;
			for (int starter = 0; starter < diff.size(); starter++){
				if (diff.lastIndexOf(diff.get(starter)) != starter){
					for (int ender = starter + 1; ender < diff.size(); ender ++){
						if (diff.get(starter) == diff.get(ender)){
							boolean matched = true;
							for (int pacer = 0; pacer < Math.min(diff.size() - ender, ender - starter); pacer ++){
								if (diff.get(starter + pacer) != diff.get(ender + pacer)){
									matched = false;
									break;
								}
							}
							if (matched == true){
								record = Math.min(record, ender - starter);
							}
						}
					}
				}
			}
			
			if (record == Integer.MAX_VALUE)
				record = 1;
			System.out.println(record);
		}
		sc.close();
	}

	public static void q5KnightHop() {
		Scanner sc = new Scanner(System.in);
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		sc.close();
		
		int steps = 0;
		while (true){
			// already there
			if (x1 == x2 && y1 == y2)
				break;
			// final 1 step
			if (Math.abs(x1 - x2) == 2
					&& Math.abs(y1 - y2) == 1){
					steps += 1;
					break;
				}
			if (Math.abs(x1 - x2) == 1
					&& Math.abs(y1 - y2) == 2){
					steps += 1;
					break;
				}
			// final 2 steps
			if (Math.abs(x1 - x2) == 1
					&& Math.abs(y1 - y2) == 1){
					steps += 2;
					break;
				}
			if (Math.abs(x1 - x2) == 0
					&& Math.abs(y1 - y2) == 2){
					steps += 2;
					break;
				}
			if (Math.abs(x1 - x2) == 2
					&& Math.abs(y1 - y2) == 0){
					steps += 2;
					break;
				}
			// final 3 steps
			if (Math.abs(x1 - x2) == 1
					&& Math.abs(y1 - y2) == 0){
					steps += 3;
					break;
				}
			if (Math.abs(x1 - x2) == 0
					&& Math.abs(y1 - y2) == 1){
					steps += 3;
					break;
				}
			// final 4 steps
			if (Math.abs(x1 - x2) == 2
					&& Math.abs(y1 - y2) == 2){
					steps += 4;
					break;
				}

			if ( Math.abs(x1 - x2) >= 3
			  || Math.abs(y1 - y2) >= 3){
				int deltaX = Math.abs(x1 - x2);
				int deltaY = Math.abs(y1 - y2);
				if (deltaX > deltaY){
					if (x1 < x2)
						x1 += 2;
					else
						x1 -= 2;
					
					if (y1 < y2)
						y1 += 1;
					else
						y1 -= 1;
				} else {
					if (x1 < x2)
						x1 += 1;
					else
						x1 -= 1;
					
					if (y1 < y2)
						y1 += 2;
					else
						y1 -= 2;
				}
				steps ++;
			}
		}
		
		System.out.println(steps);
	}

}
