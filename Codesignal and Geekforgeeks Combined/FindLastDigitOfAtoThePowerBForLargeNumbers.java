You are given two integer numbers, the base a and the index b. You have to find the last digit of ab.

 

Example 1:

Input:
a = "3", b = "10"
Output:
9
Explanation:
310 = 59049. Last digit is 9.
Example 2:

Input:
a = "6", b = "2"
Output:
6
Explanation:
62 = 36. Last digit is 6.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function getLastDigit() which takes an Strings a, and b as input and returns the answer.

 

Expected Time Complexity: O(|b|)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= |a|,|b| <= 1000


//User function Template for Java

class Solution {
    static int getLastDigit(String a, String b) {
        // code here
        int lengthA = a.length();
        int lengthB = b.length();
        if (lengthA == 1 && lengthB == 1 && a.charAt(0) == '0' && b.charAt(0) == '0') {
            return 1;
        }
        if (lengthB == 1 && b.charAt(0) == '0') {
            return 1;
        }
        if (lengthA == 1 && a.charAt(0) == '0') {
            return 0;
        }
        int exponent = (modulo(4, b.toCharArray()) == 0) ? 4 : modulo(4, b.toCharArray());
        int result = (int)(Math.pow(a.charAt(lengthA - 1) - '0', exponent));
        return result % 10;
    }
    static int modulo(int a, char [] b) {
        int mod = 0;
        for (int i=0; i<b.length; i++) {
            mod = (mod * 10 + b[i] - '0') % a;
        }
        return mod;
    }
    
}