/**
 * 
 */
package problemsolving2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class ThreeIndices {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			List<Integer> result = findIndices(nums, n);
			if (result == null || result.size() == 0) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
				for (int num : result) {
					System.out.print(num + " ");
				}
				System.out.println();
			}
		}
	}

	private static List<Integer> findIndices(int[] nums, int n) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i + 2 < n; i++) {
			int num1 = nums[i];
			int num2 = nums[i + 1];
			int num3 = nums[i + 2];
			if (num1 < num2 && num2 > num3) {
				result.add(i + 1);
				result.add(i + 2);
				result.add(i + 3);
				break;
			}
		}
		return result;
	}
}
