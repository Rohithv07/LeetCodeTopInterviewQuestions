/**
 * 
 */
package codejam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author rohithvazhathody
 *
 */
public class LetterBlocks {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int n = sc.nextInt();
			String[] s = new String[n];
			for (int i = 0; i < n; i++) {
				s[i] = sc.next();
			}
			System.out.println("Case #" + t + ": " + findTower(s, n));
		}
	}

	private static String findTower(String[] s, int n) {
//		Arrays.sort(s);
////		for (String ss : s) {
////			System.out.print(ss + " ");
////		}
//		boolean [] marked = new boolean [26];
//		Set<Character> inBetween = new HashSet<>();
//		StringBuilder result = new StringBuilder();
//		Map<String, String> map = new HashMap<>();
//		for (int i = 0; i < n; i++) {
//			String current = s[i];
//			Set<Character> visited = new HashSet<>();
//			char previous = '1';
//			int counter = 0;
//			for (char ch : current.toCharArray()) {
//				if (!visited.contains(ch)) {
//					visited.add(ch);
//					previous = ch;
//				}
//				if (visited.contains(ch) && previous == ch) {
//					continue;
//				}
//				if (visited.contains(ch) && previous != ch) {
//					return "IMPOSSIBLE";
//				}
//				if (counter != 0 && counter != current.length() - 1) {
//					inBetween.add(ch);
//				}
//				counter++;
//
//			}
//			for (int j = 0; j < n; j++) {
//				if (i != j) {
//					String next = s[j];
//					for (char ch : next.toCharArray()) {
//						if (inBetween.contains(ch)) {
//							return "IMPOSSIBLE";
//						}
//					}
//
//				}
//			}
//		}
//		boolean [] added = new boolean [n];
//		for (int i = 0; i < n; i++) {
//			String current = s[i];
//			char last = current.charAt(current.length() - 1);
//			for (int j = 0; j < n; j++) {
//				if (i != j) {
//					String next = s[j];
//					char first = next.charAt(0);
//					if (first == last) {
//						if (marked[first - 'A']) {
//							return "IMPOSSIBLE";
//						}
//						if (added[i] && added[j]) {
//							return "IMPOSSIBLE";
//						}
//						map.put(current, next);
//						marked[first - 'A'] = true;
//						added[i] = true;
//						added[j] = true;
//					}
//							
//				}
//			}
//		}
//		for (int i = 0; i < n; i++) {
//			if (!added[i]) {
//				result.append(s[i]);
//			}
//		}
//		
		StringBuilder result = new StringBuilder();
		boolean [] marked = new boolean [26];
		Set<Character> inBetween = new HashSet<>();
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String current = s[i];
			Set<Character> visited = new HashSet<>();
			char previous = '1';
			int counter = 0;
			for (char ch : current.toCharArray()) {
				if (!visited.contains(ch)) {
					visited.add(ch);
					previous = ch;
				}
				if (visited.contains(ch) && previous == ch) {
					continue;
				}
				if (visited.contains(ch) && previous != ch) {
					return "IMPOSSIBLE";
				}
				if (counter != 0 && counter != current.length() - 1) {
					inBetween.add(ch);
				}
				counter++;

			}
			for (int j = 0; j < n; j++) {
				if (i != j) {
					String next = s[j];
					for (char ch : next.toCharArray()) {
						if (inBetween.contains(ch)) {
							return "IMPOSSIBLE";
						}
					}

				}
			}
		}
		boolean [] added = new boolean [n];
		for (int i = 0; i < n; i++) {
			String current = s[i];
			char first = current.charAt(0);
			for (int j = 0; j < n; j++) {
				if (i != j) {
					String next = s[j];
					char last = next.charAt(next.length() - 1);
					if (first == last) {
						if (marked[first - 'A']) {
							return "IMPOSSIBLE";
						}
						map.put(current, next);
						marked[first - 'A'] = true;
						added[i] = true;
						added[j] = true;
					}
							
				}
			}
		}
		return null;
	}
}
