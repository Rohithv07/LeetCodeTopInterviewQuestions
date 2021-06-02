import java.util.*;

public class SequencePairWeight {

	public static long findTheWeight(int [] nums, int n) {
		if (n <= 1) {
			return 0;
		}
		Map<Integer, Long> map = new HashMap<>();
		for (int i=0; i<n; i++) {
			map.put(nums[i], 0l);
		}
		long answer = 0;
		for (int i=0; i<n; i++) {
			int currentNumber = nums[i];
			answer += map.get(currentNumber) * (n - i);
			Long value = map.get(currentNumber);
			value += i + 1;
			map.put(currentNumber, value);
		}
		return answer;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int [] nums = new int [n];
			for (int i=0; i<n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(findTheWeight(nums, n));
		}
	}
}