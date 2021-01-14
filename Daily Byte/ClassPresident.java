High school students are voting for their class president and you’re tasked with counting the votes. Each presidential candidates is represented by a unique integer and the candidate that should win the election is the candidate that has received more than half the votes. Given a list of integers, return the candidate that should become the class president.
Note: You may assume there is always a candidate that has received more than half the votes.

Ex: Given the following votes…

votes = [1, 1, 2, 2, 1], return 1.
Ex: Given the following votes…

votes = [1, 3, 2, 3, 1, 2, 3, 3, 3], return 3.


import java.util.*;

public class ClassPresident {

	public static int findThePresident(int [] votes) {
		/*int length = votes.length;
		int [] candidate = new int [length];
		for (int number : votes) {
			candidate[number - 1] += 1;
		}
		int threshold = length / 2;
		for (int i=0; i<candidate.length; i++) {
			if (candidate[i] > threshold)
				return i + 1;
		}
		return -1;
		*/
		int length = votes.length;
		Map<Integer, Integer> candidate = new HashMap<>();
		for (int number : votes)
			candidate.put(number, candidate.getOrDefault(number, 0) + 1);
		int threshold = length / 2;
		for (int key : candidate.keySet()) {
			if (candidate.get(key) > threshold)
				return key;
		}
		return -1;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] votes = new int [n];
		for (int i=0; i<n; i++) {
			votes[i] = sc.nextInt();
		}
		System.out.println(findThePresident(votes));
	}
}