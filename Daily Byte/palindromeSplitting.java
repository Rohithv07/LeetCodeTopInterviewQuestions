This question is asked by Google. Given a string s, return all possible partitions of s such that each substring is a palindrome.

Ex: Given the following string s…

s = "abcba",
return [
    ["a","b","c","b","a"],
    ["a","bcb","a"],
    ["abcba"]
]

// here we need to take each and every possible substring from the given string and check whether it is a palindrome or not, if yes, we need to save it.
// but here we need possible 2 nested loops to go through each character, form substring and another loop to check for the palindrome checking. So the complexity will be n^3.
// But we can do backtracking and find out each and every substring, whetehr forms a palindrome or not. If yes, just save it, otherwise backtrack go on with other possible substring and again check the palindrome condition.

public class Solution {
	public List<List<String>> palidromePartioning(String s) {
		// we can have our result storing varibale
		List<List<String>> result = new ArrayList<>();
		// keep track of a current word system
		List<String> current = new ArrayList<>();
		backtrack(result, current, 0, s); // we are passing result, current, int starting index, and the given string
		return result;	
	}
	public void backtrack(List<List<String>> result, List<String> current, int start, String s) {
		if (start == s.length()) {
			result.add(new ArrayList(current));
			return;		
		}	
		// now go through the string and check for the palindrome condition
		for (int i=start; i<s.length(); i++) {
			// this is our function checking palindrome
			if (isPalindrome(s, start, i)) {
				// make our choice
				current.add(s.substring(start, i+1));
				// do the backtrack again
				backtrack(result, current, i+1, s);
				// undo our last choice
				current.remove(current.size()-1);
			}		
		}
	}
	public boolean isPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--))
				return false;
		}
		return true;
	}
}




Time Complexity : N * 2 ^ N
 ), where N is the length of string s. This is the worst-case time complexity when all the possible substrings are palindrome.
Example, if = s = aaa, the recursive tree can be illustrated as follows: https://leetcode.com/problems/palindrome-partitioning/solution/


Hence, there could be 2^N possible substrings in the worst case. For each substring, it takes O(N)time to generate substring and determine if it a palindrome or not. This gives us time complexity)


Space Complexity: O(N), where N is the length of the string s. This space will be used to store the recursion stack. For s = aaa, the maximum depth of the recursive call stack is 3 which is equivalent to N.
