Given an NxM 2D matrix, rearrange such that 
Each diagonal in the lower left triangle of the rectangular grid is sorted in ascending order. 
Each diagonal in the upper right triangle of the rectangular grid is sorted in descending order. 
The major diagonal in the grid starting from the top-left corner is not rearranged. 


Example 1:

Input:
N = 4, M = 5 
matrix = {{3 6 3 8 2},
          {4 1 9 5 9},
          {5 7 2 4 8},
          {8 3 1 7 6}}
Output:
3 9 8 9 2
1 1 6 5 8
3 4 2 6 3
8 5 7 7 4
Explanation:
Before:

After:

Your Task:
You don't need to read input or print anything. Your task is to complete the function diagonalSort() which takes the matrix, n and m as input parameter and rearranges the elements of the matrix.


Expected Time Complexity: O(NxM)
Expected Auxiliary Space: O(N+M)


Constraints:
1 <= N,M <= 104 , 1<=N*M<=105
1 <= matrix[i] <= 103






class Solution
{
    void diagonalSort(int matrix[][], int n, int m)
    {
        // code here 
        for (int i=1; i<m; i++) {
            List<Integer> current = new ArrayList<>();
            int j = 0;
            int k = i;
            int index = 0;
            while (j < n && k < m) {
                current.add(matrix[j++][k++]);
            }
            Collections.sort(current, (a, b) -> Integer.compare(b, a));
            j = 0;
            k = i;
            while (j < n && k < m) {
                matrix[j++][k++] = current.get(index++);
            }
        }
        for (int i=1; i<n; i++) {
            List<Integer> current = new ArrayList<>();
            int j = i;
            int k = 0;
            int index = 0;
            while (j < n && k < m) {
                current.add(matrix[j++][k++]);
            }
            Collections.sort(current);
            j = i;
            k = 0;
            while (j < n && k < m) {
                matrix[j++][k++] = current.get(index++);
            }
        }
    }
}