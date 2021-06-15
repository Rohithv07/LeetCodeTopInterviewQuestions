/*
You are a wandering traveler following direction. You are given a string path, each character in the string is either a N, E, S, or W representing a movement one unit north, east, south, and west respectively. Given your path, return whether or not you ever visit a point twice.
Note: You may assume you start at position (0, 0).
Ex: Given the following path…

path = "NE", return false.
Ex: Given the following path…

path = "NESW", return true.
*/

import java.util.*;

public class WanderingTraveler {

	public static boolean whetherWeReachOrigin(String s) {
		if (s == null || s.length() == 0)
			return true;
		int length = s.length();
		int [] origin = new int [] {0, 0};
		for (char ch : s.toCharArray()) {
			if (ch == 'N') {
				origin[0] += 1;
			}
			else if (ch == 'S') {
				origin[0] -= 1;
			}
			else if (ch == 'E') {
				origin[1] += 1;
			}
			else {
				origin[1] -= 1;
			}
			if (conditionCheckOfOrigin(origin))
				return true;
		}
		return conditionCheckOfOrigin(origin); 
	}

	public static boolean conditionCheckOfOrigin(int [] point) {
		return point[0] == 0 && point[1] == 0;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(whetherWeReachOrigin(s));
	}
}