import java.util.Scanner;

public class J2022 {

	public static void j3HarpTuning() {
		// AFB+8HC-4

		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		sc.close();

		int state = 0;
		for (int i = 0; i < line.length(); i++) {
			char input = line.charAt(i);
			char next = ' ';
			if (i + 1 < line.length()) {
				next = line.charAt(i + 1);
			}

			state = translate(input, next);
			if (state == 1) { // for letters
				System.out.print(input);
			}
			if (state == 2) { // for +
				System.out.print(" tighten ");
			}
			if (state == 3) { // for -
				System.out.print(" loosen ");
			}
			if (state == 4) { // num
				System.out.print(input);
			}
			if (state == 5) { // num ending, a new line
				System.out.print(input);
				System.out.println();
			}
		}
	}

	private static int translate(char current, char next) {
		if ('A' <= current && current <= 'Z') {
			return 1;
		}
		if ('+' == current) {
			return 2;
		}
		if ('-' == current) {
			return 3;
		}
		if (
		// is a digit
		('0' <= current && current <= '9')
				// and next char is not a digit
				&& (next < '0' || next > '9')) {
			return 5;
		}
		if ('0' <= current && current <= '9') {
			return 4;
		}
		return -1;
	}
}
