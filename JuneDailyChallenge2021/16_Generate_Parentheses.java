Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8


class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        String current = "";
        backtrack(result, current, 0, 0, n);
        return result;
    }
    
    public void backtrack(List<String> result, String current, int left, int right, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
        }
        if (left < n) {
            backtrack(result, current + '(', left + 1, right, n);
        }
        if (right < left) {
            backtrack(result, current + ')', left, right + 1, n);
        }
    }
}


// left = 0 right = 0

// if left < n, we add open braces

// if right < left, we add closed braces

// if our strings lenght become 2 * n, we can add the current string to the result
