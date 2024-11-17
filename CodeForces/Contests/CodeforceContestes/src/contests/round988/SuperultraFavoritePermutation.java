package contests.round988;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author rohithvazhathody 17-Nov-2024
 */
public class SuperultraFavoritePermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			if (n <= 3 || n == 4) {
				System.out.println("-1");
			} else {
				if (n == 5) {
					System.out.println("1 3 5 4 2");
				} else {
					List<Integer> result = new ArrayList<>();
					List<Integer> even = new ArrayList<>();
					List<Integer> odd = new ArrayList<>();
					for (int i = 1; i <= n; i++) {
						if (i % 2 == 0) {
							even.add(i);
						} else {
							odd.add(i);
						}
					}
					swap(even, 2, even.size() - 1);
					swap(odd, 0, 1);
					result.addAll(even);
					result.addAll(odd);
					for (int num : result) {
						System.out.print(num + " ");
					}
					System.out.println();
				}
			}
		}
		sc.close();

	}

	private static void swap(List<Integer> list, int i, int j) {
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	private static boolean findPrime(int n) {
		boolean[] isPrime = new boolean[n + 1];
		for (int i = 2; i * i <= n; i++) {
			if (!isPrime[i]) {
				for (int j = i; j * i <= n; j++) {
					isPrime[i * j] = true;
				}
			}
		}
		return isPrime[n];
	}

}

/*
 * 6 1 2 3 4 5 6
 * 
 * 1 3 5 4 2
 * 
 * 4 8 6
 * 
 * 1+3, 2+4, 5+3
 * 
 * 1 5 7 3 6 4 2 8
 * 
 * 1 3 2 4 5 3
 * 
 * 1 2 3 4 5 6 7 8 1 3 2 4 5 7 6 8
 * 
 * 
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
 * 
 * 1 3 2 4 3 5 7
 * 
 * 1 3 5 7 9 2 4 6 8 10
 * 
 * 
 * 
 */
