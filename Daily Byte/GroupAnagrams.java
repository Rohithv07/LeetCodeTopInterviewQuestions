/*
Given a list of strings, return a list of strings containing all anagrams grouped together.

Ex: Given the following list of strings strs…

strs = ["car", "arc", "bee", "eeb", "tea"], return
[
  ["car","arc"],
  ["tea"],
  ["bee","eeb"]
]
*/
import java.util.*;

public class GroupAnagrams {

	public static List<List<String>> grouped(String [] words) {
		if (words.length == 0)
			return new ArrayList<>();
		int [] count = new int [26];
		Map<String, List<String>> map = new HashMap<>();
		for (String word : words) {
			Arrays.fill(count, 0);
			StringBuilder sb = new StringBuilder();
			for (char ch : word.toCharArray())
				count[ch - 'a'] += 1;
			for (int number : count) {
				sb.append("*");
				sb.append(number);
			}
			String key = sb.toString();
			if (!map.containsKey(key))
				map.put(key, new ArrayList<>());
			map.get(key).add(word);
		}
		return new ArrayList<>(map.values());
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int element = sc.nextInt();
		String [] words = new String[element];
		for (int i=0; i<element; i++)
			words[i] = sc.next();
		System.out.println(grouped(words)); 
	}
}