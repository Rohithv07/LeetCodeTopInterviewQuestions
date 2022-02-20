package problemsolving;

import java.util.Scanner;

public class BinaryDecimal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			long answer = 0;
			while (n > 0) {
				long remainder = n % 10;
				answer = Math.max(answer, remainder);
				n /= 10;
			}
			System.out.println(answer);
		}
	}
}
