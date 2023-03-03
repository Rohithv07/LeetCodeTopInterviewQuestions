// https://practice.geeksforgeeks.org/contest/interview-series-amdocs/problems/


Given a rectangle of dimensions L x B find the minimum number (N) of identical squares of maximum side that can be cut out from that rectangle so that no residue remains in the rectangle. Also find the dimension K of that square.

Example 1:

Input: L = 2, B = 4
Output: N = 2, K = 2
Explaination: 2 squares of 2x2 dimension.

Example 2:

Input: L = 6, B = 3
Output: N = 2, K = 3
Explaintion: 2 squares of 3x3 dimension. 

Your Task:
You do not need to read input or print anything. Your task is to complete the function minimumSquares() which takes L and B as input parameters and returns a list of 2 integers containing the values of N and K respectively.


Expected Time Complexity: O(log min(L, B))
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ L, B ≤ 109

//User function Template for Java

class Solution{
    static List<Long> minimumSquares(long l, long b)
    {
        List<Long> result = new ArrayList<>();
        long dimension = findGCD(l, b);
        long count = 0;
        count = (l / dimension) * (b / dimension);
        result.add(count);
        result.add(dimension);
        return result;
    }
    
    static long findGCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
}