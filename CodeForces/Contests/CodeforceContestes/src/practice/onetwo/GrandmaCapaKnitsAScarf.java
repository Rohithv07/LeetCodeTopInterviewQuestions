/**
 * @author rohithvazhathody
 * @date 14 Feb 2026
 * Project: CodeforceContestes
 * File: GrandmaCapaKnitsAScarf.java
 */

package practice.onetwo;

import java.util.Scanner;

/**
 * 
 */
public class GrandmaCapaKnitsAScarf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			int minDeletion = findMinDeletion(s);
			System.out.println(minDeletion);
		}
		sc.close();
	}

	private static int findMinDeletion(String s) {
		if (s == null || s.length() <= 1) {
			return 0;
		}
		if (isPalindrome(s)) {
			return 0;
		}
		int length = s.length();
		int minDeletion = Integer.MAX_VALUE;
		for (char ch = 'a'; ch <= 'z'; ch++) {
			int deleteCurrent = 0;
			boolean possible = true;
			int left = 0;
			int right = length - 1;
			while (left < right) {
				if (left < right && s.charAt(left) == s.charAt(right)) {
					left++;
					right--;
					continue;
				}
				if (s.charAt(left) == ch) {
					deleteCurrent++;
					left++;
				} else if (s.charAt(right) == ch) {
					deleteCurrent++;
					right--;
				} else {
					possible = false;
					break;
				}
			}
			if (!possible) {
				deleteCurrent = Integer.MAX_VALUE;
			}
			minDeletion = Math.min(minDeletion, deleteCurrent);
		}
		return minDeletion == Integer.MAX_VALUE ? -1 : minDeletion;
	}

	private static boolean isPalindrome(String s) {
		int length = s.length();
		int left = 0;
		int right = length - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}

/*
 * 
 * rprarlap
 * 
 * r = 3 p = 2 a = 2 l = 1
 * 
 * 
 * khyyhhyhky
 * 
 * k = 2 h = 4 y = 4
 * 
 * 
 * k h h h h k
 * 
 * khyhhyhk
 *
 * rprarlap
 * 
 * 
 * 
 * 
 */
