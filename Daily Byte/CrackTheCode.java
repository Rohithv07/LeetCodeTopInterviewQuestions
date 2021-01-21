/*
Given a string s and a string code, return whether or not s could have been encrypted using the pattern represented in code.

Ex: Given the following s and code...

s = “the daily byte”, code = “abc”, return true
Ex: Given the following s and code...

s = “the daily byte curriculum”, code = “abcc”, return false because ‘c’ in code already maps to the word “byte”
*/



import java.util.*;

public class CrackTheCode {

	public static boolean isCorrectPattern(String s, String code) {
		String [] splitS = s.split(" ");
		if (splitS.length != code.length())
			return false;
		Map<Character, String> map = new HashMap<>();
		for (int i=0; i<splitS.length; i++) {
			char currentCh = code.charAt(i);
			if (map.containsKey(currentCh)) {
				String currentString = map.get(currentCh);
				if (!currentString.equals(splitS[i]))
					return false;
			}
			map.put(currentCh, splitS[i]);
		}
		return true;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String code = sc.next();
		System.out.println(isCorrectPattern(s, code));
	}
}