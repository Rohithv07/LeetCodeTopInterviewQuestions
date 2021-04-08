Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].


class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0)
            return result;
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
        backtrackHelper(result, digits, numberMap, 0, "");
        return result;
    }
    
    public void backtrackHelper(List<String> result, String digits, String [] numberMaps, int position, String current) {
        if (position == digits.length()) {
            result.add(new String(current));
            return;
        }
        String letters = numberMaps[digits.charAt(position) - '0'];
        // for (int i=0; i<letters.length(); i++) {
        //     backtrackHelper(result, digits, numberMaps, position + 1, current + letters.charAt(i));
        // }
        for (char ch : letters.toCharArray()) {
            backtrackHelper(result, digits, numberMaps, position + 1, current + ch);
        }
    }
}
