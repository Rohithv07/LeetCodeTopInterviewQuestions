Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example:

Given the following matrix:

[
    [ 1, 2, 3 ],
    [ 4, 5, 6 ],
    [ 7, 8, 9 ]
]
You should return

[1, 2, 3, 6, 9, 8, 7, 4, 5]



public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] spiralOrder(final int[][] A) {
        List<Integer> output = new ArrayList<>();
        if (A.length == 0 || A[0].length == 0)
            return new int [0];
        int m = A.length;
        int n = A[0].length;
        int lowCol = 0;
        int lowRow = 0;
        int highCol = n - 1;
        int highRow = m - 1;
        while (lowRow<=highRow && lowCol <= highCol) {
            for (int i=lowRow; i<=highCol; i++)
                output.add(A[lowRow][i]);
            lowRow += 1;
            for (int i=lowRow; i<=highRow; i++)
                output.add(A[i][highCol]);
            highCol -= 1;
            if (lowRow <= highRow) {
                for (int i=highCol; i>=lowCol; i--)
                    output.add(A[highRow][i]);
                highRow -= 1;
            }
            if (lowCol <= highCol) {
                for (int i=highRow; i>=lowRow; i--)
                    output.add(A[i][lowCol]);
                lowCol += 1;
            }
        }
        int [] result = new int [output.size()];
        for (int i=0; i<output.size(); i++)
            result[i] = output.get(i);
        return result;
    }
}

