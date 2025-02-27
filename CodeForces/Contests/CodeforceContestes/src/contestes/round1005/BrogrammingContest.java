package contestes.round1005;

import java.util.Scanner;

/**
 * @author rohithvazhathody 16-Feb-2025
 */
public class BrogrammingContest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			System.out.println(findMoves(n, s));
		}
		sc.close();
	}

	private static int findMoves(int n, String s) {
		int moves = 0;
		for (int i = 1; i < n; i++) {
			if (s.charAt(i - 1) != s.charAt(i)) {
				moves++;
			}
		}
		if (s.charAt(0) == '1') {
			moves++;
		}
		return moves;
	}

}
