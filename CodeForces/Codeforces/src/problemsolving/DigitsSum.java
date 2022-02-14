package problemsolving;

import java.util.Scanner;

public class DigitsSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			if (n == 1) {
				System.out.println("0");
			}
			else {
				System.out.println((n % 10  == 9 ? n / 10 + 1 : n / 10));
			}
		}
	}
}
