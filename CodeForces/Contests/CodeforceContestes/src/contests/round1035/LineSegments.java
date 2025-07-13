package contests.round1035;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody 05-Jul-2025
 */
public class LineSegments {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long px = sc.nextLong();
			long py = sc.nextLong();
			long qx = sc.nextLong();
			long qy = sc.nextLong();
			int[] nums = new int[n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextInt();
			}
			System.out.println(findIfPossible(n, px, py, qx, qy, nums));
		}
		sc.close();
	}

	private static String findIfPossible(int n, long px, long py, long qx, long qy, int[] nums) {
		long totalSum = Arrays.stream(nums).asLongStream().sum();
		long dx = px - qx;
		long dy = py - qy;
		long distSquared = dx * dx + dy * dy;
		long low = 0, high = totalSum;
		while (low <= high) {
			long mid = (low + high) / 2;
			if (mid * mid == distSquared) {
				long distance = mid;
				return (totalSum >= distance && (totalSum - distance) % 2 == 0) ? "YES" : "NO";
			} else if (mid * mid < distSquared) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		double distance = Math.sqrt(distSquared);
		if (distance <= totalSum && ((long) Math.floor((totalSum - distance + 1e-8)) % 2 == 0)) {
			return "YES";
		}

		return "NO";
	}

}
