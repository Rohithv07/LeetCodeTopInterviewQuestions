Given two unsorted arrays arr1[] and arr2[]. They may contain duplicates. For each element in arr1[] count elements less than or equal to it in array arr2[].

Example 1:

Input:
m = 6, n = 6
arr1[] = {1,2,3,4,7,9}
arr2[] = {0,1,2,1,1,4}
Output: 4 5 5 6 6 6
Explanation: Number of elements less than
or equal to 1, 2, 3, 4, 7, and 9 in the
second array are respectively 4,5,5,6,6,6
Example 2:

Input:
m = 5, n = 7
arr1[] = {4,8,7,5,1}
arr2[] = {4,48,3,0,1,1,5}
Output: 5 6 6 6 3
Your Task :
Complete the function countEleLessThanOrEqual() that takes two array arr1[], arr2[],  m, and n as input and returns an array containing the required results(the count of elements less than or equal to it in arr2 for each element in arr1 where ith output represents the count for ith element in arr1.)

Expected Time Complexity: O((m + n) * log n).
Expected Auxiliary Space: O(1).

Constraints:
1<=m,n<=10^5
1<=arr1[i],arr2[j]<=10^5


// Complete the function given below
class Solution
{
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
       // add your code here
       ArrayList<Integer> result = new ArrayList<>();
       Arrays.sort(arr2);
       // traverse through the arr1
       // sort arr2
       // from each element on arr1, do binary search on arr2 to find the lesser ekements counts
       for (int i = 0; i < m; i++) {
           int currentNum = arr1[i];
           int count = findCount(0, n - 1, currentNum, arr2);
           result.add(count);
       }
       return result;
    }
    
    private static int findCount(int low, int high, int key, int [] arr2) {
        int count = 0;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr2[middle] <= key) {
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        return low;
    }
}