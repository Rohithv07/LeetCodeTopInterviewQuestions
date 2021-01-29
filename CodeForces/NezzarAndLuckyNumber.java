import java.util.*;

public class NezzarAndLuckyNumber {

	public static boolean isLucky(long val, long d) {
		while (val > 0) {
			long rem = val % 10;
			if (rem == d)
				return true;
			val /= 10;
		}
		return false;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int q = sc.nextInt();
			long d = sc.nextInt();
			long [] values = new long [q];
			for (int i=0; i<q; i++) {
				values[i] = sc.nextLong();
			}
			outerLoop:for (long val : values) {
				while (val >= d) {
					if (isLucky(val, d)) {
						System.out.println("YES");
						continue outerLoop;
					}
					else
						val -= d;
				}
				System.out.println("NO");
			}
		}
	}
}