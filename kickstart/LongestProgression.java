import java.util.*;

public class LongestProgression {

	public static int findLength(int [] nums, int n) {
		if (n == 2)
			return 2;
		int [] diff = new int [n - 1];
		for (int i=0; i<n-1; i++) {
			diff[i] = nums[i + 1] - nums[i];
		}
		int answer = helper(diff);
		int [] reverse = new int [n - 1];
		int index = 0;
		for (int i=diff.length - 1; i >= 0; i--) {
			reverse[index++] = diff[i];
		}
		answer = Math.max(answer, helper(reverse));
		return answer;
	}

	public static int helper(int [] nums) {
		int n = nums.length;
		int currentAnswer = 0;
		for (int i=0, j=0; i<n; i=j) {
			while (j < n && nums[i] == nums[j])
				j += 1;
			currentAnswer = Math.max(currentAnswer, j - i + 1);
			if (j < n) 
				currentAnswer = Math.max(currentAnswer, j - i + 2);
			if (j < n - 1 && nums[j] + nums[j + 1] == 2 * nums[i]) {
				int last = j + 2;
				while (last < n && nums[last] == nums[i])
					last += 1;
				currentAnswer = Math.max(currentAnswer, last - i + 1);
			}
		}
		return currentAnswer;
	}

	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t=1; t<=test; t++) {
			int n = sc.nextInt();
			int [] nums = new int [n];
			for (int i=0; i<n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println("Case #" + t + ": " + findLength(nums, n));
		}
	}
}