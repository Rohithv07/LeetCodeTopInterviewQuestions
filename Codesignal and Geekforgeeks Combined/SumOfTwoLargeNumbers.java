Given two strings denoting non-negative numbers X and Y. Calculate the sum of X and Y.


Example 1:

Input:
X = "25", Y = "23"
Output:
48
Explanation:
The sum of 25 and 23 is 48.
Example 2:

Input:
X = "2500", Y = "23"
Output:
2523
Explanation:
The sum of 2500 and 23 is 2523.

Your Task:
Your task is to complete the function findSum() which takes two strings as inputs and returns the string without leading zeros. You do not need to take any input or print anything.


Expected Time Complexity: O(|X| + |Y|)
Expected Auxiliary Space: O(1)


Constraints:
1 <= |X|, |Y| <= 105



// User function Template for Java

class Solution {
    String findSum(String X, String Y) {
        // code here
        int rem = 0;
        int lengthX = X.length();
        int lengthY = Y.length();
        int i = lengthX - 1;
        int j = lengthY - 1;
        int frontX = 0;
        int frontY = 0;
        StringBuilder sb = new StringBuilder();
        while (frontX < lengthX - 1 && X.charAt(frontX) == '0') {
            frontX++;
        }
         while (frontY < lengthY - 1 && Y.charAt(frontY) == '0') {
            frontY++;
        }
        //System.out.println(frontX + " " + frontY);
        while (i >= frontX && j >= frontY) {
            int digit1 = X.charAt(i) - '0';
            int digit2 = Y.charAt(j) - '0';
            int sum = digit1 + digit2 + rem;
            rem = sum / 10;
            int toAdd = sum % 10;
            sb.append(toAdd);
            i--;
            j--;
        }
        while (i >= frontX) {
            int digit1 = X.charAt(i) - '0';
            int sum = digit1 + rem;
            rem = sum / 10;
            int toAdd = sum % 10;
            sb.append(toAdd);
            i--;
        }
        while (j >= frontY) {
            int digit2 = Y.charAt(j) - '0';
            int sum = digit2 + rem;
            rem = sum / 10;
            int toAdd = sum % 10;
            sb.append(toAdd);
            j--;
        }
        if (rem > 0) {
            sb.append(rem);
        }
        String result = sb.reverse().toString();
        if (result.charAt(0) == '0' && result.charAt(result.length() - 1) == '0') {
            return "0";
        }
        return result;
    }
}