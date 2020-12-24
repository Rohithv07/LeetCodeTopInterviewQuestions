import java.util.*;

public class Dungeon {

	public static String canKill(long a, long b, long c) {
		if (a == 1 && b == 1 && c == 1)
			return "NO";
		long sum = findSum(a, b, c);

		if (sum % 9 != 0 || sum > 9 * minimum(a, b, c))
			return "NO";
		return "YES";
	}

	public static long findSum(long a, long b, long c) {
		return a + b + c;
	}

	public static long minimum(long a, long b, long c) {
		return Math.min(a, Math.min(b, c));
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test -- > 0) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			long c = sc.nextLong();
			System.out.println(canKill(a, b, c));
		}
	}
}