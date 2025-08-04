package contests;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author rohithvazhathody 05-Aug-2025
 */
public class ValeryAgainstEveryone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(isIntegersExist(nums, n));
		}
		sc.close();
	}

	private static String isIntegersExist(int[] nums, int n) {
		Set<Integer> unique = new HashSet<>();
		for (int num : nums) {
			unique.add(num);
		}
		return unique.size() == n ? "NO" : "YES";
	}

}
