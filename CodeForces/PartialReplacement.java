import java.util.*;

public class PartialReplacement {

	public static int findTheCount(int n, int k, String s) {
		if (s.indexOf("*") == s.lastIndexOf("*"))
			return 1;
		int count = 1;
		for (int i=0; i<n; i++) {
			if (s.charAt(i) == '*') {
				for (int j=Math.min(n-1, i+k); j>i; j--) {
					if (s.charAt(j) == '*') {
						i = j - 1;
						count += 1;
						break;
					}
				}
			}
		}
		return count;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			String s = sc.next();
			System.out.println(findTheCount(n, k, s));
		}
	}
}