package problemsolving;

import java.util.Scanner;

public class GCDArrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int k = sc.nextInt();
			if (l == r) {
				if (l == 1) {
					System.out.println("NO");
				}
				else {
					System.out.println("YES");
				}
			}
			else {
				// count of odd numbers in the given range, which is (𝑟−𝑙+1)−(𝑟/2−(𝑙−1)/2
				if ((r - l + 1) - (r/2 - (l - 1) / 2) <= k) {
							System.out.println("YES");
						}
						else {
							System.out.println("NO");
						}
			}
		}
	}
}
