import java.util.*;

public class Jumps {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			long initial = 0;
			int jumps = 0;
			int index = 0;
			for (int i=1; initial<n; i++) {
				initial += i;
				jumps += 1;
			}
			if (initial == n + 1)
				System.out.println(jumps + 1);
			else
				System.out.println(jumps);
		}
	}
}