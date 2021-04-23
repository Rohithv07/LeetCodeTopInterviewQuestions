import java.util.*;

public class ArrayAndPeaks {

	public static String getTheArray(int n, int k) {
		if ((n % 2 != 0 && k > n / 2) || (n % 2 == 0 && k > (n - 1) / 2)) {
			return String.valueOf(-1);
		}
		StringBuilder sb = new StringBuilder();
		for (int i=1, j=1; i<=n - k; i++, j++) {
			sb.append(i).append(" ");
			if (j <= k) {
				sb.append(n - i + 1).append(" ");
			}
		}
		return sb.toString();
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			System.out.println(getTheArray(n, k));
		}
	}
}