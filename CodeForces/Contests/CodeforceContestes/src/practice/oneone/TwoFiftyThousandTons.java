package practice.oneone;

import java.util.Scanner;

/**
 * @author rohithvazhathody 14-Sept-2025
 */
public class TwoFiftyThousandTons {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long[] weight = new long[n];
			for (int index = 0; index < n; index++) {
				weight[index] = sc.nextLong();
			}
			long maxWeight = findAbsWeight(weight);
			System.out.println(maxWeight);
		}
		sc.close();
	}

	private static long findAbsWeight(long[] weight) {
		if (weight.length == 1) {
			return 0l;
		}
		int length = weight.length;
		long[] prefixSum = new long[length];
		prefixSum[0] = weight[0];
		for (int index = 1; index < length; index++) {
			prefixSum[index] = prefixSum[index - 1] + (long) weight[index];
		}
		long maxAbs = Long.MIN_VALUE;
		for (int possible = 1; possible <= length; possible++) {
			if (length % possible != 0) {
				continue;
			}
			int start = possible - 1;
			long maxSum = prefixSum[start];
			long minSum = prefixSum[start];
			for (int next = start + possible; next < length; next += possible) {
				maxSum = Math.max(maxSum, prefixSum[next] - prefixSum[next - possible]);
				minSum = Math.min(minSum, prefixSum[next] - prefixSum[next - possible]);
			}
			maxAbs = Math.max(maxAbs, maxSum - minSum);
		}
		return maxAbs;
	}

}
