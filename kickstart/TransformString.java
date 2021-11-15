/**
 * 
 */
package GoogleKickstart;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class TransformString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			String s1 = sc.next();
			String s2 = sc.next();
			System.out.println("Case #" + t + ": " + minOperation(s1, s2));
		}
		sc.close();
	}

	private static long minOperation(String s1, String s2) {
		if (s1.equals(s2)) {
			return 0;
		}
		int[] left = new int[26];
		Arrays.fill(left, Integer.MAX_VALUE);
		long operation = 0;
		for (char ch : s1.toCharArray()) {
			int index = ch - 'a';
			int distance = 26;
			for (char cch : s2.toCharArray()) {
				int current = cch - 'a';
				int distance1 = Math.abs(index - current + 26) % 26;
				int distance2 = Math.abs(current - index + 26) % 26;
				distance = Math.min(distance, Math.min(distance2, distance1));
			}
			operation += distance;
		}
		return operation;
	}

}
