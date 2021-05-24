/*
You are typing on a broken keyboard trying to spell your friend’s name. Since the keyboard is broken, sometimes when you press a key the key is typed one or more times. Given a string typed and a string namereturn whether or not you’ve successfully typed your friend’s name even though certain keys might be repeated.
Note: Both strings will only contain lowercase alphabetical characters.

Ex: Given the following typed and name…

typed = "kkevin", name = "kevin", return true.
Ex: Given the following typed and name…

typed = "timmm", name = "timmy", return false.
*/

import java.util.*;

public class BrokenKeyboard {

	public static boolean isThereMatch(String name, String typed) {
		if (name.equals(typed))
			return true;
		if (name.length() > typed.length())
			return false;
		int length1 = name.length();
		int length2 = typed.length();
		int i = 0;
		int j = 0;
		while (i < length1 && j < length2) {
			char a = name.charAt(i);
			char b = typed.charAt(j);
			if (a != b)
				return false;
			while (i < length1 && j < length2 && name.charAt(i) == a && typed.charAt(j) == b) {
				i ++;
				j ++;
			}
			while (j < length2 && typed.charAt(j) == b) {
				j ++;
			}
		}
		if (i == length1 && j != length2 || i != length1 && j == length2) {
			return false;
		}
		return true;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		String typed = sc.next();
		System.out.println(isThereMatch(name, typed));
	}
}