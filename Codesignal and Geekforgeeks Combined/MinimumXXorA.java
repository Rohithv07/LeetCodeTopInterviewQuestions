Given two integers A and B, the task is to find an integer X such that (X XOR A) is minimum possible and the count of set bit in X is equal to the count of set bits in B.

Example 1:

Input: 
A = 3, B = 5
Output: 3
Explanation:
Binary(A) = Binary(3) = 011
Binary(B) = Binary(5) = 101
The XOR will be minimum when x = 3
i.e. (3 XOR 3) = 0 and the number
of set bits in 3 is equal
to the number of set bits in 5.
Example 2:

Input: 
A = 7, B = 12
Output: 6
Explanation:
(7)2= 111
(12)2= 1100
The XOR will be minimum when x = 6 
i.e. (6 XOR 7) = 1 and the number 
of set bits in 6 is equal to the 
number of set bits in 12.
Your task :
You don't need to read input or print anything. Your task is to complete the function minVal() that takes integer A and B as input and returns the value of X according to the question.
 
Expected Time Complexity : O(log N)
Expected Auxiliary Space : O(1)
 
Constraints :
1 <= A, B <= 109



// User function Template for Java

class Solution {
    
    private static int countBits(int n) {
        int count = 0;
        while (n > 0) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }
    
    public static int minVal(int a, int b) {
        int bitsA = countBits(a);
        int bitsB = countBits(b);
        int diff = Math.abs(bitsA - bitsB);
        if (bitsA == bitsB) {
            return a;
        }
        if (bitsA > bitsB) {
            while (diff > 0) {
                a = a & (a - 1);
                diff--;
            }
        }
        else {
            while (diff > 0) {
                a = a | (a + 1);
                diff--;
            }
        }
        return a;
    }
}