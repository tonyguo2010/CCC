import java.util.Scanner;

public class J2015 {

	public static void j3Rovars() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		
		for (int index = 0; index < input.length(); index++){
			char letter = input.charAt(index);
			
			if ("aeiou".indexOf(letter) != -1){ // if vowel, keep it
				System.out.print(letter);
			} else { // consonant
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
			
			char currentVowel = "aeiou".charAt(index);
			
			int currentDistance = Math.abs(letter - currentVowel);
			
			if (currentDistance < record ){
				record = currentDistance;
				result = currentVowel;
			}
		}
		return result;
	}

}
