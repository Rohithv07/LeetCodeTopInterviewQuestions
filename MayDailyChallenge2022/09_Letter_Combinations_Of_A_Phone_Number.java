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
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
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
        backtrack(result, numberMap, digits, 0, "");
        return result;
    }
    
    public void backtrack(List<String> result, String [] numberMap, String digits, int pos, String current) {
        if (pos >= digits.length()) {
            result.add(current);
            return;
        }
        String currentMap = numberMap[digits.charAt(pos) - '0'];
        for (char ch : currentMap.toCharArray()) {
            backtrack(result, numberMap, digits, pos + 1, current + ch);
        }
    }
}