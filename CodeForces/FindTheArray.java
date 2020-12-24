import java.util.*;

public class FindTheArray {

	public static long [] beautifulArray(long [] a, int n) {
		long [] b = new long [n];
		for (int i=0; i<n; i++) {
			long log = (long) (Math.log(a[i]) / Math.log(2.0));
			long power = (long) Math.pow(2, log);
			b[i] = power;
		}
		return b;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long [] a = new long[n];
			for (int i=0; i<n; i++) {
				a[i] = sc.nextLong();
			}
			long [] b = beautifulArray(a, n);
			for (long  number : b) {
				System.out.print(number + " ");
			}
			System.out.println();
		}
	}
}