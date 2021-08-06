import java.util.*;

public class DoNotBeDistracted {

	public static String isTeacherSuspicious(String s) {
		if (s.length() == 1)
			return "YES";
		boolean [] finished = new boolean [26];
		for (int i=1; i<s.length(); i++) {
			char cur = s.charAt(i);
			char pre = s.charAt(i - 1);
			if (finished[cur - 'A']) {
				return "NO";
			}
			if (cur == pre) {
				continue;
			}
			if (cur != pre) {
				finished[pre - 'A'] = true;
			}
		}
		if (finished[s.charAt(s.length() - 1) - 'A'])
			return "NO";
		return "YES";
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			System.out.println(isTeacherSuspicious(s));
		}
	}
}