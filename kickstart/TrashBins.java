package GoogleKickstart;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Change to Solution
 * @author rohithvazhathody
 *
 */
public class TrashBins {

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int n = sc.nextInt();
			String s = sc.next();
			System.out.println("Case #" + t + ": " + findBin(s));
		}
		sc.close();
	}

	private static long findBin(String s) {
		if (s.length() == 1 && s.charAt(0) == '1') {
			return 0;
		}
		Set<Character> set = new HashSet<>();
		for (char ch : s.toCharArray()) {
			set.add(ch);
		}
		if (set.size() == 1) {
			return 0;
		}
		long sum = 0;
		long [] left = new long [s.length()];
		Arrays.fill(left, Integer.MIN_VALUE);
		long [] right = new long[s.length()];
		Arrays.fill(right, Integer.MAX_VALUE);
		long index = Integer.MIN_VALUE;
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i) == '1') {
				index = i;
			}
			left[i] = index;
			
		}
		index = Integer.MAX_VALUE;
		for (int i=s.length()-1; i>=0; i--) {
			if (s.charAt(i) == '1') {
				index = i;
			}
			right[i] = index;
		}
		for (int i=0; i<s.length(); i++) {
			sum += Math.min(right[i] - i, i - left[i]);
		}
		return sum;
	}
}
