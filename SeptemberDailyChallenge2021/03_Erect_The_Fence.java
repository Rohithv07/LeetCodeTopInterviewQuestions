You are given an array trees where trees[i] = [xi, yi] represents the location of a tree in the garden.

You are asked to fence the entire garden using the minimum length of rope as it is expensive. The garden is well fenced only if all the trees are enclosed.

Return the coordinates of trees that are exactly located on the fence perimeter.

 

Example 1:


Input: points = [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
Output: [[1,1],[2,0],[3,3],[2,4],[4,2]]
Example 2:


Input: points = [[1,2],[2,2],[4,2]]
Output: [[4,2],[2,2],[1,2]]
 

Constraints:

1 <= points.length <= 3000
points[i].length == 2
0 <= xi, yi <= 100
All the given points are unique.


class Solution {
    // Monotone chain convex hull
    // Time O(NlogN)  Space O(N)
    public int[][] outerTrees(int[][] points) {
        // sort the point of P by x-coor (case tie, sort by y-coor)
        Arrays.sort(points, (p,q) -> q[0] == p[0]? q[1] - p[1] : q[0] - p[0]);
        
        // hold the vertices of upper and lower hulls 
        Stack<int[]> hull = new Stack<>();
        int n = points.length;
        
        // A. Build Lower layer of hulls
        for (int i = 0; i < n; i++) {
            // sequence of last two points of Lower hulls 
            // and the point P[i] does not make a counter-clockwise turn
            while (hull.size() >= 2  &&
             orientation(hull.get(hull.size()-2), hull.get(hull.size() - 1), points[i]) > 0) {
                hull.pop();             // remove q on (p,q,r)
            }
            hull.push(points[i]);
        }
        hull.pop();     
       
        // B. Build uper layer of hulls
        for (int i = n - 1; i >= 0; i--) {
            while (hull.size() >= 2 &&
             orientation(hull.get(hull.size() - 2), hull.get(hull.size() -1), points[i]) > 0) {
                hull.pop();
            } 
            hull.push(points[i]);
        }
        // Remove last point of list (it's same as first point of  other list).
        // remove redundant elements from the stack
        HashSet<int[]> set = new HashSet<>(hull);
        return set.toArray(new int[set.size()][]);
    }
    public int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0])  - (q[0] - p[0])*(r[1] - q[1]);
        
        //            q()
        //          /     \   
        //        /         \
        //     p()            \        
        //                     r()
        //
        // (q[1] - p[1]) / (q[0] - p[0])   vs  (r[1] - q[1]) / (r[0] - q[0])
    }
}

/**
https://algorithmist.com/wiki/Monotone_chain_convex_hull

Input: a list P of points in the plane.

Sort the points of P by x-coordinate (in case of a tie, sort by y-coordinate).

Initialize U and L as empty lists.
The lists will hold the vertices of upper and lower hulls respectively.

for i = 1, 2, ..., n:
    while L contains at least two points and the sequence of last two points
            of L and the point P[i] does not make a counter-clockwise turn:
        remove the last point from L
    append P[i] to L

for i = n, n-1, ..., 1:
    while U contains at least two points and the sequence of last two points
            of U and the point P[i] does not make a counter-clockwise turn:
        remove the last point from U
    append P[i] to U

Remove the last point of each list (it's the same as the first point of the other list).
Concatenate L and U to obtain the convex hull of P.
Points in the result will be listed in counter-clockwise order.

**/