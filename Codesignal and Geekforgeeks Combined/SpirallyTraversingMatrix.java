Given a matrix of size r*c. Traverse the matrix in spiral form.

Example 1:

Input:
r = 4, c = 4
matrix[][] = {{1, 2, 3, 4},
           {5, 6, 7, 8},
           {9, 10, 11, 12},
           {13, 14, 15,16}}
Output: 
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
Explanation:

Example 2:

Input:
r = 3, c = 4  
matrix[][] = {{1, 2, 3, 4},
           {5, 6, 7, 8},
           {9, 10, 11, 12}}
Output: 
1 2 3 4 8 12 11 10 9 5 6 7
Explanation:
Applying same technique as shown above, 
output for the 2nd testcase will be 
1 2 3 4 8 12 11 10 9 5 6 7.

Your Task:
You dont need to read input or print anything. Complete the function spirallyTraverse() that takes matrix, r and c as input parameters and returns a list of integers denoting the spiral traversal of matrix. 

Expected Time Complexity: O(r*c)
Expected Auxiliary Space: O(r*c), for returning the answer only.

Constraints:
1 <= r, c <= 100
0 <= matrixi <= 100



class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
        ArrayList<Integer> result = new ArrayList<>();
        if (r == 0 || c == 0)
            return result;
        int lowRow = 0;
        int highRow = r - 1;
        int lowCol = 0;
        int highCol = c - 1;
        while (lowRow <= highRow && lowCol <= highCol) {
            for (int i=lowRow; i<=highCol; i++) {
                result.add(matrix[lowRow][i]);
            }
            lowRow++;
            for (int i=lowRow; i<=highRow; i++) {
                result.add(matrix[i][highCol]);
            }
            highCol--;
            if (lowRow <= highRow) {
                for (int i=highCol; i>=lowCol; i--) {
                    result.add(matrix[highRow][i]);
                }
                highRow--;
            }
            if (lowCol <= highCol) {
                for (int i=highRow; i>=lowRow; i--) {
                    result.add(matrix[i][lowCol]);
                }
                lowCol++;
            }
        }
        return result;
    }
}
