import java.util.*;

public class AlphabeticalStrings {

	public static boolean isAlphabetic(String s) {
		int position = -1;
		for (int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == 'a') {
				position = i;
				break;
			}
		}
		if (position == -1)
			return false;
		int left = position;
		int right = left;
		for (int i=1; i<s.length(); i++) {
			int index = s.indexOf((char)'a' + i);
			//System.out.println("Index: " + index);
			if (index == -1 || (index != left - 1 && index != right + 1))
				return false;
			else {
				left = Math.min(left, index);
				right = Math.max(right, index);
			}
		}
		return true;

	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			boolean result = isAlphabetic(s);
			if (result)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}