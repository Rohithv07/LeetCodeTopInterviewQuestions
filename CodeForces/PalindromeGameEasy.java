import java.util.*;

public class PalindromeGameEasy {

	public static String findTheWinner(String s) {
		int length = s.length();
		if (length == 1 && s.equals("0"))
			return "BOB";
		int alice = 0;
		int bob = 0;
		int zeroCount = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '0')
				zeroCount += 1;
		}
		String [] possibleResult = new String [] {"BOB", "ALICE"};
		return zeroCount == 1 ? possibleResult[0] : possibleResult[zeroCount % 2];
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			System.out.println(findTheWinner(s));
		}
	}
}