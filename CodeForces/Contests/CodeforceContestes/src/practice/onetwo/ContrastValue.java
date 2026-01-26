/**
 * @author rohithvazhathody
 * @date 7 Jan 2026
 * Project: CodeforceContestes
 * File: ContrastValue.java
 */

package practice.onetwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class ContrastValue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			List<Integer> nums = new ArrayList<>();
			for (int index = 0; index < n; index++) {
				int num = sc.nextInt();
				nums.add(num);
			}
			// we need to remove consecutive duplicate
			List<Integer> uniqueList = new ArrayList<>();
			if (n > 0) {
				uniqueList.add(nums.get(0));
				for (int i = 1; i < n; i++) {
					// Only add if it is different from the previous element
					if (!nums.get(i).equals(nums.get(i - 1))) {
						uniqueList.add(nums.get(i));
					}
				}
			}
			int minimumLength = findMinimumLength(uniqueList);
			System.out.println(minimumLength);
		}
		sc.close();
	}

	private static int findMinimumLength(List<Integer> nums) {
		int length = nums.size();
		if (length == 1) {
			return 1;
		}
		int result = length;
		for (int index = 0; index + 2 < length; index++) {
			int current = nums.get(index);
			int next = nums.get(index + 1);
			int nextNext = nums.get(index + 2);
			if (current < next && next < nextNext) {
				result--;
			}
			if (current > next && next > nextNext) {
				result--;
			}
		}
		return result;
	}

}
