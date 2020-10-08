This question is asked by Facebook. Given an integer N, where N represents the number of pairs of parentheses (i.e. ”(“ and ”)”) you are given, return a list containing all possible well-formed parentheses you can create.

Ex: Given the following value of N…

N = 3, 
return [  
    "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]	



class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>(); // to store all the possible combinations
		String current = ""; // keep track of the current possible string
		// fills the result list with all possible strings		
		backtrack(result, current, 0, 0, n);
		return result;
	} 
	public void backtrack(List<String> result, String current, int left, int right, int n) {
		// base condition- if string length = 2 * N as there will be both opening and closing parenthesis
		if (current.length() == 2 * n) {
			result.add(new String(current));
			return;		
		}
		// if our left < N, add "(" and do backtrack
		if (left < n)
			backtrack(result, current+"(", left+1, right, n);
		if (right < left)
			backtrack(result, current+")", left, right+1, n);
	}
}
