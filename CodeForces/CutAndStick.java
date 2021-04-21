import java.util.*;

public class CutAndStick {

	private static int count = 0;

	public static int findTheCount(int [] nums, int n, int l, int r, int limit) {
		if (r == l)
			return 0;
		if (r - l == n - 1)
			return 1;
		Map<Integer, Integer> map = new HashMap<>();
		for (int number : nums) {
			map.put(number, map.getOrDefault(number, 0) + 1);	
		}
		int occurance = map.get(nums[l - 1]);
		if (occurance > limit) {
			count += 1;
			findTheCount(nums, n, l + 1, r, limit);
		}
		else {
			findTheCount(nums, n, l + 1, r, limit);
		}
		return count;
		// for (int i=l-1; i<r; i++) {
		// 	int occurance = map.get(nums[i]);
		// 	if (occurance > limit) {
		// 		count += 1;

		// 	}
		// }
	}

	public static int findLength(int l, int r, int [] nums) {
		int counts = 0;
		for (int i=l-1; i<r; i++) {
			counts++;
		}
		return counts;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		while (q-- > 0) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int length = findLength(l, r, nums);
			int limit = length / 2;
			System.out.println(findTheCount(nums, n, l, r, limit));
		}
	}
}