package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 16-Dec-2024
 */
public class ComparisonString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			System.out.println(findSmallCost(s, n));
		}
		sc.close();
	}

	/**
	 * Longest sequence with equal character + 1
	 * 
	 * @param s
	 * @param n
	 * @return
	 */
	private static int findSmallCost(String s, int n) {
		int increasing = 1;
		int currentRunning = 1;
		for (int i = 1; i < n; i++) {
			char previous = s.charAt(i - 1);
			char current = s.charAt(i);
			if (current != previous) {
				currentRunning = 1;
			} else {
				currentRunning = currentRunning + 1;
			}
			increasing = Math.max(increasing, currentRunning);
		}
		return increasing + 1;
	}

}
