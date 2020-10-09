This question is asked by Apple. Given a list of positive numbers without duplicates and a target number, find all unique combinations of the numbers that sum to the target. Note: You may use the same number more than once.

Ex: Given the following numbers and target…

numbers = [2,4,6,3], target = 6,
return [
    [2,2,2],
    [2,4],
    [3,3],
    [6]
]


// take 2 and keep on incrementing if its < 6, if it == 6, then store all the possible values.
// then same way take 4, then just look if we increment with same 4, we have 6 or < 6, but not possible, so we can check is there any number inside the array.
// we see 2, so 4, 2
// next 3, we again increment by 3, so we get 6, so 3, 3
// now 6 only = target. So these are the answer.
// this these steps will take more time and very difficult to keep track of the sums and possible combinations.

// so we can do a backtracking, where we backtrack whenever we see a sum > target and add it into the final result if sum == target.
// until these we can keep on going through array and see whether we can get a target as given.

// time complexity = O(k * 2 ^ target)
public class Solution {
	public List<List<Integer>> combinationSum(int [] candidates, int target) {
		// this is for storing the result
		List<List<Integer>> result = new ArrayList<>();
		// now we need to keep track of the current numbers that will be equal to target
		List<Integer> current = new ArrayList<>();
		// now we call the backtracking function
		backtrack(result, current, target, 0, candidates, 0); // we pass result, current, target, currentIndex, array, currentSum
		return result;
	}	
	public void backtrack(List<List<Integer>> result, List<Integer> current, int target, int start, int [] candidates, int sum) {
		// we got a sum greater than our target, then just return
		if (sum > target)
			return;
		// if we got a sum == target, then add the current list into the result. This is our goal
		if (sum == target) {
			result.add(new ArrayList(current));
			return;
		}
		// now lets move through the given array and repeat the backtrack to get all possible combination
		for (int i=start; i<candidates.length; i++) {
			// add the current value into the current list	. This is our choice		
			current.add(candidates[i]);
			// do the backtracking with the index i, sum+candidates[i] and update current
			backtrack(result, current, target, i, candidates, sum+candidates[i]);
			// now undo our last choice
			current.remove(current.size()-1);
		}
	}
}



// sample explanation taken from discuusion section for time complexity

Let's consider the set [1, 2, 3] and target 1000. The main purpose is to show possible big gap.

Question #1: How many 1s do you need to get 1000?
Answer is 1000, i.e. target, i.e. k.

Question #2: How many combinations of 1,2,3 could you get with no possible duplicates and without matter of order?
Answer is C(3,1) + C(3,2) + C(3,3) = 3 + 3 + 1. Like [1,2,3, 12,13,23, 123]

Question #3: Q2 + with duplicates but with small target
C(3,1) * target/1 + C(3,2) * target/2 + C(3,3) * target/3

Question #4: Q3 + large target
target * (C(3,1) * target/1 + C(3,2) * target/2 + C(3,3) * target/3)

So, complexity of combinations series by itself is O(2^n) and in our current case O(k * 2^n)
And it can be made O(k) (target) times (not amortized with target/n)


