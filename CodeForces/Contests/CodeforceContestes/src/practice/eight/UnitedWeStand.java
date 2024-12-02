package practice.eight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author rohithvazhathody 02-Dec-2024
 */
public class UnitedWeStand {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			Arrays.sort(nums);
			if (nums[0] == nums[n - 1]) {
				System.out.println("-1");
			} else {
				int index = 1;
				int small = nums[0];
				List<Integer> num1 = new ArrayList<>();
				List<Integer> num2 = new ArrayList<>();
				num1.add(small);
				while (index < n && small == nums[index]) {
					num1.add(small);
					index++;
				}
				for (int i = index; i < n; i++) {
					num2.add(nums[i]);
				}
				System.out.println(num1.size() + " " + num2.size());
				for (int num : num1) {
					System.out.print(num + " ");
				}
				System.out.println();
				for (int num : num2) {
					System.out.print(num + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}

}
