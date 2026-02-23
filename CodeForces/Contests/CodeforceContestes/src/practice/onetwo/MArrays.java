/**
 * @author rohithvazhathody
 * @date 16 Feb 2026
 * Project: CodeforceContestes
 * File: MArrays.java
 */

package practice.onetwo;

import java.util.Scanner;

/**
 * 
 */
public class MArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			long [] nums = new long [n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextLong();
			}
			long minGroup = findGroup(nums, m);
			System.out.println(minGroup);
		}
		sc.close();
	}

	private static long findGroup(long[] nums, int m) {
		int length = nums.length;
		long [] freq = new long [m];
		for (int index = 0; index < length; index++) {
			freq[(int) (nums[index] % m)] += 1;
		}
		int result = 0;
		for (int index = 0; index < m; index++) {
			long x = freq[index];
			long y = freq[(m - index) % m];
			if (x == 0 && y == 0) {
				continue;
			}
			long currentMin = Math.min(x,  y);
			x -= Math.min(currentMin + 1, x);
			y -= Math.min(currentMin + 1, y);
			result++;
			result += (x + y);
			freq[index] = 0;
			freq[(m - index) % m] = 0;
		}
		return result;
	}

}


/*

m
a1, a2, a3, a4, a5, a6

a1, a2, a3      a4, a5, a6

a1 + a2 % m = 0
a2 + a3 % m = 0


1 1 1 5 2 4 4 8 6 7

8
1 1 1 2 4 4 5 6 7 8

1 1 1 2 4 4 5 6 7 0

1 2 3 5 9 13 18 24 31 39


2 2 8 6 9 4

2 2 4 6 8 9

2 4 8 14 22 31

2 2 4 8
6
9



*/