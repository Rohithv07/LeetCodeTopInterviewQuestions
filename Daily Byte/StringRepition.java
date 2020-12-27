/*
Given a string s, return all of its repeated 10 character substrings.
Note: You may assume s only contains uppercase alphabetical characters.

Ex: Given the following string s…

s = "BBBBBBBBBBB", return ["BBBBBBBBBB"].
Ex: Given the following string s…

s = "ABABABABABABBBBBBBBBBB", return ["ABABABABAB","BBBBBBBBBB"].
*/

import java.util.*;

class StringRepition {

	public static List<String> repeatedString(String s) {
		List<String> result = new ArrayList<>();
		if (s.length() < 10)
			return result;
		Map<String, Integer>  map =  new HashMap<>();
		int i = 0;
		while (i+10 <= s.length()) {
			String current = s.substring(i, i++ + 10);
			map.put(current, map.getOrDefault(current, 0) + 1);
			if (map.get(current) == 2)
				result.add(current);
		}
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		List<String> result = repeatedString(s);
		for (String ss : result)
			System.out.println(ss);
	}
}