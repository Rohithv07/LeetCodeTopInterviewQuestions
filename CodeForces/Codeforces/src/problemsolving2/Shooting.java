/**
 * 
 */
package problemsolving2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class Shooting {
	
	static class Pair {
		int value;
		int index;

		public Pair(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Pair[] nums = new Pair[n];
		for (int i = 0; i < n; i++) {
			int value = sc.nextInt();
			nums[i] = new Pair(value, i);
		}
		Arrays.sort(nums, (p1, p2) -> Integer.compare(p2.value, p1.value));
		int[] result = new int[n];
		result[0] = nums[0].index + 1;
		int total = 1;
		int can = 1;
		for (int i = 1; i < n; i++) {
			total = total + nums[i].value * can + 1;
			result[i] = nums[i].index + 1;
			can++;
		}
		System.out.println(total);
		for (int num : result) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}