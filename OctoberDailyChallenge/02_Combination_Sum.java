Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
Example 4:

Input: candidates = [1], target = 1
Output: [[1]]
Example 5:

Input: candidates = [1], target = 2
Output: [[1,1]]


Solution:

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(result, current, target, 0, candidates, 0);
        return result;
    }
    public void backtrack(List<List<Integer>> result, List<Integer>current, int target, int start, int [] candidates, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (sum > target)
            return;
        for (int i=start; i<candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(result, current, target, i, candidates, sum+candidates[i]);
            current.remove(current.size()-1);
        }
    }
}
