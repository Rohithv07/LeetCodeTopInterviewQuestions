package contests.round995;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody 22-Dec-2024
 */
public class PreparingForOlympiad {

	/**
	 * @param args
	 */
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
			System.out.println(findMax(a, b, n));
		}
		sc.close();
	}

	private static int findMax(int[] a, int[] b, int n) {
		// TODO Auto-generated method stub
		int max = 0;
		int i = 0;
		int j = 1;
		while (i < n && j < n) {
			if (a[i] > b[j]) {
				max += a[i] - b[j];
				i++;
				j++;
			}
			else if (a[i] == b[j]) {
				i++;
				j++;
			}
			else if (a[i] < b[j]) {
				i++;j++;
			}
		}
		while (i < n) {
			max += a[i];
			i++;
		}
		return max;
	}

}

/*
 * 8 2 5 6 2 6
8 2 7 4 3 4

2 2 5 6 6 8
2 3 4 4 7 8
 */
