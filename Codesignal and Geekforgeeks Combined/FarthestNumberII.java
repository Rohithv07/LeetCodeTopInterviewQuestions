// https://practice.geeksforgeeks.org/contest/interview-series-61/problems/#

// https://www.youtube.com/watch?v=F-lpfJSHyI4


class Solution {
    public static ArrayList<Integer> farNumber(int n, int[] a) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(-1);
            return result;
        }
        int [] store = new int [n];
        int [] suffixMin = new int [n];
        // we compute the suffix min and from each index i from array a, we just
        // do binary search on suffix min to find the farthest element which is 
        // smaller than a[i]
        suffixMin[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], a[i]);
            //System.out.print(suffixMin[i] + " ");
        }
        for (int i = 0; i < n; i++) {
            int currentElement = a[i];
            int farthestSmallerIndex = findIndex(suffixMin, n, currentElement, i);
            result.add(farthestSmallerIndex);
        }
        return result;
    }
    
    private static int findIndex(int [] suffixMin, int n, int currentElement, int i) {
        int index = -1;
        int low = i;
        int high = n - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (suffixMin[middle] < currentElement) {
                index = middle;
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        return index;
    }
}
        
