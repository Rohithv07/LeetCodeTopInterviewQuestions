package contests;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author rohithvazhathody 07-Aug-2025
 */
public class MoveBrackets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			int findMinMove = findMinMove(s, n);
			System.out.println(findMinMove);
		}
		sc.close();
	}

	private static int findMinMove(String s, int n) {
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				stack.push(')');
			} else {
				if (!stack.isEmpty() && stack.peek() == ')') {
					stack.pop();
				}
			}
		}
		return stack.size();
	}

}
