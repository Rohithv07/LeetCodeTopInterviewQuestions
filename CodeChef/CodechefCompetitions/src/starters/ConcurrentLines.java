/**
 * 
 */
package starters;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class ConcurrentLines {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextLong();
		long y = sc.nextLong();
		System.out.println(findNumberOfLines(x, y));
	}

	private static long findNumberOfLines(long x, long y) {
		if (x == 1 && y == 2) {
			return 2;
		}
		Map<Long, Long> track = new HashMap<>();
		for (int i = 2; i <= Math.sqrt(x); i++) {
			if (x % i == 0) {
				while (x % i == 0) {
					track.put((long) i, track.getOrDefault((long) i, 0l) + 1);
					x /= i;
				}
			}
		}
		for (int i = 2; i <= Math.sqrt(y); i++) {
			if (y % i == 0) {
				while (y % i == 0) {
					track.put((long) i, track.getOrDefault((long) i, 0l) + 1);
					y /= i;
				}
			}
		}

		return findRemainingFactors(x, y, track);
	}

	private static long findRemainingFactors(long x, long y, Map<Long, Long> track) {
		long straightLineCount = 1;
		for (int i = 1; i <= (int) (1e6); i++) {
			straightLineCount *= (track.getOrDefault((long) i, (long) 0) + 1);
		}
		if (x == y) {
			if (x > 1) {
				straightLineCount *= 3;
			}
		} else {
			if (x > 1) {
				straightLineCount *= 2;
			}
			if (y > 1) {
				straightLineCount *= 2;
			}
		}
		return straightLineCount;
	}
}
