/**
 * @author rohithvazhathody
 * @date 16 Feb 2026
 * Project: CodeforceContestes
 * File: PrinzessinderVerurteilung.java
 */

package practice.onetwo;

import java.util.Scanner;

/**
 * 
 */
public class PrinzessinderVerurteilung {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			String mex = findMex(s);
			System.out.println(mex);
		}
		sc.close();
	}

	private static String findMex(String s) {
		if (s.length() == 1) {
			if (s.charAt(0) != 'a') {
				return "a";
			}
			else {
				return "b";
			}
		}
		StringBuilder result = new StringBuilder();
		int length = s.length();
		int [] count = new int [26];
		for (char ch : s.toCharArray()) {
			count[ch - 'a']++;
		}
		for (int index = 0; index < 26; index++) {
			if (count[index] == 0) {
				char resultChar = (char)('a' + index);
				result.append(resultChar);
				return result.toString();
			}
		}
		for (char ch1 = 'a'; ch1 <= 'z'; ch1++) {
			for (char ch2 = 'a'; ch2 <= 'z'; ch2++) {
				StringBuilder current = new StringBuilder();
				current.append(ch1).append(ch2);
				if (!s.contains(current.toString())) {
					return current.toString();
				}
			}
		}
		for (char ch1 = 'a'; ch1 <= 'z'; ch1++) {
			for (char ch2 = 'a'; ch2 <= 'z'; ch2++) {
				for (char ch3 = 'a'; ch3 <= 'z'; ch3++) {
					StringBuilder current = new StringBuilder();
					current.append(ch1).append(ch2).append(ch3);
					if (!s.contains(current.toString())) {
						return current.toString();
					}
				}
			}
		}
		return null;
	}

}
