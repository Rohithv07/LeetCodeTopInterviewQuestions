import java.util.*;

public class FairPlay {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int [] nums = new int [4];
			nums[0] = sc.nextInt();
			nums[1] = sc.nextInt();
			nums[2] = sc.nextInt();
			nums[3] = sc.nextInt();
			int winner1 = Math.max(nums[0], nums[1]);
			int winner2 = Math.max(nums[2], nums[3]);
			Arrays.sort(nums);
			int firstMax = nums[3];
			int secondMax = nums[2];
			if ((winner1 == firstMax && winner2 == secondMax) || (winner1 == secondMax && winner2 == firstMax))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}