import java.util.*;

public class LordOfTheValues {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int [] nums = new int [n];
			for (int i=0; i<n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(3 * n);
			for (int i=2; i<=n; i+=2) {
				System.out.println("2 " + (i - 1) + " " + i);
				System.out.println("2 " + (i - 1) + " " + i);
				System.out.println("1 " + (i - 1) + " " + i);
				System.out.println("2 " + (i - 1) + " " + i);
				System.out.println("2 " + (i - 1) + " " + i);
				System.out.println("1 " + (i - 1) + " " + i);
			}
		}
	}
}