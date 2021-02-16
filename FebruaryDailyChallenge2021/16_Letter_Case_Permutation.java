Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. You can return the output in any order.

 

Example 1:

Input: S = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
Example 2:

Input: S = "3z4"
Output: ["3z4","3Z4"]
Example 3:

Input: S = "12345"
Output: ["12345"]
Example 4:

Input: S = "0"
Output: ["0"]
 

Constraints:

S will be a string with length between 1 and 12.
S will consist only of letters or digits.


class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        char [] converted = s.toCharArray();
        backtrack(result, converted, 0);
        return result;
    }
    
    public void backtrack(List<String> result, char [] converted, int pos) {
        if (pos == converted.length) {
            result.add(new String(converted));
            return;
        }
        if (converted[pos] >= '0' && converted[pos] <= '9') {
            backtrack(result, converted, pos+1);
            return;
        }
        converted[pos] = Character.toLowerCase(converted[pos]);
        backtrack(result, converted, pos+1);
        converted[pos] = Character.toUpperCase(converted[pos]);
        backtrack(result, converted, pos+1);
    }
}
