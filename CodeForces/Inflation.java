import java.util.*;

public class Inflation {

	public static long minTotalSum(int n, double k, long [] p) {
		long [] answer = new long [n];
		double sum = p[0];
		long maximum = 0;
		for (int i=1; i<n; i++) {
			answer[i] = (long)Math.ceil((p[i] * 100) / k);
			answer[i] -= sum;
			sum += p[i];
			maximum = Math.max(maximum, answer[i]);
		}
		return maximum;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			double k = sc.nextInt();
			long [] p = new long [n];
			for (int i=0; i<n; i++) {
				p[i] = sc.nextLong();
			}
			System.out.println(minTotalSum(n, k, p));
		}
	}
}