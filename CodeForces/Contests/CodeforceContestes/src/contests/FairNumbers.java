package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody 06-Aug-2025
 */
public class FairNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long num = sc.nextLong();
			System.out.println(findMinNumber(num));
		}
		sc.close();
	}

	private static long findMinNumber(long num) {
		if (num == 1) {
			return num;
		}
  while (true) {
   if (isDivisible(num)) {
    return num;
   }
   num++;
  }
	}

	private static boolean isDivisible(long num) {
		long store = num;
		while (num > 0) {
			long digit = num % 10;
			if (digit != 0 && store % digit != 0) {
				return false;
			}
			num /= 10;
		}
		return true;
	}

}
