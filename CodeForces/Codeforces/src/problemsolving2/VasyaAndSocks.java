/**
 * 
 */
package problemsolving2;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class VasyaAndSocks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int test = sc.nextInt();
//		while (test-- > 0) {
//		}
		int n = sc.nextInt();
		int m = sc.nextInt();
		int ans = n + ((n - 1) / (m - 1));
		System.out.println(ans);
	}
}
