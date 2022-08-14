// https://practice.geeksforgeeks.org/contest/interview-series-63/problems/

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
        
