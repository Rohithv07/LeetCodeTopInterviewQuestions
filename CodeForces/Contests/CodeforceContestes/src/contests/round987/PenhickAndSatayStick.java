package contests.round987;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author rohithvazhathody 15-Nov-2024
 */
public class PenhickAndSatayStick {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int length = sc.nextInt();
			int[] nums = new int[length];
			int[] p = new int[length];
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < length; i++) {
				nums[i] = sc.nextInt();
				p[i] = nums[i];
				map.put(p[i], i);
			}
			Arrays.sort(nums);
			boolean isPossible = true;
			for (int i = 0; i < length; i++) {
				if (nums[i] != p[i]) {
					if (Math.abs(map.get(nums[i]) - i) > 1) {
						isPossible = false;
						break;
					}
				}
			}
//			for (int i = 0; i + 1 < length; i++) {
//				if (Math.abs(p[i] - p[i + 1]) == 1) {
//					swap(p, i, i + 1);
//				}
//			}
//			for (int i = 0; i < length; i++) {
//				if (nums[i] != p[i]) {
//					isPossible = false;
//					break;
//				}
//			}
			System.out.println(isPossible ? "YES" : "NO");
		}
		sc.close();
	}

	private static void swap(int[] p, int i, int j) {
		// TODO Auto-generated method stub
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;

	}

}
