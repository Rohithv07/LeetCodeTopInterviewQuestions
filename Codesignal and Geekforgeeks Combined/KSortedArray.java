Given an array of n distinct elements. Check whether the given array is a k sorted array or not. A k sorted array is an array where each element is at most k distance away from its target position in the sorted array.


Example 1:

Input:
N=6
arr[] = {3, 2, 1, 5, 6, 4} 
K = 2
Output: Yes
Explanation:
Every element is at most 2 distance 
away from its target position in the
sorted array.  
Example 2:

Input:
N=7
arr[] = {13, 8, 10, 7, 15, 14, 12}
K = 1
Output: No

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function isKSortedArray() that takes array arr, integer n and integer k as parameters and return "Yes" if the array is a k sorted array else return "No".


Expected Time Complexity: O(NlogN).
Expected Auxiliary Space: O(N).


Constraints:
1 ≤ N ≤ 105
0 ≤ K ≤ N


class Solution
{ 
    static String isKSortedArray(int arr[], int n, int k) 
    { 
        // code here
        if (arr == null || n == 0 || k < 0)
            return "No";
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            map.put(arr[i], i);
        }
        Arrays.sort(arr);
        for (int i=0; i<n; i++) {
            int currentNumber = arr[i];
            if (Math.abs(i - map.get(currentNumber)) <= k)
                continue;
            return "No";
        }
        return "Yes";
        
        // using binary search
        int [] another = new int [n];
        for (int i=0; i<n; i++) {
            another[i] = arr[i];
        }
        Arrays.sort(another);
        for (int i=0; i<n; i++) {
            int index = binarySearch(another, n, arr[i]);
            if (Math.abs(index - i) <= k)
                continue;
            return "No";
        }
        return "Yes";
    }
    
    public static int binarySearch(int another[], int n, int key) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (another[middle] == key) {
                return middle;
            }
            if (another[middle] > key) {
                high = middle - 1;
            }
            else {
                low = middle + 1;
            }
        }
        return -1;
    }

}
