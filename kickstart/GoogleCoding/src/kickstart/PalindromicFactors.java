/**
 * 
 */
package kickstart;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class PalindromicFactors {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			long n = sc.nextLong();
			System.out.println("Case #" + t + ": " + findCount(n));
		}
	}

	private static long findCount(long n) {
		long count = 0;
		// System.out.println(isPalindrome(11));
		for (long i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				// if i is a factor, then the other factor will be n / i
				long fact1 = i;
				if (isPalindrome(fact1)) {
					count++;
				}
				if (i * i < n) {
					long fact2 = n / i;
					if (isPalindrome(fact2)) {
						count++;
					}
				}
			}
//			if (isPalindrome(i) && n % i == 0) {
//				//System.out.println(i);
//				count++;
//			}
		}
		return count;
	}

	private static boolean isPalindrome(long num) {
		long temp = num;
		long sum = 0;
		while (num > 0) {
			long rem = num % 10;
			sum = (sum * 10) + rem;
			num /= 10;
		}
		return temp == sum;
	}
}
