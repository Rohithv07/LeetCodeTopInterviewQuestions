import java.util.*;

// very similar to longest subarray with target sum
// ref : https://youtu.be/lO9R5CaGRPY
public class CountSubarrayWithXorAsK {

	public static int countSubArray(int [] nums, int n, int k) {
		if (nums == null || n == 0) {
			return 0;
		}
		Map<Integer, Integer> xorIndex = new HashMap<>();
		int runningXor = 0;
		int count = 0;
		for (int i=0; i<n; i++) {
			runningXor ^= nums[i];
			if (runningXor == k) {
				count++;
			}
			if (xorIndex.containsKey(runningXor ^ k)) {
				count += xorIndex.get(runningXor ^ k);
			}
			xorIndex.put(runningXor, xorIndex.getOrDefault(runningXor, 0) + 1);
		}
		return count;
	} 


	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		System.out.println(countSubArray(nums, n, k));
	}
}