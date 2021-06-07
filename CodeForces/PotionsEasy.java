import java.util.*;

public class PotionsEasy {

	public static int countThePotions(long [] nums) {
		PriorityQueue<Long> pq = new PriorityQueue<>(nums.length);
		long sum = 0;
		for (long number : nums) {
			sum += number;
			pq.offer(number);
			while (sum < 0) {
				sum -= pq.poll();
			}
		}
		return pq.size();
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			long[] nums = new long [n];
			for (int i=0; i<n; i++) {
				nums[i] = sc.nextLong();
			}
			System.out.println(countThePotions(nums));
	}
}