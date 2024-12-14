package practice.nineoo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author rohithvazhathody 11-Dec-2024
 */
public class Forked {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int xk = sc.nextInt();
			int yk = sc.nextInt();
			int xq = sc.nextInt();
			int yq = sc.nextInt();
			Set<String> attack = new HashSet<>();
			int totalCount = 0;
			int[][] moves = new int[][] { { a, b }, { a, -b }, { -a, b }, { -a, -b }, { b, a }, { -b, a }, { b, -a },
					{ -b, -a } };
			for (int[] move : moves) {
				attack.add((xk + move[0]) + "$" + (yk + move[1]));
			}
			for (int[] move : moves) {
				String s = (xq + move[0]) + "$" + (yq + move[1]);
				if (attack.contains(s)) {
					attack.remove(s);
					totalCount++;
				}
			}

			System.out.println(totalCount);

			// xk - a, yk - b
			// xk + a, yk - b
			// xk + a, vk + b
			// xk -a yk + b
			// xk
		}
		sc.close();
	}

}
