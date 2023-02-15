Given two binary strings a and b, return their sum as a binary string.

 

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.


class Solution {
    public String addBinary(String a, String b) {
        if (a.equals("0")) {
            return b;
        }
        if (b.equals("0")) {
            return a;
        }
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >=0 || j >= 0) {
            int value1 = (i >= 0 ? a.charAt(i--) - '0' : 0);
            int value2 = (j >= 0 ? b.charAt(j--) - '0' : 0);
            int sum = value1 + value2 + carry;
            int digit = sum % 2;
            carry = sum / 2;
            sb.append(digit);
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}