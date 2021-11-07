Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

 

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
 

Constraints:

1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.



class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return "";
        }
        int length1 = num1.length();
        int length2 = num2.length();
        int [] position = new int [length1 + length2];
        StringBuilder sb = new StringBuilder();
        for (int i=length1-1; i>=0; i--) {
            for (int j=length2-1; j>=0; j--) {
                int value = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = value + position[p2];
                position[p1] += sum / 10;
                position[p2] = sum % 10;
            }
        }
        for (int pos : position) {
            if (!(sb.length() == 0 && pos == 0)) {
                sb.append(pos);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}