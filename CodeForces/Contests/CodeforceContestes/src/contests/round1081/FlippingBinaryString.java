/**
 * @author rohithvazhathody
 * @date 21 Feb 2026
 * Project: CodeforceContestes
 * File: FlippingBinaryString.java
 */

package contests.round1081;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class FlippingBinaryString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			ResultDS resultDS = findResultDS(s);
			System.out.println(resultDS.operation);
			if (resultDS.ways != null) {
				for (Integer way : resultDS.ways) {
					System.out.print(way + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}

	private static ResultDS findResultDS(String s) {
		int countZero = 0;
		int countOne = 0;
		int countIndex = -1;
		int index = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '0') {
				countZero++;
				countIndex = index;
			} else {
				countOne++;
			}
			index++;
		}
		if (countZero == 1) {
			return new ResultDS(1, new ArrayList<>(Arrays.asList(countIndex + 1)));
		}
		if (countZero == s.length()) {
			return new ResultDS(0, null);
		}
		List<Integer> ways = new ArrayList<>();
		if (countOne % 2 == 0) {
			for (index = 0; index < s.length(); index++) {
				char ch = s.charAt(index);
				if (ch == '1') {
					ways.add(index + 1);
				}
			}
			return new ResultDS(ways.size(), ways);
		} else if (countZero % 2 == 1) {
			for (index = 0; index < s.length(); index++) {
				char ch = s.charAt(index);
				if (ch == '0') {
					ways.add(index + 1);
				}
			}
			return new ResultDS(ways.size(), ways);
		}
		return new ResultDS(-1, null);
	}

}

class ResultDS {
	int operation;
	List<Integer> ways;

	public ResultDS(int operation, List<Integer> ways) {
		this.operation = operation;
		this.ways = ways;
	}
}
