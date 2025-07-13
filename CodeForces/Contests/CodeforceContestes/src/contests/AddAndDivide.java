package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody 13-Jul-2025
 */
public class AddAndDivide {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int minimumOperation = findMinOperation(a, b);
			System.out.println(minimumOperation);
		}
		sc.close();
	}

	private static int findMinOperation(int a, int b) {
		if (a == b) {
			return 2;
		}
		if (a < b) {
			return 1;
		}
		int operations = Integer.MAX_VALUE;
		for (int next = 0; next <= 31; next++) {
			long newA = a;
			long newB = b + next;
			if (newB == 1) {
				continue;
			}
			int currentOperation = next;
			while (newA > 0) {
				newA /= newB;
				currentOperation++;
			}
			operations = Math.min(currentOperation, operations);
		}
		return operations;
	}

}
