/**
 * @author rohithvazhathody
 * @date 4 Apr 2026
 * Project: CodeforceContestes
 * File: The6767Problem.java
 */

package contests.round1090;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */
public class The6767Problem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int [] nums = new int [7];
			for (int index = 0; index < 7; index++) {
				nums[index] = sc.nextInt();
			}
			Arrays.sort(nums);
			int sum = 0;
			for (int index = 0; index < 7 - 1; index++) {
				sum += (-1 * nums[index]);
			}
			sum += nums[6];
			System.out.println(sum);
		}
		sc.close();
	}

}
