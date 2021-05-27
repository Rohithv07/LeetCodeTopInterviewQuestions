import java.util.*;

public class SifidAndStrangeSubsequece {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int [] nums = new int [n];
			for (int i=0; i<n; i++) {
				nums[i] = sc.nextInt();
			}
			Arrays.sort(nums);
			int limit = n - 1;
			for (int i=0; i<limit; i++) {
				if (nums[i + 1] - nums[i] < nums[limit]) {
					limit -= 1;
					i -= 1;
				}
			}
			System.out.println(limit + 1);
		}
		
	}
}