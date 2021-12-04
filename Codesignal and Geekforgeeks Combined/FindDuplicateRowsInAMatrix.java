Given a boolean matrix of size RxC where each cell contains either 0 or 1, find the row numbers of row (0-based) which already exists or are repeated.

Example 1:

Input:
R = 2, C = 2
matrix[][] = {{1, 0},
              {1, 0}}
Output: 
1
Explanation:
Row 1 is duplicate of Row 0.

Example 2:

Input:
R = 4, C = 3
matrix[][] = {{ 1, 0, 0},
              { 1, 0, 0},
              { 1, 0, 0},
              { 0, 0, 0}}
Output: 
1 2 
Explanation:
Row 1 and Row 2 are duplicates of Row 0. 

Your Task:
You dont need to read input or print anything. Complete the function repeatedRows() that takes the matrix as input parameter and returns a list of row numbers which are duplicate rows.
 

Expected Time Complexity: O(R * C)
Expected Auxiliary Space: O(R*C) 
 

Constraints:
1 ≤ R ≤ 1000
1 ≤ C ≤ 20
0 ≤ matrix[i][j] ≤ 1


// straightforward approach, can be done using trie


//User function Template for Java

class Solution
{
    public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n)
    {
        //code here
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i=0; i<m; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("*");
            for (int j=0; j<n; j++) {
                sb.append(matrix[i][j]);
            }
            sb.append("*");
            if (set.contains(sb.toString())) {
                result.add(i);
            }
            else {
                set.add(sb.toString());
            }
        }
        return result;
    }
}