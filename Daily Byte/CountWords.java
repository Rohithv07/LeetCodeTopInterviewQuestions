/*

Given a list of words, return the top k frequently occurring words.
Note: If two words occur with the same frequency, then the alphabetically smaller word should come first.
Ex: Given the following words and value k…

words = ["the", "daily", "byte", "byte"], k = 1, return ["byte"].
Ex: Given the following words and value k…

words = ["coding", "is", "fun", "code", "coding", "fun"], k = 2, return ["coding","fun"].

*/


import java.util.*;

public class CountWords {

	public static List<String> countMostWords(String [] words, int k) {
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) 
			map.put(word, map.getOrDefault(word, 0) + 1);
		PriorityQueue<String> pq = new PriorityQueue<>((w1, w2) -> map.get(w1) == map.get(w2) ? w2.compareTo(w1) : map.get(w1) - map.get(w2));
		List<String> result = new ArrayList<>();
		for (String word : map.keySet()) {
			pq.add(word);
			if (pq.size() > k)
				pq.remove();
		}
		while (!pq.isEmpty()) {
			result.add(pq.remove());
		}
		Collections.reverse(result);
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int capacity = sc.nextInt();
		String [] words = new String[capacity];
		for (int i=0; i<capacity; i++)
			words[i] = sc.next();
		int k = sc.nextInt();
		System.out.println(countMostWords(words, k));
	}
}