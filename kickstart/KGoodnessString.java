import java.util.*;

public class KGoodnessString {

	public static int findResult(String s, int k) {

		int count = 0;
		int left = 0;
		int right = s.length() - 1;
		while (left <= right) {
			if (s.charAt(left++) != s.charAt(right--))
				count += 1;
		}
		if (count > k) {
		    return count - k;
		}
		if (count < k) {
		    return k - count;
		}
		return 0;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int i=1; i<=test; i++) {
			int length = sc.nextInt();
			int k = sc.nextInt();
			String s = sc.next();
			System.out.println("Case #" + i + ": " + findResult(s, k)); 
		}
	}
}