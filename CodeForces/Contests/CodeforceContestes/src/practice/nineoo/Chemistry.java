package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 14-Dec-2024
 */
public class Chemistry {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			String s = sc.next();
			System.out.println(isPossible(s, n, k));
		}
		sc.close();
	}

	private static String isPossible(String s, int n, int k) {
		if (n - k == 1) {
			return "YES";
		}
		int[] count = new int[26];
		for (char ch : s.toCharArray()) {
			count[ch - 'a']++;
		}
		int oddOccur = 0;
		// number of odd occurances should not be > k + 1
		for (int i = 0; i < 26; i++) {
			if (count[i] > 0 && count[i] % 2 == 1) {
				oddOccur++;
			}
		}
		return oddOccur > k + 1 ? "NO" : "YES";
	}

}
