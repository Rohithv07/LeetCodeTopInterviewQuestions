Good morning,

Today's Byte

This question is asked by Facebook. Given an array of unsorted integers, return the length of its longest increasing subsequence.
Note: You may assume the array will only contain positive numbers.

Ex: Given the following array nums…

nums = [1, 9, 7, 4, 7, 13], return 4.
The longest increasing subsequence is 1, 4, 7, 13.


public int longestSubsequence(int [] nums) {
	if (nums.length == 0)
		return 0;
	if (nums.length == 1)
		return 1;
	// we need a dp array
	int length = nums.length;
	int [] dp = new int [length];
	// fill the array by a value 1 as it will be the minimum value possible
	Arrays.fill(dp, 1);
	for (int i=0; i<length; i++) {
		for (int j=0; j<i; j++) {
			if (nums[i] > nums[j] && dp[i] < dp[j] + 1)
				dp[i] = dp[j] + 1;
		}
	}
	// the maximum will be the answer
	return Arrays.stream(dp).max().getAsInt();
}
