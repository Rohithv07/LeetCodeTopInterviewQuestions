Given a number X and two positions (from right side) in binary representation of x, write a program that swaps N bits at given two positions and returns the result.

 

Example 1:

Input:
X = 47
P1 = 1
P2 = 5
N = 3
Output: 227
Explanation:
The 3 bits starting from the second bit 
(from the right side) are swapped with 3 bits
starting from 6th position (from the right side) 
X = 47 (00101111)
[001]0[111]1
ANS = [111]0[001]1
ANS = 227 (11100011)
Hence, the result is 227.  
 

Example 2:

Input:
X = 28
P1 = 0
P2 = 3
N = 2
Output: 7

Your Task:  
You don't need to read input or print anything. Your task is to complete the function swapBits() which takes the integer X, integer P1, integer P2, and integer N as input parameters and returns the new integer after swapping. 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)
 


Constraints:
1 ≤ X ≤ 200
0 ≤ P1 < P2 ≤ 11
1 ≤ N ≤ 5



class Solution{
    
    int swapBits(int n, int p1, int p2, int x)
    {
        int xOnes = (1 << x) - 1;
        int n1 = n & (xOnes << p1);
        int n2 = n & (xOnes << p2);
        int change = p2 - p1;
        int mask = ~((xOnes << p1) | (xOnes << p2));
        n &= mask;
        return n | (n1 << change) | (n2 >> change);
    }
}