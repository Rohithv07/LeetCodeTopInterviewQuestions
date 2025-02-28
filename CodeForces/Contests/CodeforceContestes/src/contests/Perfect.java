package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody 28-Feb-2025
 */
public class Perfect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = findPerfect(n);
//			for (int val : result) {
//				System.out.print(val + " ");
//			}
			System.out.println(s);
		}
		sc.close();
	}

	private static String findPerfect(int n) {
		StringBuilder sb = new StringBuilder();
		int[] result = new int[n];
		if (n == 1) {
			return "-1";
		}
		long totalSum = (long)((long)n * ((long)n + 1)) / 2;
		if (isPerfect(totalSum)) {
			return "-1";
		}
		for (int i = 0; i < n; i++) {
			result[i] = i + 1;
		}
		long prefix = 0;
		for (int i = 0; i < n; i++) {
			if (isPerfect(result[i] + prefix)) {
				swap(result, i, i + 1);

			}
			prefix += result[i];
		}
		for (int i = 0; i < n; i++) {
			sb.append(result[i]).append(" ");
		}
		return sb.toString();
	}

	private static void swap(int[] result, int i, int j) {
		int temp = result[i];
		result[i] = result[j];
		result[j] = temp;
	}

	private static boolean isPerfect(long n) {
		long sqrt = (long) Math.sqrt(n);
		return sqrt * sqrt == n;
	}

}
