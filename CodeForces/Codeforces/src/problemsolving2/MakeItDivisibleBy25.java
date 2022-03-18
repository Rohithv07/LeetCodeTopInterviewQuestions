/**
 * 
 */
package problemsolving2;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class MakeItDivisibleBy25 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			int moves = findMoves(s);
			System.out.println(moves);
		}
	}

	private static int findMoves(String s) {
		int moves1 = Integer.MAX_VALUE;
		int moves2 = Integer.MAX_VALUE;
		int length = s.length();
		String[] possibilities = new String[] { "00", "25", "50", "75" };
		String lastTwoChar = s.substring(length - 2);
		for (String possible : possibilities) {
			if (possible.equals(lastTwoChar)) {
				return 0;
			}
		}
		int positionOf5 = -1;
		int positionOf0 = -1;
		int remainingIndex1 = -1;
		int remainingIndex2 = -1;
		for (int i = length - 1; i >= 0; i--) {
			if (s.charAt(i) == '5' && positionOf5 == -1) {
				positionOf5 = i;
			} else if (s.charAt(i) == '0' && positionOf0 == -1) {
				positionOf0 = i;
			}
		}
		if (positionOf5 != -1) {
			for (int i = positionOf5 - 1; i >= 0; i--) {
				if (s.charAt(i) == '2' || s.charAt(i) == '7') {
					remainingIndex1 = i;
					break;
				}
			}
			moves1 = positionOf5 == length - 1 ? positionOf5 - remainingIndex1 - 1
					: (length - 1 - positionOf5) + (positionOf5 - remainingIndex1 - 1);
		}
		if (positionOf0 != -1) {
			for (int i = positionOf0 - 1; i >= 0; i--) {
				if (s.charAt(i) == '0' || s.charAt(i) == '5') {
					remainingIndex2 = i;
					break;
				}
			}
			moves2 = positionOf0 == length - 1 ? positionOf0 - remainingIndex2 - 1
					: (length - 1 - positionOf0) + (positionOf0 - remainingIndex2 - 1);
		}
		return Math.min(moves1, moves2);
	}
}
