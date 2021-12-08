Given a row wise sorted matrix of size RxC where R and C are always odd, find the median of the matrix.

Example 1:

Input:
R = 3, C = 3
M = [[1, 3, 5], 
     [2, 6, 9], 
     [3, 6, 9]]

Output: 5

Explanation:
Sorting matrix elements gives us 
{1,2,3,3,5,6,6,9,9}. Hence, 5 is median. 
 

Example 2:

Input:
R = 3, C = 1
M = [[1], [2], [3]]
Output: 2

Your Task:  
You don't need to read input or print anything. Your task is to complete the function median() which takes the integers R and C along with the 2D matrix as input parameters and returns the median of the matrix.

Expected Time Complexity: O(32 * R * log(C))
Expected Auxiliary Space: O(1)


Constraints:
1<= R,C <=150
1<= matrix[i][j] <=2000

// optimised using 2 binary search : https://www.youtube.com/watch?v=63fPPOdIr2c&list=PLgUwDviBIf0p4ozDR_kJJkO Nnb1wdx2Ma&index=62


//User function Template for Java

// 32 * r * logc

class Solution {
    int median(int matrix[][], int r, int c) {
        // code here      
        int low = 0;
        int high = 2001; // this is selected as per the constraint. we can also take 1e9
        while (low <= high) {
            int middle = low + (high - low) / 2;
            int countOfNumberLessThanEqualMiddle = 0;
            for (int i=0; i<r; i++) {
                countOfNumberLessThanEqualMiddle += findCount(matrix[i], middle);
            }
            if (countOfNumberLessThanEqualMiddle <= r * c / 2) {
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        return low;
    }
    
    private int findCount(int [] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] <= target) {
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        return low;
    }
}


// not optimised approach but passes the test cases
// just created 2 arrays and sorted
// then just applied the concept of median of 2 sorted array

class Solution {
    int median(int matrix[][], int r, int c) {
        // code here  
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int [] nums1 = matrix[0];
        int [] nums2 = new int[(r - 1) * c];
        int index = 0;
        for (int i=1; i<r; i++) {
            for (int j=0; j<c; j++) {
                nums2[index++] = matrix[i][j];
            }
        }
        return findMedianOfTwoSortedArrays(nums1, nums2);
    }
    
    int findMedianOfTwoSortedArrays(int [] nums1, int [] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if (nums1.length > nums2.length) {
            return findMedianOfTwoSortedArrays(nums2, nums1);
        }
        int length1 = nums1.length;
        int length2 = nums2.length;
        int left = 0;
        int right = length1;
        while (left <= right) {
            int cut1 = left + (right - left) / 2;
            int cut2 = ((length1 + length2 + 1) / 2) - cut1;
            int leftPart1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int leftPart2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int rightPart1 = cut1 == length1 ? Integer.MAX_VALUE : nums1[cut1];
            int rightPart2 = cut2 == length2 ? Integer.MAX_VALUE : nums2[cut2];
            if (leftPart1 <= rightPart2 && leftPart2 <= rightPart1) {
                if ((length1 + length2) % 2 == 0) {
                    return (Math.max(leftPart1, leftPart2) + Math.min(rightPart1, rightPart2)) / 2;
                }
                else {
                    return Math.max(leftPart1, leftPart2);
                }
            }
            if (leftPart1 > rightPart2) {
                right = cut1 - 1;
            }
            else {
                left = cut1 + 1;
            }
        }
        return 0;
    }
}