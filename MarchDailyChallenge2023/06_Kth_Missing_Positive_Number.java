Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.

 

Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 

Constraints:

1 <= arr.length <= 1000
1 <= arr[i] <= 1000
1 <= k <= 1000
arr[i] < arr[j] for 1 <= i < j <= arr.length
 

Follow up:

Could you solve this problem in less than O(n) complexity? (binary search)


class Solution {
    public int findKthPositive(int[] arr, int k) {
        int length = arr.length;
        boolean [] isPresent = new boolean [10001];
        for (int i = 0; i < length; i++) {
            int num = arr[i];
            isPresent[num] = true;
        }
        for (int i = 1; i <= 10000; i++) {
            if (k != 1 && !isPresent[i]) {
                k--;
                isPresent[i] = true;
            }
            else if (k == 1 && !isPresent[i]) {
                return i;
            }
        }
        return 1001;
    }
}