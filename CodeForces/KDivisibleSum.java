import java.util.*;

public class KDivisibleSum {

	public static int findMinMax(int n, int k) {
		if (n % k == 0)
			return 1;
		if (n > k) {
			return 2;
		}
		return (k / n) + (k % n == 0 ? 0 : 1);
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			System.out.println(findMinMax(n, k));
		}
	}
}