Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)

We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.

(Note also that a translation does not include any kind of rotation.)

What is the largest possible overlap?

Example 1:

Input: A = [[1,1,0],
            [0,1,0],
            [0,1,0]]
       B = [[0,0,0],
            [0,1,1],
            [0,0,1]]
Output: 3
Explanation: We slide A to right by 1 unit and down by 1 unit.
Notes: 

1 <= A.length = A[0].length = B.length = B[0].length <= 30
0 <= A[i][j], B[i][j] <= 1


Solution:

class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int length = A.length;
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> A1 = new ArrayList<>();
        List<Integer> B1 = new ArrayList<>();
        for (int i=0; i<length * length; i++) {
            if (A[i/length][i%length] == 1)
                A1.add(i/length*100 + i%length);
        }
        for (int i=0; i<length * length; i++) {
            if (B[i/length][i%length] == 1)
                B1.add(i/length*100 + i%length);
        }
        for (int i : A1) for (int j : B1)
                count.put(i - j, count.getOrDefault(i - j, 0) + 1);
        int result = 0;
        for (int i: count.values())
            result = Math.max(result, i);
        return result;
    }
}
