package contestes.round992;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 * 08-Dec-2024
 */
public class PaintAString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			System.out.println(numberOfOp(n));
		}
		sc.close();
	}

	private static int numberOfOp(int n) {
		int answer = 1;
		int current = 1;
		while (true) {
			if (current >= n) {
				break;
			}
			current = current * 2 + 2;
			answer++;
		}
		return answer;
	}

}

/*
 * 3
 * 0 0 0 0
 * 1 0 0 1
 * 
 * 1 1 1 1 1 0 0 0 0 1  0  0  1
 * 1 2 3 4 5 6 7 8 9 10 11 12 13
 * 
 * 1 0 0 0 1 0 0 1 1 1
 * 1 2 3 4 5 6 7 8 9 10
 * 
 * 1 1 1 1 1 1 1 1 1 1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
 * 
 * 
 */
