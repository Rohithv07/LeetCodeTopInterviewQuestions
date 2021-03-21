/*
You are playing a game with a friend. In this game you’re given a string s and you and your friend take turns making moves. A move consists of flipping two consecutive + signs into - signs. Given a string s, return a list containing all possible states of s after you’ve made the first move.

Ex: Given the following string s...

s = “++”, return [“—-“].
Ex: Given the following string s...

s = “++++”, return ["--++","+--+","++--"].
*/

import java.util.*;

public class PlusToMinus {

	public static List<String> makePlusToMinus(String s) {
		List<String> result = new ArrayList<>();
		if (s.length() < 2) {
			return result;
		}
		backtrack(result, s, "", 0, 0);
		return result;
	}

	public static void backtrack(List<String> result, String s, String current, int step, int move) {
		if (move == 1) {
			result.add(current);
			return;
		}
		for (int i=0; i<s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				current += s.substring(0, i) + "--" + s.substring(i+2);
				backtrack(result, s, current, i+1, 1);
				current = "";
			}
		}
	}

	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(makePlusToMinus(s));
	}
}