package problemsolving;

import java.util.Scanner;

public class MinMaxSwap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] a = new int[n];
			int[] b = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				b[i] = sc.nextInt();
			}
			System.out.println(findMinOfMax(a, b, n));
		}
	}

	private static long findMinOfMax(int[] a, int[] b, int n) {
		for (int i = 0; i < n; i++) {
			if (a[i] > b[i]) {
				swap(a, b, i);
			}
		}
		return findMax(a) * findMax(b);
	}

	private static int findMax(int[] a) {
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		return max;
	}

	private static void swap(int[] a, int[] b, int i) {
		int temp = a[i];
		a[i] = b[i];
		b[i] = temp;
	}

}
