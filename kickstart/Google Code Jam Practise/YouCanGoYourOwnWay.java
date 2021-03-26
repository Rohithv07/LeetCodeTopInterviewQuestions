import java.util.*;

public class YouCanGoYourOwnWay {

	public static String alternativePath(String s) {
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if (ch == 'S')
				sb.append('E');
			else
				sb.append('S');
		}
		return sb.toString();
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t=1; t<=test; t++) {
			int n = sc.nextInt();
			String s = sc.next();
			System.out.println("Case #" + t + ": " + alternativePath(s));
		}
	}
}