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
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int length = nums.length;
        List<Integer> result = new ArrayList<>();
        int [] track = new int [length];
        Pair[] pair = new Pair[length];
        for (int i = 0; i < length; i++) {
            pair[i] = new Pair(nums[i], i);
        }
        mergesort(pair, 0, length - 1, track);
        // for (Pair p : pair) {
        //     System.out.println(p.value);
        // }
        for (int num : track) {
            result.add(num);
        }
        return result;
    }
    
    private void mergesort(Pair [] pair, int low, int high, int [] track) {
        if (low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        mergesort(pair, low, middle, track);
        mergesort(pair, middle + 1, high, track);
        merge(pair, low, middle, high, track);
    }
    
    private void merge(Pair [] pair, int low, int middle, int high, int [] track) {
        int i = low;
        int j = middle + 1;
        int k = 0;
        int count = 0;
        Pair [] temp = new Pair [high - low + 1];
        while (i <= middle && j <= high) {
            if (pair[i].value <= pair[j].value) {
                track[pair[i].index] += count;
                temp[k++] = pair[i++];
            }
            else {
                count++;
                temp[k++] = pair[j++];
            }
        }
        while (i <= middle) {
            track[pair[i].index] += count;
            temp[k++] = pair[i++];
        }
        while (j <= high) {
            temp[k++] = pair[j++];
        }
        for (int p = low; p <= high; p++) {
            pair[p] = temp[p - low];
        }
    }
}

class Pair {
    int value;
    int index;
    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}