/**
 * 
 */
package problemsolving2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class ArrayStabilization {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			arr[i] = a;
		}
		Arrays.sort(arr);
		System.out.println(Math.min(arr[n - 2] - arr[0], arr[n - 1] - arr[1]));
	}
}
