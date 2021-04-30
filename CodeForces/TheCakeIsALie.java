import java.util.*;

public class TheCakeIsALie {

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			int k = sc.nextInt();
			System.out.println((row * col - 1) == k ? "Yes" : "No");
		}
	}
}