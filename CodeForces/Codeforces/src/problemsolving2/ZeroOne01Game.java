package problemsolving2;

import java.util.Scanner;

public class ZeroOne01Game {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			System.out.println(isAliceWin(s) ? "DA" : "NET");
		}
	}

	private static boolean isAliceWin(String s) {
		if (s.length() == 1) {
			return false;
		}
		if (s.length() == 2) {
			return true;
		}
		int countOfOne = 0;
		int countOfZero = 0;
		int move = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '0') {
				countOfZero++;
			} else {
				countOfOne++;
			}
		}
		// simplest version
		int min = Math.min(countOfZero, countOfOne);
		return min % 2 != 0;
		// this part is also correct
//		while (countOfOne > 0 && countOfZero > 0) {
//			move++;
//			countOfOne--;
//			countOfZero--;
//		}
//		return move % 2 != 0;
	}
}
