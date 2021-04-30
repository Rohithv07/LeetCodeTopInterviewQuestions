import java.util.*;

public class RedAndBlueBeans {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long r = sc.nextLong();
			long b = sc.nextLong();
			long d = sc.nextLong();
			// if (d == 0 && r != b) {
			// 	System.out.println("NO");
			// 	continue;
			// }
			long x = Math.min(r, b);
			long y = Math.max(r, b);
			if (x * (d + 1) >= y)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}