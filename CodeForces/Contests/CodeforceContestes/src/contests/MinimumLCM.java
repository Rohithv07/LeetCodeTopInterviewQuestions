package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody 14-Jun-2025
 */
public class MinimumLCM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			long[] answer = findMinimumLCMPair(n);
			System.out.println(answer[0] + " " + answer[1]);
		}
		sc.close();
	}

	private static long[] findMinimumLCMPair(long n) {
		long firstAnswer = 1;
		for (long i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				firstAnswer = n / i;
				break;
			}
		}
		long secondAnswer = n - firstAnswer;
		return new long[] { firstAnswer, secondAnswer };

	}
}

/*
 * 
 * 1 6 -> 6 2 5 -> 10 3 4 - 12 4 3 - 12 5 2 - 10 6 1 - 6
 * 
 * 
 */
