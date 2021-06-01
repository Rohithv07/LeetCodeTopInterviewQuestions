import java.util.*;

public class PalindromeGameHard {

	public static String whoWins(String s) {
		int length = s.length();
		int zeroCount = 0;
		int jodi = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '0')
				zeroCount += 1;
		}
		int low = 0;
		int high = length - 1;
		while (low < high) {
			if (s.charAt(low ++) != s.charAt(high --))
				jodi += 1;
		}
		String [] possible = new String [] {"BOB", "ALICE"};
		if (jodi == 0) {
			return zeroCount == 1 ? possible[0] : possible[zeroCount % 2];
		}
		else {
			int value = zeroCount - jodi;
			if (value == 1 && jodi == value) {
				return "DRAW";
			}
			else {
				return "ALICE";
			}
		}
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			System.out.println(whoWins(s));
		}
	}
}