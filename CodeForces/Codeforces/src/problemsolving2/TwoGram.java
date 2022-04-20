/**
 * 
 */
package problemsolving2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class TwoGram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		System.out.println(findMaxsubstring(s, n));
	}

	private static String findMaxsubstring(String s, int n) {
		if (n == 2) {
			return s;
		}
		String result = "";
		int max = 0;
		Map<String, Integer> count = new HashMap<>();
		for (int i = 0; i < n - 1; i++) {
			String current = s.substring(i, i + 2);
			count.put(current, count.getOrDefault(current, 0) + 1);
		}
		for (String key : count.keySet()) {
			int currentFreq = count.get(key);
			if (currentFreq > max) {
				max = currentFreq;
				result = key;
			}
		}
		return result;
	}
}
