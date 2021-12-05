Given three integers M, N and K. Consider a grid of M * N, where mat[i][j] = i * j (1 based index). The task is to return the Kth smallest element in the M * N multiplication table.
 

Example 1:

Input:
M = 3, N = 3
K = 5
Output: 3
Explanation: 

The 5th smallest element is 6. 


Example 2:

Input:
M = 2, N = 3
K = 6
Output: 6 

 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function KthSmallest() which takes three integers as input and returns an integer as output.

Expected Time Complexity: O(M * log(M * N))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= M, N <= 3 * 104
1 <= K <= M * N



class Solution {
    public int KthSmallest(int m, int n, int k) {
        //Write your code here
        int low = 1;
        int high = m * n;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            int whichRank = getRank(m, n, middle);
            if (whichRank >= k) {
                high = middle - 1;
            }
            else {
                low = middle + 1;
            }
        }
        return low;
    }
    
    private int getRank(int m, int n, int middle) {
        int row = m - 1;
        int col = 0;
        int result = 0;
        while (row >= 0 && col < n) {
            if ((row + 1) * (col + 1) > middle) {
                row--;
            }
            else {
                col++;
                result += row + 1;
            }
        }
        return result;
    }
}