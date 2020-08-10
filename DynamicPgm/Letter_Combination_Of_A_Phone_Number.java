Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.

Solution:
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();
        if (digits ==null || digits.length()==0)
            return result;
        String [] numberMap = {
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
        dynamicHelper(result, digits, "", 0, numberMap);
        return result;
    }
    public void dynamicHelper(List<String> result, String digits, String current, int index, String [] numberMap){
        if (index == digits.length()){
            result.add(current);
            return;
        }
        String letter = numberMap[digits.charAt(index) - '0'];
        for (int i=0; i<letter.length(); i++){
            dynamicHelper(result, digits, current + letter.charAt(i), index+1, numberMap);
        }
    }
}
