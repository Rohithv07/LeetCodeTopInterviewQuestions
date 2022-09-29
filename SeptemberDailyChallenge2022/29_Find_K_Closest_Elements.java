Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
 

Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        int length = arr.length;
        int left = 0;
        int right = length - k;
        List<Integer> result = new ArrayList<>();
        while (left < right) {
            int middle = (left + right) / 2;
            if (x - arr[middle] > arr[middle + k] - x) {
                left = middle + 1;
            }
            else {
                right = middle;
            }
        }
        for (int i=left; i<left+k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}