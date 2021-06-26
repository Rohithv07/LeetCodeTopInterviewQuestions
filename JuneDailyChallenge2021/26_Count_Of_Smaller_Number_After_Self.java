You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

 

Example 1:

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Example 2:

Input: nums = [-1]
Output: [0]
Example 3:

Input: nums = [-1,-1]
Output: [0,0]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104


class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] res = new int[nums.length];
        int[] index = new int[res.length];
        for (int i = 0; i < res.length; i++) {
            index[i] = i;
        }
        mergeSort(nums, index, 0, nums.length-1, res);
        List<Integer> list = new LinkedList<>();
        for (int i : res) {
            list.add(i);
        }
        return list;
    }
    
    private void mergeSort(int[] nums, int[] index, int l, int r, int[] res) {
        if (l >= r) {
            return;
        }
        int mid = (l+r)/2;
        mergeSort(nums, index, l, mid, res);
        mergeSort(nums, index, mid+1, r, res);
        merge(nums, index, l, mid, mid+1, r, res);
    }
    
    private void merge(int[] nums, int[] index, int l1, int r1, int l2, int r2, int[] res) {
        int start = l1;
        int[] tmp = new int[r2-l1+1];
        int count = 0;
        int p = 0;
        while (l1 <= r1 || l2 <= r2) {
            if (l1 > r1) {
                tmp[p++] = index[l2++];
            } else if (l2 > r2) {
                res[index[l1]] += count;
                tmp[p++] = index[l1++];
            } else if (nums[index[l1]] > nums[index[l2]]) {
                tmp[p++] = index[l2++];
                count++;
            } else {
                res[index[l1]] += count;
                tmp[p++] = index[l1++];
            }
        }
        for (int i = 0; i < tmp.length; i++) {
            index[start+i] = tmp[i];
        }
    }
}
