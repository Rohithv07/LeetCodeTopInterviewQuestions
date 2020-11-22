This question is asked by Facebook. Given N points on a Cartesian plane, return the minimum time required to visit all points in the order that they’re given.
Note: You start at the first point and can move one unit vertically, horizontally, or diagonally in a single second.

Ex: Given the following points…

points = [[0, 0], [1,1], [2,2]], return 2.
In one second we can travel from [0, 0] to [1, 1]
In another second we can travel from [1, 1,] to [2, 2]
Ex: Given the following points…

points = [[0, 1], [2, 3], [4, 0]], return 5.



// here the theory is minimum time to connect all points is the max(x1-x2, y1-y2) summig up with all the points

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int minimumTime = 0;
        int row = points.length;
        for (int i=1; i<row; i++) {
            int [] currentPoint = points[i];
            int [] previousPoint = points[i-1];
            int x1 = previousPoint[0];
            int y1 = previousPoint[1];
            int x2 = currentPoint[0];
            int y2 = currentPoint[1];
            // our answer is the max(x1-x2, y1-y2)
            minimumTime += Math.max(Math.abs(x1-x2), Math.abs(y1-y2));
        }
        return minimumTime;
    }
}
