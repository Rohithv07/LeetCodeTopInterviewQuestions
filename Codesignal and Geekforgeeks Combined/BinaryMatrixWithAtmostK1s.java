Given a binary matrix M with R rows and C columns, where each element of the matrix will be 0 or 1. Find the largest square that can be formed with center (i, j) and contains atmost K 1’s. There are Q queries, a single query has two integers denoting the centre (i,j) of the square.

 

Example 1:

Input:
R = 4, C = 5
M = {{1, 0, 1, 0, 0} 
     {1, 0, 1, 1, 1} 
     {1, 1, 1, 1, 1} 
     {1, 0, 0, 1, 0}}
K = 9, Q = 1
q_i[] = {1}
q_j[] = {2}
Output:
3
Explanation:
Maximum length square with center
at (1, 2) that can be formed is of
3 length from (0, 1) to (2, 4).
Example 2:
Input:
R = 3, C = 3
M = {{1, 1, 1} 
     {1, 1, 1} 
     {1, 1, 1}}
K = 9, Q = 2
q_i[] = {1, 2}
q_j[] = {1, 2}
Output :
3 1

Your Task:  
You don't need to read input or print anything. Your task is to complete the function largestSquare() which takes 2 integers R, and C followed by a list of lists M denoting the binary matrix and then three integers i,j, and K as input and returns a list of integers denting the largest Square possible for each query.


Expected Time Complexity: O(R*C + Q*log(MIN_DIST)), where MIN_DIST is the minimum distance of the center from the edges of the matrix where MIN_DIST is the minimum distance of the center from the edges of the matrix.
Expected Auxiliary Space: O(R*C)


Constraints:
1 ≤ R,C ≤ 500
1 ≤ Q ≤ 104
0 ≤ K ≤ R*C
0 ≤ i < R
0 ≤ j < C




//User function Template for Java

class Solution {
    static ArrayList<Integer> largestSquare(ArrayList<ArrayList<Integer>> m, int r, int c, int k, int q, int[] q_i, int[] q_j) {
        // code here
        int [][] sum = new int [r][c];
        for (int i = 0; i < r; i++) {
            sum[i][0] = m.get(i).get(0);
            for (int j = 1; j < c; j++) {
                sum[i][j] = sum[i][j - 1] + m.get(i).get(j);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int onesCount = findSquare(q_i[i], q_j[i], sum, r, c, k);
            result.add(onesCount);
        }
        return result;
    }
    
    static int findSquare(int sx, int sy, int [][]sum, int r, int c, int k) {
        int maxSquare = 0;
        int i = 0;
        while (boundaryCheck(i, sx, sy, r, c)) {
            int x = sx - i;
            int y = sy - i;
            int ones = calculateOnes(x, y, i * 2 + 1, sum);
            if (ones > k) {
                return maxSquare;
            }
            maxSquare = i * 2 + 1;
            i++;
        }
        return maxSquare;
    }
    
    static boolean boundaryCheck(int i, int sx, int sy, int r, int c) {
        if (sx + i >= r || sy + i >= c || sx - i < 0 || sy - i < 0) {
            return false;
        }
        return true;
    }
    
    static int calculateOnes(int x, int y, int n, int [][] sum) {
        int ones = 0;
        for (int i = x; i < x + n; i++) {
            ones += sum[i][y + n - 1] - (y - 1 >= 0 ? sum[i][y - 1] : 0);
        }
        return ones;
    }
}