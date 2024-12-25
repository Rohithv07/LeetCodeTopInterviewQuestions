package practice.nineoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author rohithvazhathody 25-Dec-2024
 */
public class DeletiveEditing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s1 = sc.next();
			String s2 = sc.next();
			List<Character> list = new ArrayList<>();
			for (int i = s1.length() - 1; i >= 0; i--) {
				list.add(s1.charAt(i));
			}
			int pointer = -1;
			boolean isPresent = true;
			for (int i = s2.length() - 1; i >= 0; i--) {
				char ch = s2.charAt(i);
				int index = list.indexOf(ch);
				if (index > pointer) {
					pointer = index;
					list.set(index, 't');
				} else {
					isPresent = false;
					break;
				}
			}
			if (!isPresent) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
		sc.close();
	}

}
