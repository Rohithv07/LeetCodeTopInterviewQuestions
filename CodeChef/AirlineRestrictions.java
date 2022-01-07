package SeptemberLongChallenge;

import java.util.Scanner;

// Change to Main
public class AirlineRestrictions {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			int e = sc.nextInt();
			if (a + b <= d && c <= e) {
				System.out.println("Yes");
			} else if (a + c <= d && b <= e) {
				System.out.println("YeS");
			} else if (b + c <= d && a <= e) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
		sc.close();
	}
}
