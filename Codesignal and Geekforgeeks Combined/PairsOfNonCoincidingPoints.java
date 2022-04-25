In a given cartesian plane, there are N points. We need to find the Number of Pairs of  points(A, B) such that

Point A and Point B do not coincide.
Manhattan Distance and the Euclidean Distance between the points should be equal.
Note: Pair of 2 points(A,B) is considered same as Pair of 2 points(B ,A).
Manhattan Distance = |x2-x1|+|y2-y1|
Euclidean Distance   = ((x2-x1)^2 + (y2-y1)^2)^0.5, where points are (x1,y1) and (x2,y2).

 

Example 1:

Input:
N = 2
X = {1, 7}
Y = {1, 5}
Output:
0
Explanation:
None of the pairs of points have
equal Manhatten and Euclidean distance.
Example 2:

Input:
N = 3
X = {1, 2, 1}
Y = {2, 3, 3}
Output:
2
Explanation:
The pairs {(1,2), (1,3)}, and {(1,3), (2,3)}
have equal Manhatten and Euclidean distance.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function numOfPairs() which takes an Integer N and two arrays X, and Y of length N as input and returns the number of pairs with equal Manhattan and Euclidean Distance. (X[i], Y[i]) denotes a point.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1 <= N <= 105
 -10^9 <= X[i], Y[i] <= 10^9


class Solution {
    static int numOfPairs(int[] X, int[] Y, int N) {
        // code here
        Map<Integer, Integer> xCount = new HashMap<>();
        Map<Integer, Integer> yCount = new HashMap<>();
        Map<ArrayList<Integer>, Integer> visited = new HashMap<>();
        int cnt1=0, cnt2=0, cnt3=0;
        for(int i=0;i<N;i++){
            cnt1+=xCount.getOrDefault(X[i], 0);
            xCount.put(X[i], xCount.getOrDefault(X[i],0)+1);
            
            cnt2+=yCount.getOrDefault(Y[i], 0);
            yCount.put(Y[i], yCount.getOrDefault(Y[i], 0)+1);
            
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(X[i], Y[i]));
            cnt3+=visited.getOrDefault(list, 0);
            visited.put(list, visited.getOrDefault(list, 0)+1);
        }
        return cnt1+cnt2-(2*cnt3);
    }
};