Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]


Solution Python:
class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        li = []
        for element, counter in Counter(nums).items():
            if counter > 1:
                li.append(element)
                
        return li
        

Solution Java:
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> output = new ArrayList();
        for (int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                output.add(index + 1);
            nums[index] = -nums[index];
        }
        return output;
    }
}

// This same can be applied in the python code also.......
