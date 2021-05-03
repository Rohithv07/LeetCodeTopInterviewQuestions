import java.util.*;

public class AlexeyAndTrain {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int [] a = new int [n];
			int [] b = new int [n];
			int [] t = new int [n];
			for (int i=0; i<n; i++) {
				a[i] = sc.nextInt();
				b[i] = sc.nextInt();
			}
			for (int i=0; i<n; i++) {
				t[i] = sc.nextInt();
			}
			int time = 0;
			int previous = 0;
			for (int i=0; i<n; i++) {
				time += a[i] - previous + t[i];
				previous = b[i];
				int temp = (b[i] - a[i] + 1)/ 2;
				if (i < n - 1) {
					time = Math.max(time + temp, b[i]);
				}
			}
			System.out.println(time);

		}
	}
}