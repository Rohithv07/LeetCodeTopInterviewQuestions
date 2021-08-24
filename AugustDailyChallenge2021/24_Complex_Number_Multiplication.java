A complex number can be represented as a string on the form "real+imaginaryi" where:

real is the real part and is an integer in the range [-100, 100].
imaginary is the imaginary part and is an integer in the range [-100, 100].
i2 == -1.
Given two complex numbers num1 and num2 as strings, return a string of the complex number that represents their multiplications.

 

Example 1:

Input: num1 = "1+1i", num2 = "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
Example 2:

Input: num1 = "1+-1i", num2 = "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 

Constraints:

num1 and num2 are valid complex numbers.


class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] splitedA = a.split("\\+");
        String[] splitedB = b.split("\\+");
        int x = Integer.parseInt(splitedA[0]);
        int y = Integer.parseInt(splitedA[1].split("i")[0]);
        int p = Integer.parseInt(splitedB[0]);
        int q = Integer.parseInt(splitedB[1].split("i")[0]);
        return String.valueOf(x * p - y * q) + "+" + String.valueOf(x * q + p * y) + "i";
    }
}