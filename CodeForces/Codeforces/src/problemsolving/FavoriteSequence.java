/**
 * 
 */
package problemsolving;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class FavoriteSequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int [] nums = new int [n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			int [] result = new int [n];
			int first = 0;
			int last = n - 1;
			int index = 0;
			while (first < last) {
				result[index++] = nums[first++];
				result[index++] = nums[last--];
			}
			if (first == last) {
				result[index] = nums[first];
			}
			for (int number : result) {
				System.out.print(number + " ");
			}
			System.out.println();
			
		}
	}
}
