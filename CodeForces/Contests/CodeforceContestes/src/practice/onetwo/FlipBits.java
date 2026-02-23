/**
 * @author rohithvazhathody
 * @date 16 Feb 2026
 * Project: CodeforceContestes
 * File: FlipBits.java
 */

package practice.onetwo;

import java.util.Scanner;

/**
 * 
 */
public class FlipBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s1 = sc.next();
			String s2 = sc.next();
			String canTransform = findCanTransform(s1, s2);
			System.out.println(canTransform);
		}
		sc.close();
	}

	private static String findCanTransform(String s1, String s2) {
		int n = s1.length();
		int count0 = 0;
		int count1 = 0;

		for (int i = 0; i < n; i++) {
			if (s1.charAt(i) == '0')
				count0++;
			else
				count1++;
			boolean currentMatch = (s1.charAt(i) == s2.charAt(i));
			if (i < n - 1) {
				boolean nextMatch = (s1.charAt(i + 1) == s2.charAt(i + 1));

				if (currentMatch != nextMatch && count0 != count1) {
					return "NO";
				}
			} else {
				if (!currentMatch && count0 != count1) {
					return "NO";
				}
			}
		}
		return "YES";
	}

}

/*
 * 
 * 
 * 
 * 0111010000 0100101100
 * 
 * 1 1 1 1 2 2 3 4 5 6 - 0 0 1 2 3 3 4 4 4 4 4 - 1
 * 
 * 
 * 1 1 2 3 3 4 4 4 5 6 - 0 0 1 1 1 2 2 3 4 4 4 - 1
 * 
 * 
 * 
 * 
 */
