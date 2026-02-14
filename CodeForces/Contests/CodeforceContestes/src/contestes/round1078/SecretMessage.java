/**
 * @author rohithvazhathody
 * @date 8 Feb 2026
 * Project: CodeforceContestes
 * File: SecretMessage.java
 */

package contestes.round1078;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class SecretMessage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			String[] strips = new String[k];
			for (int index = 0; index < k; index++) {
				strips[index] = sc.next();
			}
			String minInfo = findMinInfo(n, k, strips);
			System.out.println(minInfo);
		}
		sc.close();
	}

	private static String findMinInfo(int n, int k, String[] strips) {
		List<Integer> divisors = findDivisors(n);
		Collections.sort(divisors);
		StringBuilder result = new StringBuilder();
		for (Integer divisor : divisors) {
			if (found(divisor, n, k, strips, result)) {
				break;
			}
		}
		return result.toString();
	}

	private static boolean found(Integer d, int n, int k, String[] strips, StringBuilder result) {
		StringBuilder pattern = new StringBuilder();
		for (int i = 0; i < d; i++) {
			int possible = (1 << 26) - 1;
			for (int pos = i; pos < n; pos += d) {
				int currentPosMask = 0;
				for (int s = 0; s < k; s++) {
					currentPosMask |= (1 << (strips[s].charAt(pos) - 'a'));
				}
				possible &= currentPosMask;
			}
			if (possible == 0) {
				return false;
			}
			for (int bit = 0; bit < 26; bit++) {
				if ((possible & (1 << bit)) != 0) {
					pattern.append((char) ('a' + bit));
					break;
				}
			}
		}
		result.setLength(0);
		for (int i = 0; i < n / d; i++) {
			result.append(pattern);
		}
		return true;
	}

	private static List<Integer> findDivisors(int n) {
		List<Integer> result = new ArrayList<>();
		for (int num = 1; num * num <= n; num++) {
			if (n % num == 0) {
				result.add(num);
				if (num * num != n) {
					result.add(n / num);
				}
			}

		}
		return result;
	}

}
