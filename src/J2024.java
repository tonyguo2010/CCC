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

}
