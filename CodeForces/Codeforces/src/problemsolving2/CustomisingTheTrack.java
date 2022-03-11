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
public class CustomisingTheTrack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long[] nums = new long[n];
			long sum = 0;
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextLong();
				sum += nums[i];
			}
			long k = sum % n;
			System.out.println(k * (n - k));

		}
	}
}
