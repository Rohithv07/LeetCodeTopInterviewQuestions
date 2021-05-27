import java.util.*;

public class EshagLovesBigArrays {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int [] nums = new int [n];
			for (int i=0; i<n; i++)
				nums[i] = sc.nextInt();
			int min = (Arrays.stream(nums).min().getAsInt());
			int count = 0;
			for (int i=0; i<n; i++) {
				if (nums[i] == min) {
					count += 1;
				}
			}
			System.out.println(n - count);
		}
	}
}