import java.util.*;

public class NestingDepth {

	public static String generateResult(String s) {
		int length = s.length();
		int current = 0;
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			while (current < ch - '0') {
				sb.append("(");
				current += 1;
			}
			while (current > ch - '0') {
				sb.append(")");
				current -= 1;
			}
			sb.append(ch);
		}
		while (current > 0) {
			sb.append(")");
			current -= 1;
		}
		return sb.toString();
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t=1; t<=test; t++) {
			String s = sc.next();
			System.out.println("Case #" + t + ": " + generateResult(s));
		}
	}
}