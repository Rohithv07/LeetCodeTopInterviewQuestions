import java.util.*;

public class OddDivisor {

	public static boolean isOddDivisor(long number) {
		while (number % 2 == 0)
			number /= 2;
		return number > 1;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long number = sc.nextLong();
			if (!isOddDivisor(number))
				System.out.println("NO");
			else
				System.out.println("YES");
		}
	}
}