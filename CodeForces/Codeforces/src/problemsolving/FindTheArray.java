
package problemsolving;

/**
 * @author rohithvazhathody
 *
 */
import java.util.*;

public class FindTheArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int sum = sc.nextInt();
			System.out.println(findLengthOfBeautifulArray(sum));
		}
	}

	public static int findLengthOfBeautifulArray(int sum) {
		// https://codeforces.com/blog/entry/92864
		int i = 1;
		while (i * i < sum) {
			i += 1;
		}
		return i;
	}
}
