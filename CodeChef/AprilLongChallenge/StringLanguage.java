import java.util.*;

public class StringLanguage {

	public static String canPossible(int n, int target, String s) {
		int count = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '*') {
				count += 1;
				if (count == target)
					return "YES";
			}
			else {
				count = 0;
			}
		}
		return "NO";
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int target = sc.nextInt();
			String s = sc.next();
			System.out.println(canPossible(n, target, s));
		}
	}
}