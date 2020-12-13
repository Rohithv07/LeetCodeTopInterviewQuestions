
/*
This question is asked by Facebook. Given a string, check if it can be modified such that no two adjacent characters are the same. If it is possible, return any string that satisfies this condition and if it is not possible return an empty string.

Ex: Given the following string s…

s = "abb", return "bab".
Ex: Given the following string s…

s = "xxxy", return "" since it is not possible to modify s such that no two adjacent characters are the same.
*/

import java.util.*;

public class NoSameNeighbour {

	public static String reOrganiseString(String word) {
		if (word == "")
			return word;
		// first we find the occurance of each leetr, that is the freq
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : word.toCharArray())
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		// we make use of a maxHeap and priorityqueu is used
		// we populate the priorityqueue based on the max occurance to smaller
		PriorityQueue<Character> pq = new PriorityQueue((a, b) -> map.get(b) - map.get(a));
		pq.addAll(map.keySet());
		StringBuilder sb = new StringBuilder();
		while (pq.size() > 1) {
			char current = pq.remove();
			char next = pq.remove();
			sb.append(current);
			sb.append(next);
			map.put(current, map.get(current) - 1);
			map.put(next, map.get(next) - 1);
			// repopulate the pq if the count > 0
			if (map.get(current) > 0) 
				pq.add(current);
			if (map.get(next) > 0)
				pq.add(next);
		}	
		if (!pq.isEmpty()) {
			char remaining = pq.remove();
			if (map.get(remaining) > 1)
				return "";
			sb.append(remaining);
		}
		return sb.toString();
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		System.out.println(reOrganiseString(word));
	}
}

