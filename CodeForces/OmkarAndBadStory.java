import java.util.*;

public class OmkarAndBadStory {
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
			if (nums[0] < 0) {
				System.out.println("NO");
			}
			else {
				System.out.println("YES");
				System.out.println("101");
				for (int i=0; i<=100; i++) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
		}
	}
}