package LongChallenge;

import java.util.Scanner;

/**
 * 
 * @author rohithvazhathody
 *
 */
public class MissingNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			int d = sc.nextInt();
			int[] a = new int[2];
			solve(x, y, z, d, a);
			if (a[0] == -1 && a[1] == -1) {
				solve(x, z, y, d, a);
			}
			if (a[0] == -1 && a[1] == -1) {
				solve(x, d, y, z, a);
			}
			if (a[0] == -1 && a[1] == -1) {
				solve(y, z, x, d, a);
			}
			if (a[0] == -1 && a[1] == -1) {
				solve(y, d, x, z, a);
			}
			if (a[0] == -1 && a[1] == -1) {
				solve(z, d, x, y, a);
			}
			System.out.println(a[0] + " " + a[1]);
		}
	}

	private static void solve(int x, int y, int z, int d, int[] a) {
		if ((x + y) % 2 == 0) {
			int max = (int) 1e4;
			int t1 = (x + y) / 2;
			int t2 = Math.abs(x - y) / 2;
			if ((t1 <= 0 || t2 > max) || (t2 <= 0 || t1 > max)) {
				a[0] = -1;
				a[1] = -1;
				return;
			}
			if ((z == t1 * t2 && d == t1 / t2) || (d == t1 * t2 && z == t1 / t2)) {
				a[0] = t1;
				a[1] = t2;
			} else {
				a[0] = -1;
				a[1] = -1;
			}
		}
		else {
			a[0] = -1;
			a[1] = -1;
		}
	}

}
