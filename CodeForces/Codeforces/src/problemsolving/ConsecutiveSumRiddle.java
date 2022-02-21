package problemsolving;

import java.util.Scanner;

public class ConsecutiveSumRiddle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			System.out.println(-n + 1 + " " + n);
		}
	}
}
