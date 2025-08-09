package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody 08-Aug-2025
 */
public class JohnnyAndAncientComputer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long num1 = sc.nextLong();
			long num2 = sc.nextLong();
			int minOperations = findMinimumOperation(num1, num2);
			System.out.println(minOperations);
		}
		sc.close();
	}

	private static int findMinimumOperation(long num1, long num2) {
		if (num1 == num2) {
			return 0;
		}
		long firstNum = num1;
		long secondNum = num2;
		while (firstNum % 2 == 0) {
			firstNum /= 2;
		}
		while (secondNum % 2 == 0) {
			secondNum /= 2;
		}
		if (firstNum != secondNum) {
			return -1;
		}
		num1 /= firstNum;
		num2 /= secondNum;
		int power1 = (int) (Math.log(num1) / Math.log(2));
		int power2 = (int) (Math.log(num2) / Math.log(2));
		int operation = findCeil(Math.abs(power2 - power1), 3);
		return operation;
	}

	private static int findCeil(int a, int b) {
		return (a + b - 1) / (b);
	}

}
