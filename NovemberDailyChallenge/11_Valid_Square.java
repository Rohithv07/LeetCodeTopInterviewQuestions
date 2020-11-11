


Given the coordinates of four points in 2D space, return whether the four points could construct a square.

The coordinate (x,y) of a point is represented by an integer array with two integers.

Example:

Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: True
 

Note:

All the input integers are in the range [-10000, 10000].
A valid square has four equal sides with positive length and four equal angles (90-degree angles).
Input points have no order.class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int d1 = getDist(p1, p2);
        if (d1 == 0 || d1 != getDist(p3, p4)) return false;
        int d2 = getDist(p1, p3);
        if (d2 == 0 || d2 != getDist(p2, p4)) return false;
        int d3 = getDist(p1, p4);
        if (d3 == 0 || d3 != getDist(p2, p3)) return false;
        if (d1 == d2 || d1 == d3 || d2 == d3) return true;
        return false;
    }
    
    private int getDist(int [] p1, int [] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
