package practice.oneone;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author rohithvazhathody 25-Oct-2025
 */
public class APerfectlyBalancedString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			System.out.println(isBalanced(s));
		}
		sc.close();
	}

	private static String isBalanced(String s) {
		int length = s.length();
		Map<Character, Character> freqMap = new HashMap<>();
		int breakPoint;
		for (breakPoint = 0; breakPoint < length; breakPoint++) {
			if (!freqMap.containsKey(s.charAt(breakPoint))) {
				freqMap.put(s.charAt(breakPoint), s.charAt(breakPoint));
			} else {
				break;
			}
		}
		for (int index = breakPoint; index < length; index++) {
			if (freqMap.get(s.charAt(index)) != freqMap.get(s.charAt(index - breakPoint))) {
				return "no";
			}
		}

		return "YES";
	}

}
