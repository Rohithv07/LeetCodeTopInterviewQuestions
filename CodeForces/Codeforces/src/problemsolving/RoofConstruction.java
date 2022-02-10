package problemsolving;

import java.util.Scanner;

public class RoofConstruction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			if (n == 1) {
				System.out.println("0 1");
			} else {
				int[] permutation = findPermutation(n);
				for (int number : permutation) {
					System.out.print(number + " ");
				}
				System.out.println();
			}
		}
	}

	private static int[] findPermutation(int n) {
		boolean isZeroAdded = false;
		int[] permutation = new int[n];
		int index = 0;
		for (Integer i = n - 1; i > 0; i--) {
			permutation[index++] = i;
			if (!isZeroAdded && Integer.bitCount(i) == 1) {
				permutation[index++] = 0;
				isZeroAdded = true;
			}
		}
		return permutation;
	}
}
