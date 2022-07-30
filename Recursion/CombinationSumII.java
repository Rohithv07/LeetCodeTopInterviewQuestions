// https://leetcode.com/problems/combination-sum-ii

// https://www.youtube.com/watch?v=G1fRTGRxXU8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=9

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
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
        // after sorting we don't care from where we start, we can just make sure we don't end up taking duplicate answer
        for (int i = index; i < candidates.length; i++) {
            // skips the duplicates
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            current.add(candidates[i]);
            target -= candidates[i];
            backtrack(result, current, i + 1, target, candidates);
            current.remove(current.size() - 1);
            target += candidates[i];
        }
    }
}