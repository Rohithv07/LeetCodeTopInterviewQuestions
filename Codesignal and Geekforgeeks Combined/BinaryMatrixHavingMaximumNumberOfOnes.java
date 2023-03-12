// https://practice.geeksforgeeks.org/contest/interview-series-swiggy-5352/problems/



// optmised O(n)

class Solution {
    public int[] findMaxRow(int mat[][], int n) {
        // code here
        int j = n;
        int row = 0;
        int numOnes = 0;
        for (int i = 0; i < n; i++) {
            if (mat[0][i] == 1) {
                j = i;
                numOnes = n - i;
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            if (j < n && mat[i][j] == 0) {
                continue;
            }
            while (j > 0 && mat[i][j - 1] == 1) {
                j--;
                row = i;
                numOnes = n - j;
            }
        }
        return new int []{row, numOnes};
    }
}

// there is also a nlogn approach where we will be applying binary search
// on each row to find the first index of 1 and doing n - index


// brute force O(n ^ 2)
class Solution {
    public int[] findMaxRow(int mat[][], int n) {
        // code here
        int maxIndex = -1;
        int maxNumberOfOnes = 0;
        int currentMax = 0;
        for (int i = 0; i < n; i++) {
            currentMax = 0;
            int j = n - 1;
            while (j >= 0 && mat[i][j] == 1) {
                currentMax++;
                j--;
            }
            if (currentMax > maxNumberOfOnes) {
                maxNumberOfOnes = currentMax;
                maxIndex = i;
            }
            else if (currentMax == maxNumberOfOnes) {
                if (maxIndex > i) {
                    maxIndex = i;
                }
            }
        }
        return new int [] {maxIndex, maxNumberOfOnes};
    }
}




class Solution {
    public int[] findMaxRow(int mat[][], int n) {
        // code here
        int [] result = new int [2];
        int rowNum = 0;
        int maxCount = 0;
        int i = 0;
        int j = n - 1;
        while (i < n && j >= 0) {
            if (mat[i][j] == 1) {
                rowNum = i;
                maxCount++;
                j--;
            }
            else {
                i++;
            }
        }
        result[0] = rowNum;
        result[1] = maxCount;
        return result;
    }
}