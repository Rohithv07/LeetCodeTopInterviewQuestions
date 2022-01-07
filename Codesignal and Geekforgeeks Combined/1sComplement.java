Given an N bit binary number, find the 1's complement of the number. The ones' complement of a binary number is defined as the value obtained by inverting all the bits in the binary representation of the number (swapping 0s for 1s and vice versa).
 

Example 1:

Input:
N = 3
S = 101
Output:
010
Explanation:
We get the output by converting 1's in S
to 0 and 0s to 1
Example 2:

Input:
N = 2
S = 10
Output:
01
Explanation:
We get the output by converting 1's in S
to 0 and 0s to 1

Your Task:  
You don't need to read input or print anything. Your task is to complete the function onesComplement() which takes the binary string S, its size N as input parameters and returns 1's complement of S of size N.
 

Expected Time Complexity: O(N)
Expected Space Complexity: O(N)
 

Constraints:
1<=N<=100



//User function Template for Java
class Solution{
    static String onesComplement(String s,int n){
        //code here
        if (s == null || n == 0) {
            return "";
        }
        if (s.equals("1")) {
            return "0";
        }
        if (s.equals("0")) {
            return "1";
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                sb.append('0');
            }
            else {
                sb.append('1');
            }
        }
        return sb.toString();
    }
}