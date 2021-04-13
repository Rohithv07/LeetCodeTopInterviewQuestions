import java.util.*;

public class ChefAndDice {

	public static long visiblePipsSum(long n) {
		if (n == 1)
			return 20;
		if (n == 2)
			return 36;
		if (n == 3)
			return 51;
		if (n == 4)
			return 60;
		long rem = n % 4;
	    long answer = 0L;
		if (rem == 0) {
			answer = (((n - rem) / 4) * 44) + 16;
		}
		else if (rem == 1) {
			answer = (((n - rem) / 4) * 44) + 32;
		}
		else if (rem == 2) {
			answer = (((n - rem) / 4) * 44) + 44;
		}
		else if (rem == 3) {
			answer = (((n - rem) / 4) * 44) + 55;
		}
		return answer;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			System.out.println(visiblePipsSum(n));
		}
	}
}

