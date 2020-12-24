import java.util.*;

public class FindTheArray_II {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long sum1 = 0;
			long sum2 = 0;
			long [] a = new long[n];
			for (int i=0; i<n; i++) {
				a[i] = sc.nextLong();
				if (i % 2 == 0)
					sum1 += a[i];
				else
					sum2 += a[i];
			}
			if (sum1 < sum2) {
				for (int i=0; i<n; i=i+2)
					a[i] = 1;
			}
			else {
				for (int i=1; i<n; i=i+2)
					a[i] = 1;
			}
			for (long number : a)
				System.out.print(number + " ");
			System.out.println();
		}
	}
}