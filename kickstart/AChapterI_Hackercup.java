Note: This problem shares similarities with Chapter 2. The solution to either chapter may help with solving the other, so please consider reading both first.
Connie received a string SS for her birthday, consisting entirely of uppercase letters (each between "A" and "Z", inclusive).
However, Connie really only likes nice, consistent strings. She considers a string to be consistent if and only if all of its letters are the same.
Each second, Connie may choose one letter in SS and replace it with a different letter. If her chosen letter is a vowel, then she may replace it with any consonant of her choice. On the other hand, if her chosen letter is a consonant, then she may replace it with any vowel of her choice. The 55 letters "A", "E", "I", "O", and "U" are considered vowels, while the remaining 2121 letters of the alphabet are considered consonants. If a letter appears multiple times in SS, she may only replace a single occurrence per second.
Help her determine the minimum number of seconds required to change SS into any consistent string. Note that SS might already be consistent, in which case 00 seconds would be required.
Constraints
1 \le T \le 451≤T≤45
1 \le |S| \le 1001≤∣S∣≤100
"A" \le S_i \le≤S 
i
​
 ≤ "Z"
The sum of |S|∣S∣ across all test cases is at most 4{,}5004,500.
Input
Input begins with an integer TT, the number of birthdays Connie has had. For each birthday, there is a single line containing the string SS.
Output
For the iith string, print a line containing "Case #i: " followed by the minimum number of seconds required to change SS into any consistent string.
Sample Explanation
In the first case, Connie could replace the second and third letters ("B" and "C") each with "A", yielding the string "AAA" in 22 seconds.
In the second case, "F" is already consistent.
In the third case, Connie could replace the first, third, and fifth letters ("B", "N", and "N") each with "A", yielding the string "AAAAAA" in 33 seconds.
Sample Input
6
ABC
F
BANANA
FBHC
FOXEN
CONSISTENCY
Sample Output
Case #1: 2
Case #2: 0
Case #3: 3
Case #4: 4
Case #5: 5
Case #6: 12

import java.util.*;


// either convert whole string to a common vowel or convert whole string to a common consenent
// compute the total cost in each case
// take the minimum

public class AChapterI {

	public static int minimumSeconds(String s) {
		if (s.length() == 1)
			return 0;
		int length = s.length();
		Set<Character> vowels = new HashSet<>();
		vowels.add('A');
		vowels.add('E');
		vowels.add('I');
		vowels.add('U');
		vowels.add('O');
		char consenent = 'b';
		char vowel = 'a';
		Map<Character, Integer> count = new HashMap<>();
		Set<Character> set = new HashSet<>();
		for (char ch : s.toCharArray()) {
			count.put(ch, count.getOrDefault(ch, 0) + 1);
//			if (!vowels.contains(ch) && consenent == 'b') {
//				consenent = ch;
//			}
//			else if (vowels.contains(ch) && vowel == 'a') {
//				vowel = ch;
//			}
			set.add(ch);
		}
		if (set.size() == 1)
			return 0;
		int maxVowelCount = 0;
		int maxConsenentCount = 0;
		for (char key : count.keySet()) {
			int value = count.get(key);
			if (vowels.contains(key) && maxVowelCount < value) {
				maxVowelCount = value;
				vowel = key;
			}
			else if (!vowels.contains(key) && maxConsenentCount < value) {
				maxConsenentCount = value;
				consenent = key;
			}
			
		}
		if (vowel == 'a' || consenent == 'b') {
			return length;
		}
		return Math.min(convertingSToVowel(s, vowel, vowels), convertingSToConsenent(s, consenent, vowels));
	}

	public static int convertingSToVowel(String s, char vowel, Set<Character> vowels) {
		int cost = 0;
		for (char ch : s.toCharArray()) {
			if (ch == vowel)
				continue;
			if (vowels.contains(ch)) {
				cost += 2;
			}
			else {
				cost += 1;
			}
		}
		return cost;
	}

	public static int convertingSToConsenent(String s, char consenent, Set<Character> vowels) {
		int cost = 0;
		for (char ch : s.toCharArray()) {
			if (ch == consenent)
				continue;
			if (vowels.contains(ch)) {
				cost += 1;
			}
			else {
				cost += 2;
			}
		}
		return cost;
	}



	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t=1; t <= test; t++) {
			String s = sc.next();
			System.out.println("Case #" + t + ": " + minimumSeconds(s));
			
		}
	}
}


// HAAACKEEERCUUUP

/*
H - 1   - 1    - 2
A - 3   - 0    - 3
C - 2   - 2    - 0
K - 1   - 1    - 2
E - 3   - 6    - 3
R - 1   - 1    - 2
U - 3   - 6    - 3
P - 1   - 1    - 2           consent = C, Vowel = A

*/