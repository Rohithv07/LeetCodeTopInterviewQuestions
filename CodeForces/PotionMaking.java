import java.util.*;

public class PotionMaking {

	public static int findTheResult(int k) {
		return 100 / gcd(100, k);
	}

	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int k = sc.nextInt();
			System.out.println(findTheResult(k));
		}
	}
}