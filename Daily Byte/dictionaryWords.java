This question is asked by Amazon. Given a string s and a list of words representing a dictionary, return whether or not the entirety of s can be segmented into dictionary words.
Note: You may assume all characters in s and the dictionary are lowercase.

Ex: Given the following string s and dictionary…

s = "thedailybyte", dictionary = ["the", "daily", "byte"], return true.

Ex: Given the following string s and dictionary…

s = "pizzaplanet", dictionary = ["plane", "pizza"], return false.


// here my idea is we take the first word from the dictionary, check whether the index of that word in the string != -1, if not we carry a counter
// and update the counter witht he current words length, otherwise we can return false directly.
// else we check the whether the counter == the length of string, if yes, then the string is segmented inside the dictionary.
// but this have a complexity about O(n^2m) worst case

// the idea here is to make use of dynamic programming
// we create a boolean array here and it tracks true or false indicating whether we can form the word or not/

-> We started by creating dp array of size of s + 1.
-> Let the first index be true.
-> Now lets traverse through the dp array and make the necessary changes based on the words inside the dict.
-> If we see a subtring from j to i, inside the inner loop, just update the corresponding ith index of array to true and break and continue with the next one.
-> Finally return the array where the last index will be holding true or false which indicates whether we can actually segmented to space separated sequnce.




class Solution {
    public boolean wordBreak(String s, List<String> dictionary) {
        // boolean array
        boolean [] dp = new boolean[s.length()+1];
        dp[0] = true;
        int length = s.length();
        for (int i=1; i<=length; i++) {
            for (int j=0; j<i; j++) {
                if (dp[j] && dictionary.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }	
        }
        return dp[s.length()];
    }
}
