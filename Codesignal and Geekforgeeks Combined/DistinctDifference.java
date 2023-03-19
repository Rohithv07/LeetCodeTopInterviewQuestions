// https://practice.geeksforgeeks.org/contest/interview-series-63/problems/



Given an array A[] of length N. For each index i (1<=i<=N), find the diffference between the number of distinct element in it's left and right side in the array. 

Example 1:

Input:
N = 3
arr[] = {4, 3, 3}
Output: {-1, 0, 2}
Explanation: For index i=1, there are 0 distinct element in the left side of it, and 1 distinct element(3) in it's right side. So difference is 0-1 = -1. 

Similarly for index i=2, there is 1 distinct element (4) in left side of it, and 1 distinct element(3) in it's right side. So difference is 1-1 = 0.

Similarly for index i=3, there are 2 distinct elements (4 and 3) in left side of it, and 0 distinct elements in it's left side. So difference is 2-0 = 2.

Example 2:

Input:
N = 4
arr[] = {4, 4, 3, 3}
Output: {-2, 0, 0, 2}
Explanation: For index i=1, there are 0 distinct element in the left side of it, and 2 distinct element(4 and 3) in it's right side. So difference is 0-2 = -2.

Similarly for index i=2, there is 1 distinct element (4) in left side of it, and 1 distinct element(3) in it's right side. So difference is 1-1 = 0.

Similarly for index i=4, there are 2 distinct elements (4 and 3) in left side of it, and 0 distinct element in it's right side. So difference is 2-0 = 2.
Your Task: 
You don't need to read input or print anything. Your task is to complete the function getDistinctDifference() which takes the array A[] and its size N as input parameters and returns an array containing the difference between number of ditinct elements in left and right side for each 1<=i<=N.

Expected Time Complexity: O(N)
Expected Space Complexity:O(N)

Constraints:

1 <= N <= 105
1 <= A[i] <= 109
Array may contain duplicate elements.

class Solution {
    public static ArrayList<Integer> getDistinctDifference(int n, int[] a) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int [] leftToRight = new int [n];
        int [] rightToLeft = new int [n];
        leftToRight[0] = 0;
        rightToLeft[n - 1] = 0;
        Set<Integer> distinct = new HashSet<>();
        distinct.add(a[0]);
        for (int i = 1; i < n; i++) {
            int size = distinct.size();
            leftToRight[i] = size;
            distinct.add(a[i]);
        }
        distinct = new HashSet<>();
        distinct.add(a[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            int size = distinct.size();
            rightToLeft[i] = size;
            distinct.add(a[i]);
        }
        for (int i = 0; i < n; i++) {
            int diff = leftToRight[i] - rightToLeft[i];
            result.add(diff);
        }
        return result;
    }
}


class Solution {
    public static ArrayList<Integer> getDistinctDifference(int n, int[] a) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        if (n <= 1 || a == null) {
            return result;
        }
        Set<Integer> rightToLeft = new HashSet<>();
        int [] track = new int [n];
        for (int i = n - 1; i >= 0; i--) {
            track[i] = rightToLeft.size();
            rightToLeft.add(a[i]);
        }
        Set<Integer> leftToRight = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num = a[i];
            int diff = leftToRight.size() - track[i];
            leftToRight.add(num);
            result.add(diff);
        }
        return result;
    }
}

        
