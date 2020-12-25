Given a matrix M of n*n size, the task is to complete the function which prints its elements in diagonal pattern as depicted below.



Example 1:

Input:
N = 3
mat[][] = {{1 2 3},{4 5 6},{7 8 9}}
Output: 1 2 4 7 5 3 6 8 9
Example 2:

Input:
N = 2
mat[][] = {{1 2},{3 4}}
Output: 1 2 3 4
Your Task:
You only need to implement the given function matrixDiagonally() which returns a list containing the matrix diagonally.. Do not read input, instead use the arguments given in the function. Print the elements in Matrix in diagonal pattern.

Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(1)
Constraints:
0<=N<=20

Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.


class GfG
{
    /*You are required to complete this method */
    ArrayList<Integer> matrixDiagonally(int matrix[][], int n)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (n == 0)
            return result;
        int r = 0;
        int c = 0;
        for (int i=0; i<n*n; i++) {
            result.add(matrix[r][c]);
            if ((r + c) % 2 == 0) {
                if (c == n - 1)
                    r++;
                else if (r == 0)
                    c++;
                else {
                    r--;
                    c++;
                }
            }
            else {
                if (r == n - 1)
                    c++;
                else if (c == 0)
                    r++;
                else {
                    r++;
                    c--;
                }
            }
        }
        return result;
    }

}
