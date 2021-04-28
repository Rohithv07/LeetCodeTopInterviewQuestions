import java.util.*;

public class MinCostString {
	private static int [] A = new int [26];
	private static int x = 0;
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (n -- > 0) {
			x %= k;
			System.out.print((char) (x + 97));
			x += A[x] ++;
		}
	}
}