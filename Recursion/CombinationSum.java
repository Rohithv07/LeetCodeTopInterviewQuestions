// https://leetcode.com/problems/combination-sum

// https://www.youtube.com/watch?v=OyZFFqQtu98&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=8

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(result, current, 0, target, candidates);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> current, int index, int target, int [] candidates) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (index >= candidates.length || target < 0) {
            return;
        }
        // picking 
        current.add(candidates[index]);
        target -= candidates[index];
        backtrack(result, current, index, target, candidates);
        current.remove(current.size() - 1);
        target += candidates[index];
        // not picking, move index
        backtrack(result, current, index + 1, target, candidates);
    }
}