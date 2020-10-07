This question is asked by Google. Given a string of digits, return all possible text messages those digits could send. Note: The mapping of digits to letters is as follows…

0 -> null
1 -> null
2 -> "abc"
3 -> "def"
4 -> "ghi"
5 -> "jkl"
6 -> "mno"
7 -> "pqrs"
8 -> "tuv"
9 -> "wxyz"
Ex: digits = "23" return ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

// 2 -> a, b, c  3  
// 3 -> d, e, f  3  So total 3 * 3 = 9 possible combination 
  2           3
/  | \       / | \
a  b  c      d e  f   [a, b, c] X [d, e, f]

// the possible way is we can do a backtrack here
// if we see 1 and 0, then it just null, we dont want to care about it.
// else we must go through each of the characters, then do the backtrack, continue with the next character until we reach the end of the input length.


public class Solution {
	public List<String> letterCombinations(String digits) {
		// digits = "23" -> a, b, c and d, e, f
		// initialise our result list
		List<String> result =  new ArrayList<>();
		if (digits.length() == 0) // if input is empty
			return result;
		// lets store the all the possible letters that may appear for each of the digit from the phone.
		String [] numberMap = new String [] {
			"0",
			"1",
			"abc",
			"def",
			"ghi",
			"jkl",
			"mno",
			"pqrs",
			"tuv",
			"wxyz"		
		};
		backtrack(result, digits, numberMap, 0, "");  // result, our given digit, the number map, the position, the possible string forming
		return result;
	}
	public void backtrack(List<String> result, String digits, String [] numberMap, int pos, String current) {
		// if the position == length of digit, add the current string to the result
		if (pos == digits.length()) {
			result.add(new String(current));
			return;		
		}	
		// suppose we have digit 2, so we have a, b, c.So we look at the charcater at the digits and take the possible letters from numberMap
		String letter = numberMap[digits.charAt(pos) - '0'];
		// now we have abc, so we go through each of these letters and do the backtracking
		for (int i=0; i<letter.length(); i++) {
			backtrack(result, digits. numberMap, pos+1, current+letter.charAt(i));
		}
	}

}
