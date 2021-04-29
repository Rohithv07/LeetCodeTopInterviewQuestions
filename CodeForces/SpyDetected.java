import java.util.*;

public class SpyDetected {

	public static int irregularIndex(int [] nums, int n) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int number : nums) {
			map.put(number, map.getOrDefault(number, 0) + 1);
		}
		int needed = 0;
		for (int key : map.keySet()) {
			if (map.get(key) == 1) {
				needed = key;
				break;
			}
		}
		for (int i=0; i<n; i++) {
			if (nums[i] == needed)
				return i + 1;
		}
		return -1;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int [] nums = new int [n];
			for (int i=0; i<nums.length; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(irregularIndex(nums, n));
		}
	}
}