package practice.oneooo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author rohithvazhathody 20-Feb-2025
 */
public class OlyaAndGameWithArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			long ans = 0, amin = Integer.MAX_VALUE, bmin = Integer.MAX_VALUE;
			while (n-- > 0) {
				int x = sc.nextInt();
				int a[] = new int[x];
				for (int i = 0; i < x; i++)
					a[i] = sc.nextInt();
				Arrays.sort(a);
				ans += a[1];
				amin = Math.min(a[0], amin);
				bmin = Math.min(a[1], bmin);
			}
			System.out.println(ans - bmin + amin);
		}
		sc.close();
	}

	/**
	 * Minimum of all array + sum of second minimum of all array - second minimum of
	 * all array
	 * 
	 * @param matrix
	 * @param n
	 * @return
	 */
	private static long findMinMaxSum(List<List<Integer>> matrix, int n) {
		long smallest = Long.MAX_VALUE;
		long secondSmall = Long.MAX_VALUE;
		long totalSecondSum = 0;
		for (int i = 0; i < n; i++) {
			long currentSecondSmall = Long.MAX_VALUE;
			long currentSmallest = Long.MAX_VALUE;
			for (int j = 0; j < matrix.get(i).size(); j++) {
//				currentSmallest = Math.min(currentSmallest, matrix.get(i).get(j));
//				currentSecondSmall = Math.min(currentSecondSmall, matrix.get(i).get(j));
//				if (matrix.get(i).get(j) < currentSecondSmall) {
//					currentSecondSmall = matrix.get(i).get(j);
//				}
				if (matrix.get(i).get(j) < currentSmallest) {
					currentSecondSmall = currentSmallest;
					currentSmallest = matrix.get(i).get(j);
				} else if (matrix.get(i).get(j) < currentSecondSmall && currentSmallest != matrix.get(i).get(j)) {
					currentSecondSmall = matrix.get(i).get(j);
				}
			}
			// System.out.println(currentSecondSmall);
			totalSecondSum += currentSecondSmall;
			smallest = Math.min(smallest, currentSmallest);
			secondSmall = Math.min(currentSecondSmall, secondSmall);
		}
		return smallest + totalSecondSum - secondSmall;
	}

}
