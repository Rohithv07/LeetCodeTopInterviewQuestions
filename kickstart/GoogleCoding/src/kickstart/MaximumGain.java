/**
 * 
 */
package kickstart;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class MaximumGain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int m = sc.nextInt();
			long[] nums1 = new long[m];
			for (int i = 0; i < m; i++) {
				nums1[i] = sc.nextLong();
			}
			int n = sc.nextInt();
			long[] nums2 = new long[n];
			for (int i = 0; i < n; i++) {
				nums2[i] = sc.nextLong();
			}
			int k = sc.nextInt();
			System.out.println("Case #" + t + ": " + findMaxGain(m, nums1, n, nums2, k));
		}
	}

	private static long findMaxGain(int m, long[] nums1, int n, long[] nums2, int k) {
		long [] prefix1 = new long [m];
		long [] suffix1 = new long [m];
		long [] prefix2 = new long [n];
		long [] suffix2 = new long [n];
		prefix1[0] = nums1[0];
		prefix2[0] = nums2[0];
		for (int i = 1; i < m; i++) {
			prefix1[i] = prefix1[i - 1] + nums1[i];
		}
		for (int i = 1; i < n; i++) {
			prefix2[i] = prefix2[i - 1] + nums2[i];
		}
		suffix1[m - 1] = nums1[m - 1];
		for (int i = m - 2; i >= 0; i--) {
			suffix1[i] = suffix1[i + 1] + nums1[i];
		}
		suffix2[n - 1] = nums2[m - 1];
		for (int i = n - 2; i >= 0; i--) {
			suffix2[i] = suffix2[i + 1] + nums2[i];
		}
		
		
		return 0;
	}

	

}
