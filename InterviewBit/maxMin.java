/*public class Solution {
    public int solve(int[] A) {
        if (A.length == 0)
            return 0;
        if (A.length == 1)
            return A[0];
        Arrays.sort(A);
        return A[0] + A[A.length-1];
    }
}*/
public class Solution {
    public int solve(int [] A) {
        if (A.length == 0)
            return 0;
        if (A.length == 1)
            return A[0];
        int minimum = A[0];
        int maximum = A[0];
        for (int i=1; i<A.length; i++) {
            minimum = Math.min(minimum, A[i]);
            maximum = Math.max(maximum, A[i]);
        }
        return maximum + minimum;
    }
}

