Akku likes binary numbers and she likes playing with these numbers. Her teacher once gave her a question.For given value of  L and R, Akku have to find the count of number X, which have only three-set bits in it's binary representation such that "L ≤ X ≤ R".Akku is genius, she solved the problem easily. Can you do it ??

Example 1:

Input:
L = 11 and R = 19 
Output: 4
Explanation:
There are 4 such numbers with 3 set bits in 
range 11 to 19.
11 -> 1011
13 -> 1101
14 -> 1110
19 -> 10011
 

Example 2:

Input:
L = 25 and R = 29
Output: 3
Explanation:
There are 3 such numbers with 3 set bits in
range 25 to 29. 
25 -> 11001 
26 -> 11010 
28 -> 11100

Your Task:  
You don't need to read input or print anything. Your task is to complete the function solve() which takes the integer L and R as input parameters and returns the count of number X, which have only three-set bits in its binary representation such that "L ≤ X ≤ R".

Expected Time Complexity: O(633) + O(log(R-L))
Expected Auxiliary Space: O(633)


Constraints:
1 ≤ L ≤ R ≤ 1018




class Solution{
    
    void precompute(){
        // Code Here
    }
    long solve(long L, long R){
        // Code here
        long i = 1l;
        long count = 0;
        while (i < R) {
            long j = i << 1;
            while (j < R) {
                long k = j << 1;
                while (k < R) {
                    long temp = i | j | k;
                    if (L <= temp && temp <= R) {
                        count++;
                    }
                    k <<= 1;
                }
                j <<= 1;
            }
            i <<= 1;
        }
        return count;
    }
    
}