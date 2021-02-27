/*
You and a friend are trying to choose a restaurant to go to. You both give your preferences of restaurants in separate lists. You need to find a restaurant to go to that’s listed in both of your preferences that has the least index sum. If there are ties, output all restaurants you could go to together.

Ex: Given the following lists...

list1 = ["A", "B", "C", "D"], list2 = ["D", "B", "C"], return [“B”] (“B” is the least index sum 1 + 1 whereas “D” is 3 + 0).
Ex: Given the following lists...

list1 = [“C”], list2 = [“D”], return [].
*/


import java.util.*;

public class Restaurants {

	public static List<Character> minIndexSum(List<Character> list1, List<Character> list2) {
		if (!list1.isEmpty() && list2.isEmpty()) {
			return list1;
		} 
		if (list1.isEmpty() && !list2.isEmpty()) {
			return list2;
		}
		List<Character> result = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<>();
		
		for (int i=0; i<list1.size(); i++) {
			map.put(list1.get(i), i);
		}
		int minSum = Integer.MAX_VALUE;
		for (int i=0; i<list2.size() && i <= minSum; i++) {
			int sum = 0;
			if (map.containsKey(list2.get(i))) {
				sum = i + map.get(list2.get(i));
				if (sum < minSum) {
					result.clear();
					result.add(list2.get(i));
					minSum = sum;
				}
				else if (sum == minSum) {
					result.add(list2.get(i));
				}
			}
		}
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		List<Character> list1 = new ArrayList<>();
		List<Character> list2 = new ArrayList<>();
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		for (int i=0; i<n1; i++) {
			char ch = sc.next().charAt(0);
			list1.add(ch);
		}
		for (int i=0; i<n2; i++) {
			char ch = sc.next().charAt(0);
			list2.add(ch);
		}
		System.out.println(minIndexSum(list1, list2));
	}
}