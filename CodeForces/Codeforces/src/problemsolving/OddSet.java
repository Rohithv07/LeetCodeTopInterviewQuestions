package problemsolving;

import java.util.Scanner;

public class OddSet {

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int [] nums = new int [2 * n];
			int evenCount = 0;
			int oddCount = 0;
			for (int i = 0; i < 2 *n; i++) {
				nums[i] = sc.nextInt();
				if (nums[i] % 2 == 0) {
					evenCount += 1;
				}
				else {
					oddCount += 1;
				}
			}
			if (evenCount == oddCount) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
	
}
