/*
My thought process

Here we can make use of a dp boolean array to store whether we can get the word from the dictionary and combine them to form the required string.

-> We started by creating dp array of size of s + 1.
-> Let the first index be true.
-> Now lets traverse through the dp array and make the necessary changes based on the words inside the dict.
-> If we see a subtring from j to i, inside the inner loop, just update the corresponding ith index of array to true and break and continue with the next one.
-> Finally return the array where the last index will be holding true or false which indicates whether we can actually segmented to space separated sequnce.

*/


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean [] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i=1; i<=s.length(); i++) {
            for (int j=0; j<i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
