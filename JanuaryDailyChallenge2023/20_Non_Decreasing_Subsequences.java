Given an integer array nums, return all the different possible non-decreasing subsequences of the given array with at least two elements. You may return the answer in any order.

 

Example 1:

Input: nums = [4,6,7,7]
Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
Example 2:

Input: nums = [4,4,3,2,1]
Output: [[4,4]]
 

Constraints:

1 <= nums.length <= 15
-100 <= nums[i] <= 100


class Solution {
    Set<List<Integer>> lists;
    public List<List<Integer>> findSubsequences(int[] nums) {
        lists = new HashSet<>();
        recursion(nums,0,new ArrayList());
        
        return new ArrayList(lists);
    }
    void recursion(int[] nums,int curr,List<Integer> temp)
    {
        if(temp.size() >= 2)
            lists.add(new ArrayList(temp));
            
        for(int i=curr;i<nums.length;i++)
        {
            if(temp.size()==0 || temp.get(temp.size()-1) <= nums[i])
            {
                temp.add(nums[i]);
                recursion(nums,i+1,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}