import java.util.*;

public class ReviewSite {

	public static int countUpvote(int [] nums, int n) {
		int count = 0;
		for (int number : nums) {
			if (number != 2)
				count += 1;
		}
		return count;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int [] viewers = new int [n];
			for (int i=0; i<n; i++) {
				viewers[i] = sc.nextInt();
			}
			System.out.println(countUpvote(viewers, n));
		}
	}
}