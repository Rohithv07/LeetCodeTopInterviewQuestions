package contests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author rohithvazhathody 05-Jul-2025
 */
public class RoofConstruction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			List<Integer> result = findMinCost(n);
			for (int num : result) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static List<Integer> findMinCost(int n) {
		List<Integer> result = new ArrayList<>();
		int mostSignificant = findMSB(n - 1);
		int val = (int)(Math.pow(2, mostSignificant));
		for (int index = val - 1; index >= 0; index--) {
			result.add(index);
		}
		for (int index = val; index < n; index++) {
			result.add(index);
		}
		return result;
	}

	private static int findMSB(int num) {
		int msb = 0;
		while (num > 1) {
			num >>= 1;
			msb++;
		}
		return msb;
	}

}
