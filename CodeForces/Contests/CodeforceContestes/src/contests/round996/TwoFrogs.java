package contests.round996;

import java.util.Scanner;

/**
 * @author rohithvazhathody 12-Jan-2025
 */
public class TwoFrogs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int alice = sc.nextInt();
			int bob = sc.nextInt();
			System.out.println(canAlicewin(n, alice, bob));
		}
		sc.close();
	}

	private static String canAlicewin(int n, int alice, int bob) {
		int diff = Math.abs(alice - bob);
		if (diff % 2 == 0) {
			return "YES";
		}
		return "NO";
	}

}

/*
 * 5 2 5 1 4 2 3 1 2
 * 
 * 
 * 6
 * 2 6
 * 3 5
 * 4 6
 */