import java.util.Arrays;
import java.util.Scanner;

public class J2024 {

	public static void J4TroublesomeKeys() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String output = sc.nextLine();
		sc.close();
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int[] inputCount = new int[26];
		int[] outputCount = new int[26];

		// count input keys
		for (int n = 0; n < input.length(); n++){
			int index = alphabet.indexOf(input.charAt(n));
			inputCount[index] ++;
		}
		
		// count output keys
		for (int n = 0; n < output.length(); n++){
			int index = alphabet.indexOf(output.charAt(n));
			outputCount[index] ++;
		}
		
		// remove the same keys
		for (int n = 0; n < alphabet.length(); n++){
			if (inputCount[n] == outputCount[n]){
				inputCount[n] = 0;
				outputCount[n] = 0;
			}
		}
		
		// there almost 2 keys in input count, try one, if there is a same count in output, it is trouble some
		char[] inputKeys = new char[2];
		inputKeys[1] = '-';
		int count = 0;
		for (int n = 0; n < alphabet.length(); n++){
			if (inputCount[n] != 0){
				inputKeys[count] = alphabet.charAt(n);
//				System.out.println("" + alphabet.charAt(n) + inputCount[n]);
				count ++;
			}
		}
		
		// there is only 1 key left in output keys
		char outputKey = 0;
		for (int n = 0; n < alphabet.length(); n++){
			if (outputCount[n] != 0){
				outputKey = alphabet.charAt(n);
				break;
			}
		}
		
//		System.out.println("" + inputKeys[0] + inputKeys[1] + outputKey);
		char silly = 0;
		char wrong = 0;
		char quiet = 0;
		if (alphabet.indexOf(inputKeys[0]) >=0 && outputCount[alphabet.indexOf(outputKey)] == inputCount[alphabet.indexOf(inputKeys[0])]){
			silly = inputKeys[0];
			wrong = outputKey;
			quiet = inputKeys[1];
		} else if (alphabet.indexOf(inputKeys[1]) >=0 && outputCount[alphabet.indexOf(outputKey)] == inputCount[alphabet.indexOf(inputKeys[1])]){
			silly = inputKeys[1];
			wrong = outputKey;
			quiet = inputKeys[0];
		}

		System.out.println("" + silly + " " + wrong);
		System.out.println("" + quiet);
	}
	/*
4
70
62
58
73 
*/
	public static void q4BronzeCount() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();	// 4
		int[] scores = new int[count];
		for (int i = 0; i < count; i++){
			scores[i] = sc.nextInt();  // 70 62 58 73 
		}
		sc.close();
		
		Arrays.sort(scores); // 58 62 70 73 
		
		int record = scores[scores.length - 1];  // record = scores[3] = 73
		int life = 2;
		for (int i = scores.length - 1; i >= 0; i--){  // i = 3, 2, 1, 0
			if (scores[i] < record){  // scores[3] vs record? (73==73)  // scores[2] vs record? (70 < 73)  // scores[1] vs record? (62 < 70)
				life --; // 1 // 0
				record = scores[i];  // record = 70  // record = 62
			}
			if (life == 0){
				break;
			}
		}
		
		int copper = 0;
		for (int i = 0; i < count; i++){
			if (scores[i] == record){  // record = 62
				copper ++;
			}
		}
		
		System.out.println(record + " " + copper);
	}

}
