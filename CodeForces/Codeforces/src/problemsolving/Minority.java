package problemsolving;

import java.util.Scanner;

public class Minority {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			System.out.println(removedCount(s));
		}
	}

	public static int removedCount(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int countOfZero = 0;
		int countOfOne = 0;
		int length = s.length();
		for (char ch : s.toCharArray()) {
			if (ch == '1') {
				countOfOne += 1;
			} else {
				countOfZero += 1;
			}
		}
		if (countOfOne == length || countOfZero == length) {
			return 0;
		}
		if (countOfOne == countOfZero) {
			if (s.charAt(length - 1) == '1') {
				countOfOne -= 1;
			}
			else {
				countOfZero -= 1;
			}
			return Math.min(countOfOne, countOfZero);
		}
		return Math.min(countOfOne, countOfZero);
	}
}
