/**
 * 
 */
package problemsolving2;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class MochaAndRedAndBlue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			System.out.println(findThePuzzle(s, n));
		}
	}

	public static String findThePuzzle(String s, int n) {
		if (n == 1 && s.equals("?")) {
			return "B";
		}
		if (n == 1) {
			return s;
		}
		int countOfAlphabets = 0;
		char[] array = s.toCharArray();
		for (int i = 0; i < n; i++) {
			char current = array[i];
			if (current != '?')
				countOfAlphabets += 1;
		}
		if (countOfAlphabets == 0) {
			array[0] = 'R';
		}
		for (int i = 1; i < n; i++) {
			if (array[i] == '?' && array[i - 1] != '?') {
				array[i] = (char) (array[i - 1] ^ ('B' ^ 'R'));
			}
		}
		for (int i = n - 2; i >= 0; i--) {
			if (array[i] == '?' && array[i + 1] != '?') {
				array[i] = (char) (array[i + 1] ^ ('B' ^ 'R'));
			}
		}
		return new String(array);
	}
}
