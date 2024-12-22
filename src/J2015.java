import java.util.Scanner;

public class J2015 {

	public static void j3Rovars() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		
		for (int index = 0; index < input.length(); index++){
			char letter = input.charAt(index);
			int state = getStateByLetter(letter);
			
			if (state == 0){ // if vowel, keep it
				System.out.print(letter);
			} else if (state == 1) { // consonant
				System.out.print(letter);
				System.out.print(closestVowel(letter));
				System.out.print(nextConsonant(letter));
			}
		}
		System.out.println();
	}

	private static char nextConsonant(char letter) {
		char result = letter;
		while (true){
			result ++;
			if ("aeiou".indexOf(result) == -1){ // not a vowel? stop now!
				break;
			}
		}
		if (result > 'z'){ // in case it is over 'z', move back
			result --;
		}
		return result;
	}

	private static char closestVowel(char letter) {
		char result = ' ';
		int record = 27; // totally only 26 letters 
		for (int index = 0; index < "aeiou".length(); index++){
			if (Math.abs(letter - "aeiou".charAt(index)) < record ){
				record = Math.abs(letter - "aeiou".charAt(index));
				result = "aeiou".charAt(index);
			}
		}
		return result;
	}

	private static int getStateByLetter(char letter) {
		if ("aeiou".indexOf(letter) != -1){
			return 0;
		}
		return 1;
	}

}
