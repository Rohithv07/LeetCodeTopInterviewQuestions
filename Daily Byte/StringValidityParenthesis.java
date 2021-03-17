Given a string s that contains only the following characters: (, ), and *, where asterisks can represent either an opening or closing parenthesis, return whether or not the string can form a valid set of parentheses.

Ex: Given the following string s…

s = "*)", return true.
Ex: Given the following string s…

s = "(**)", return true.
Ex: Given the following string s…

s = "((*", return false.



class Solution {
    public boolean checkValidString(String s) {
        int minDiff = 0;
        int maxDiff = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                minDiff += 1;
                maxDiff += 1;
            }
            else if (ch == ')') {
                minDiff -= 1;
                maxDiff -= 1;
            }
            else {
                minDiff -= 1;
                maxDiff += 1;
            }
            if (maxDiff < 0)
                return false;
            minDiff = Math.max(0, minDiff); // rest back to zero if minDiff become < 0
        }
        return minDiff == 0;
    }
}
