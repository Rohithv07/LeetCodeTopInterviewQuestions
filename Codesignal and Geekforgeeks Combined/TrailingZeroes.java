// includes both iterative and recursive solution O(logn)


For an integer N find the number of trailing zeroes in N!.

Example 1:

Input:
N = 5
Output:
1
Explanation:
5! = 120 so the number of trailing zero is 1.
Example 2:

Input:
N = 4
Output:
0
Explanation:
4! = 24 so the number of trailing zero is 0.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function trailingZeroes() which take an integer N as an input parameter and returns the count of trailing zeroes in the N!.

Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 109

//User function Template for Java
class Solution{
    static int trailingZeroes(int N){
        // Write your code here
        // int count = 0;
        // while (N > 0) {
        //     N /= 5;
        //     count += N;
        // }
        // return count;
        if (N == 0)
            return 0;
        return N / 5 + trailingZeroes(N / 5);
    }
    
    // prime factors of 2 and 5
}
