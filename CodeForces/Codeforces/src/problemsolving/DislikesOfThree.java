package problemsolving;

import java.util.Scanner;

public class DislikesOfThree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int k = sc.nextInt();
			int i = 1;
			// the max is 1666 as given in the test case
			for (; i <= 1666; i++) {
				if (k != 0) {
					if (i % 3 != 0 && i % 10 != 3) {
						k -= 1;
					}
				} else {
					break;
				}
			}
			System.out.println(i - 1);
		}
	}
}
