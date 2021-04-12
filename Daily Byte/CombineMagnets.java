/*
You are given an integer array, magnets where each value in the array represents the size of a particular magnet. You goal is to connect all the magnets together to form a single magnet. Every time you connect two magnets, a and b together, you pay a cost of a + b. Return the minimum cost to connect all the magnets together.

Ex: Given the following magnets…

magnets = [1, 2, 3], return 9 (add 1 and 2 together for a cost of 3, add 3 and 3 together for a total cost of 6, summing these costs together we get 9).
Ex: Given the following magnets…

magnets = [5, 2, 4, 1], return 22.
*/


import java.util.*;

public class CombineMagnets {

	public static int minimumCostToCombineAllMagnet(int [] magnet, int n) {
		Arrays.sort(magnet);
		int minimumSum = 0;
		for (int i = 1; i < n; i++) {
			magnet[i] = magnet[i - 1] + magnet[i];
		}
		for (int i = 1; i < n; i++) {
			minimumSum += magnet[i];
		}
		return minimumSum;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] magnet = new int [n];
		for (int i=0; i<n; i++) {
			magnet[i] = sc.nextInt();
		}
		System.out.println(minimumCostToCombineAllMagnet(magnet, n));
	}
}
