/*
Given a string S that contains only lowercase letters, return a list containing the intervals of all the bunches. A bunch is a set of contiguous characters (larger than two) that are all the same. An interval that represents a bunch contains the starting index of the bunch and the ending index of the bunch.
Note: The intervals returned should be in ascending order according to start indexes.
Ex: Given the following string S...

S = “aaabbbccc”, return [[0,2],[3,5],[6,8]].
Ex: Given the following string S...

S = “aaabbcddddd”, return [[0,2],[6,10]].
*/

import java.util.*;

public class FindBunches {

	public static List<List<Integer>> findTheGroups(String s) {
		List<List<Integer>> result = new ArrayList<>();
		int length = s.length();
		if (length < 3)
			return result;
		char [] sToArray = s.toCharArray();
		Arrays.sort(sToArray); // o(nlogn)
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : sToArray) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		for (char key : map.keySet()) { // o(n)
			int value = map.get(key);
			if (value > 2) {
				int possibleIndex = binarySearchHelper(sToArray, key);// (logn)
				List<Integer> startEnd = findStartAndEndPos(sToArray, key, possibleIndex); // o(n)
				result.add(startEnd);
			}
		}
		return result;
	}

	public static int binarySearchHelper(char [] sToArray, char key) {
		int left = 0;
		int right = sToArray.length - 1;
		while (left <= right){
			int mid = left + (right - left) / 2;
			if (sToArray[mid] == key)
				return mid;
			if (sToArray[mid] < key)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return -1;
	}
	
	public static List<Integer> findStartAndEndPos(char [] sToArray, char key, int possibleIndex) {
		List<Integer> positions = new ArrayList<>();
		int start = 0;
		int end = sToArray.length - 1;
		for (int i=possibleIndex; i>=0; i--) {
			if (sToArray[i] == key)
				start = i;
		}
		for (int i=possibleIndex; i<sToArray.length; i++) {
			if (sToArray[i] == key)
				end = i;
		}
		positions.add(start);
		positions.add(end);
		return positions;
	}	
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(findTheGroups(s));
	}
}
