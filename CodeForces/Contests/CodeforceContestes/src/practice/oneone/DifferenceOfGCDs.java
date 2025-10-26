package practice.oneone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author rohithvazhathody 22-Oct-2025
 */
public class DifferenceOfGCDs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int l = sc.nextInt();
			int r = sc.nextInt();
			List<Integer> result = findResult(n, l, r);
			if (result == null || result.size() != n) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
				for (Integer val : result) {
					System.out.print(val + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}

	private static List<Integer> findResult(int n, int l, int r) {
		List<Integer> result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			int ceil = ((l + i - 1) / i) * i;
			if (ceil > r) {
				return null;
			}
			result.add(ceil);
		}
		return result;
	}

}
