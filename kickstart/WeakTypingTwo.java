package HackerCupFirstRound;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WeakTypingTwo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			long n = sc.nextLong();
			String s = sc.next();
			System.out.println("Case #" + t + ": " + switchPopsicle(s));
		}
		sc.close();
	}

	private static long switchPopsicle(String s) {
		if (s.length() == 1) {
			return 0;
		}
		long mod = (long) (1e9 + 7);
//		Set<Character> set = new HashSet<>();
//		for (char ch : s.toCharArray()) {
//			set.add(ch);
//		}
//		if (set.size() == 1) {
//			return 0;
//		}
		long totalResult = 0;
		for (int i = 0; i < s.length(); i++) {
			long countLeft = 0;
			long countRight = 0;
			boolean left = false;
			boolean right = false;
			for (int j = i; j < s.length(); j++) {
				char current = s.charAt(j);
				if (!right && current == 'O') {
					right = true;
					countRight++;
				}
				if (right && current == 'X') {
					right = false;
					countRight++;
				}
				if (!left && current == 'X') {
					left = true;
					countLeft++;
				}
				if (left && current == 'O') {
					left = false;
					countLeft++;
				}
				totalResult += Math.min(countRight, countLeft);
				totalResult = totalResult % mod;
			}
		}
		return (long)(totalResult % mod);
	}

	private static long possibleSwitchWithRightHand(String s) {
		boolean rightHand = true;
		long switchHand = 0;
		for (char ch : s.toCharArray()) {
			if (ch == 'O' && rightHand == false) {
				switchHand++;
				rightHand = true;
			} else if (ch == 'O' && rightHand == true) {
				continue;
			} else if (ch == 'X' && rightHand == true) {
				switchHand++;
				rightHand = false;
			}
		}
		return switchHand;
	}

	private static long possibleSwitchWithLeftHand(String s) {
		boolean leftHand = true;
		long switchHand = 0;
		for (char ch : s.toCharArray()) {
			if (ch == 'X' && leftHand == false) {
				switchHand++;
				leftHand = true;
			} else if (ch == 'X' && leftHand == true) {
				continue;
			} else if (ch == 'O' && leftHand == true) {
				switchHand++;
				leftHand = false;
			}
		}
		return switchHand;
	}
}
