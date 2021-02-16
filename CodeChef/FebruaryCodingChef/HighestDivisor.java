import java.util.*;

public class HighestDivisor {

	public static int highestDivisorBetweenOneAndTen(int n) {
		for (int i=10; i>0; i--) {
			if (n % i == 0)
				return i;
		}
		return 1;
	}
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(highestDivisorBetweenOneAndTen(n));
	}
}