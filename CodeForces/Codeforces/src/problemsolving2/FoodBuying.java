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
public class FoodBuying {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int s = sc.nextInt();
			int power = (int) (1e9);
			long answer = 0;
			while (s > 0) {
				while (s < power) {
					power /= 10;
				}
				answer += power;
				s -= power - power / 10;
			}
			System.out.println(answer);
		}
	}
}
