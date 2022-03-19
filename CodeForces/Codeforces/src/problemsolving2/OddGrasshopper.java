package problemsolving2;

import java.util.Scanner;

public class OddGrasshopper {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long x = sc.nextLong();
			long n = sc.nextLong();
			long mod = n % 4;
			if (x == 0) {
				if (mod == 0) {
					System.out.println(0);
				} else if (mod == 1) {
					System.out.println(-n);
				} else if (mod == 2) {
					System.out.println(1);
				} else if (mod == 3) {
					System.out.println(n + 1);
				}
			} else {
				if (x % 2 == 0) {
					if (mod == 0) {
						System.out.println(0 + x);
					} else if (mod == 1) {
						System.out.println(-n + x);
					} else if (mod == 2) {
						System.out.println(1 + x);
					} else if (mod == 3) {
						System.out.println(n + 1 + x);
					}
				} else {
					if (mod == 0) {
						System.out.println(x - 0);
					} else if (mod == 1) {
						System.out.println(x + n);
					} else if (mod == 2) {
						System.out.println(x - 1);
					} else if (mod == 3) {
						System.out.println(x - n - 1);
					}
				}
			}
		}

	}
}
