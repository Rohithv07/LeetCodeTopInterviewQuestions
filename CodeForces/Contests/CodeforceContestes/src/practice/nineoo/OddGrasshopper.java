package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 25-Dec-2024
 */
public class OddGrasshopper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long current = sc.nextLong();
			long jumps = sc.nextLong();
			finalPos(current, jumps);
		}
		sc.close();
	}

	private static void finalPos(long current, long jumps) {

		long mod = jumps % 4;
		if (current == 0) {
			if (mod == 0) {
				System.out.println(0);
			} else if (mod == 1) {
				System.out.println(-jumps);
			} else if (mod == 2) {
				System.out.println(1);
			} else {
				System.out.println(jumps + 1);
			}
		} else {
			if (current % 2 == 0) {
				if (mod == 0) {
					System.out.println(0 + current);
				} else if (mod == 1) {
					System.out.println(-jumps + current);
				} else if (mod == 2) {
					System.out.println(1 + current);
				} else {
					System.out.println(1 + jumps + current);
				}
			} else {
				if (mod == 0) {
					System.out.println(current);
				} else if (mod == 1) {
					System.out.println(jumps + current);
				} else if (mod == 2) {
					System.out.println(current - 1);
				} else {
					System.out.println(current - jumps - 1);
				}
			}
		}

	}

}

/*
 * 0 + jums
 * 
 * 
 * 10 -> -1 -1 -> 12 11 + 13 -> 24 24 - 14 -> 10 10 - 15 -> -5 -5 + 16 -> 11 11
 * + 17 -> 28 28 - 18 -> 10 10 - 19 -> -9 -9 + 20 + 11
 * 
 * 
 * 4 5 4 - 5 -> -1 -1 + 6 -> 5 5 + 7 -> 12 12 - 8 -> 4 4 - 9 -> -5
 * 
 * 3 3
 * 
 * 3 + 4 -> 7 7 + 5 -> 12 12 - 6 -> 6
 * 
 * 
 * 7 7
 * 
 * 7 + 8 -> 15 15 + 9 -> 24 24 - 10 -> 14 14 - 11 -> 3 3 + 12 -> 15 15 + 13 ->
 * 28 28 - 14 -> 14
 * 
 * 5 5 5 + 6 -> 11 11 + 7 -> 18 18 - 8 -> 10 10 - 9 -> 1 1 + 10 -> 11
 * 
 * 
 */
