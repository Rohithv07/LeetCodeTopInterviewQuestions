Given an integer array nums, handle multiple queries of the following types:

Update the value of an element in nums.
Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
void update(int index, int val) Updates the value of nums[index] to be val.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 

Example 1:

Input
["NumArray", "sumRange", "update", "sumRange"]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
Output
[null, 9, null, 8]

Explanation
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
numArray.update(1, 2);   // nums = [1, 2, 5]
numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
 

Constraints:

1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
0 <= index < nums.length
-100 <= val <= 100
0 <= left <= right < nums.length
At most 3 * 104 calls will be made to update and sumRange.

class NumArray {

    private int [] tree;
    private int n;
    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int [n * 2];
        buildTree(nums);
    }
    
    public void update(int index, int val) {
        for (tree[index += n] = val; index>0; index>>=1) {
            tree[index >> 1] = tree[index] + tree[index ^ 1];
        }
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        for (left+=n, right+=n; left<=right; left >>= 1, right >>= 1) {
            if ((left & 1) == 1)
                sum += tree[left++];
            if ((right & 1) == 0)
                sum += tree[right --];
        }
        return sum;
    }
    
    private void buildTree(int [] nums) {
        for (int i=n; i< n << 1; i++) {
            tree[i] = nums[i - n];
        }
        for (int i=n-1; i>0; i--) {
            tree[i] = tree[i << 1] + tree[i << 1 | 1];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */