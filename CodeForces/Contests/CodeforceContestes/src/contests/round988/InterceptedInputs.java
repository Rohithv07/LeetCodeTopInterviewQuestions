package contests.round988;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author rohithvazhathody 17-Nov-2024
 */
public class InterceptedInputs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int k = sc.nextInt();
			int[] nums = new int[k];
			for (int i = 0; i < k; i++) {
				nums[i] = sc.nextInt();
			}
			int needed = k - 2;
			Map<Integer, Integer> map = new HashMap<>();
			int row = -1;
			int col = -1;
			for (int num : nums) {
				int div = needed / num;
				int mod = needed % num;
				if (map.containsKey(div) && mod == 0) {
					row = num;
					col = div;
					break;
				} else {
					map.put(num, 1);
				}
			}
			System.out.println(row + " " + col);
		}
		sc.close();
	}

}
