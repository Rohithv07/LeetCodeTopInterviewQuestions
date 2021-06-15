import java.util.*;

public class GameOfLife {

	public static String finalStringAfterIteration(String s, int k) {
		k = Math.min(k, 1000);
		StringBuilder sb = new StringBuilder(s);
		while (k > 0) {
			int left = 0;
			for (int i=0; i<s.length(); i++) {
				char ch = sb.charAt(i);
				if (ch == '1') {
					left = 1;
					continue;
				}
				int right = i == s.length() - 1 || sb.charAt(i + 1) == '0' ? 0 : 1;
				if (left != right) {
					sb.setCharAt(i, '1');
				}
				left = 0;
			}
			k --;
		}
		return sb.toString();
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int length = sc.nextInt();
			int k = sc.nextInt();
			String s = sc.next();
			System.out.println(finalStringAfterIteration(s, k));
		}
		

	}
}