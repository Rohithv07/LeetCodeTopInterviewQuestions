Given an array of integers arr of even length, return true if and only if it is possible to reorder it such that arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2.

 

Example 1:

Input: arr = [3,1,3,6]
Output: false
Example 2:

Input: arr = [2,1,2,6]
Output: false
Example 3:

Input: arr = [4,-2,2,-4]
Output: true
Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
Example 4:

Input: arr = [1,2,4,16,8,4]
Output: false
 

Constraints:

0 <= arr.length <= 3 * 104
arr.length is even.
-105 <= arr[i] <= 105



class Solution {
    public boolean canReorderDoubled(int[] arr) {
        if (arr == null || arr.length == 0) {
            return true;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        for (int number : arr) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 0)
                continue;
            // for negative number we look for x/2 and for positive number we look for x * 2
            int target = key >= 0 ? key * 2 : key / 2;
            if (key < 0 && key % 2 != 0 || map.get(key) > map.getOrDefault(target, 0))
                return false;
            map.put(target, map.get(target) - map.get(key));
        }
        return true;
    }
}