package problemsolving;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class IntegerDiversity {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
				if (set.contains(nums[i])) {
					set.add(-nums[i]);
				}
				set.add(nums[i]);
			}

			System.out.println(set.size());
		}
	}
}
