/*
Given a set of points, where each element is an integer array containing an x and y value, return whether or not all the points exist on the same line.

Ex: Given the following points…

points = [[1, 2], [3, 2]], return true.
Ex: Given the following points...

points = [[1, 2], [3, 2], [-1, -1]], return false.
*/

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length == 0)
            return false;
        int x = coordinates[0][0];
        int y = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];
        int diffX = x1 - x;
        int diffY = y1 - y;
        for (int [] cord : coordinates) {
            int currentX = cord[0];
            int currentY = cord[1];
            if (diffX * (currentY - y1) != diffY * (currentX - x1))
                return false;
        }
        return true;
    }
}