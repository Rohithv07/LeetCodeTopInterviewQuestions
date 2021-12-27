Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

 

Example 1:


Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 

Constraints:

1 <= k <= points.length <= 104
-104 < xi, yi < 104



class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0) {
            return new int [][]{};
        }
        int length = points.length;
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int middle = partition(points, low, high);
            if (middle == k) {
                break;
            }
            if (middle < k) {
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, k);
    }
    
    public int partition(int [][] points, int low, int high) {
        int [] part = points[low];
        while (low < high) {
            while (low < high && compare(points[high], part) >= 0) {
                high--;
            }
            points[low] = points[high];
            while (low < high && compare(points[low], part) <= 0) {
                low++;
            }
            points[high] = points[low];
        }
        points[low] = part;
        return low;
    }
    
    public int compare(int [] p1, int [] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}