package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 * 08-Jan-2025
 */
public class ExcitingBets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			long [] result = findExcitement(a, b);
			System.out.println(result[0] + " " + result[1]);
		}
		sc.close();
	}

	private static long[] findExcitement(long a, long b) {
		if (a == b) {
			return new long [] {0, 0};
		}
		if (a == 0 || b == 0) {
			return new long [] {Math.max(a, b), 0};
		}
		long [] result = new long [2];
		result[0] = Math.abs(a - b);
		result[1] = Math.min(a % result[0], result[0] - a % result[0]);
		return result;
	}

}

/**
𝐺𝐶𝐷(𝑎,𝑏)=𝐺𝐶𝐷(𝑎−𝑏,𝑏)
  if 𝑎>𝑏
  
  
*/