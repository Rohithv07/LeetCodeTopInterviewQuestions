Given a matrix mat[][] of size N x M, where every row and column is sorted in increasing order, and a number X is given. The task is to find whether element X is present in the matrix or not.


Example 1:

Input:
N = 3, M = 3
mat[][] = 3 30 38 
         44 52 54 
         57 60 69
X = 62
Output:
0
Explanation:
62 is not present in the
matrix, so output is 0

Example 2:

Input:
N = 1, M = 6
mat[][] = 18 21 27 38 55 67
X = 55
Output:
1
Explanation:
55 is present in the
matrix at 5th cell.

Your Task:
You don't need to read input or print anything. You just have to complete the function matSearch() which takes a 2D matrix mat[][], its dimensions N and M and integer X as inputs and returns 1 if the element X is present in the matrix and 0 otherwise.


Expected Time Complexity: O(N+M).
Expected Auxiliary Space: O(1).


Constraints:
1 <= N, M <= 1005
1 <= mat[][] <= 10000000
1<= X <= 10000000


class Sol
{
    public static int matSearch(int mat[][], int n, int m, int target)
    {
        // your code here
        if (mat == null || mat.length == 0) {
            return 0;
        }
        int low = n - 1;
        int high = 0;
        while (low >= 0 && high < m) {
            if (mat[low][high] == target) {
                return 1;
            }
            else if (mat[low][high] > target) {
                low--;
            }
            else {
                high++;
            }
        }
        return 0;
        
    }
}