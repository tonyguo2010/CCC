import java.util.Scanner;

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

}
