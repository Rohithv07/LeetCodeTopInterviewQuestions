Given an integer N.Create a string using only lowercase characters from a to z that follows the given rules.

When N is even:

Use N/2 characters from the beginning of a-z and N/2 characters from the ending of a-z.

When N is greater than 26,continue repeating the instructions until length of string becomes N.

When N is odd:

Case 1: If the sum of digits of N is even, Select (N+1)/2 characters from the beginning of a-z and (N-1)/2 characters from the ending of a-z.

Case 2: If the sum of digits of N is odd, Select (N-1)/2 characters from the beginning of a-z and (N+1)/2 characters from the ending of a-z.

When N is greater than 26,continue repeating the instructions until length of string becomes N.

 

Example 1:

Input: 
N=21
Output: 
abcdefghijpqrstuvwxyz
Explanation:
Since 21 is odd and sum of digits
of 21 is also odd,we take (21-1)/2=10 
characters from the beginning and 
(21+1)/2=11 characters from the 
end of a-z.
Example 2:

Input:
N=28 
Output: 
abcdefghijklmnopqrstuvwxyzaz
Explanation: 
Since 28>26, we keep repeating 
the process until length of string becomes 
28.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function BalancedString() which takes the integer N as input parameter and returns the string created using given procedures.
 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
 

Constraints:
1 <= N <= 105


class Solution {
   static int sumOfDigits(int n) {
       if(n<=9) {
           return n;
       }
       return sumOfDigits(n/10)+(n%10);
   }
   static String BalancedString(int N) {
       // code here
       String res = "";
       String str = "abcdefghijklmnopqrstuvwxyz";
       int m = N;
       while(m >= 26) {
           res += str;
           m -= 26;
       }
       if(N%2 == 0) {
           N %= 26;
           for(int i=0;i<N/2;i++) {
               res += (char)(i+'a');
           }
           String res1 = "";
           for(int i=0;i<N/2;i++) {
               res1 = (char)('z'-i) + res1;
           }
           return res+res1;
       }
       
       int sum = sumOfDigits(N);
       N %= 26;
       if(sum%2 == 0) {
           for(int i=0;i<(N+1)/2;i++) {
               res += (char)(i+'a');
           }
           String res1 = "";
           for(int i=0;i<(N-1)/2;i++) {
               res1 = (char)('z'-i) + res1;
           }
           return res+res1;
       }
       
       for(int i=0;i<(N-1)/2;i++) {
               res += (char)(i+'a');
       }
       String res1 = "";
       for(int i=0;i<(N+1)/2;i++) {
           res1 = (char)('z'-i) + res1;
       }
       return res+res1;
   }
}