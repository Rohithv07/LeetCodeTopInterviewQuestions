This question is asked by Microsoft. Given a message that is encoded using the following encryption method…

A -> 1
B -> 2
C -> 3
...
Z -> 26
Return the total number of ways it can be decoded.
Note: ‘0’ has no mapping and a character following a ‘0’ also has no mapping (i.e. “03”)


Ex: Given the following message…

message = "23", return 2.
The message can be decrypted as "BC" (i.e. 2 -> B, 3 -> C)
The message can also be decrypted as "W" (i.e. 23 -> W)
Ex: Given the following message…

message = "1234", return 3.

// lets start this by trying with backtracking

public int numDecoding(String s) {
	if (s.length() == 1 && s.equals("0")
		return 0;
	if (s.length() == 1 && s.equals("1")
		return 1;
	List<List<String>> result = new ArrayList<>();
	List<String>current = new ArrayList<>();
	backtrack(result, current, 0, s);
	return result.size();
}
public void backtrack(List<List<String>> result, List<String> current, int start, String s) {
	if (start == s.length()) {
		result.add(new ArrayList<>(current));
		return;
	}
	for (int i=start; i<s.length(); i++) {
		if (s.substring(i)) {
			current.add(s.charAt(i));
			backtrack(result, current, i, s);
			current.remove(current.size() - 1);
		}
	}
}
// WRONG ANSWER
// but here I didnt get a proper continuation and when I run I get stackoverflow
// so clearly this is  not the way to go.
// so here we are having certain states that we need the numbers to be 1 - 9 for single digits and the double digit number should not exceed 26
// we can make use of dynamic programming to keep track of this states and count the number
// we will be having only either 1 digit combination or 2 digit combination and not more than that
// I used a dp array of size n + 1 to save subproblem solutions. dp[0] means an empty string will have one way to decode, dp[1] means the way to decode a string of size 1. I then check one digit and two digit combination and save the results along the way. In the end, dp[n] will be the end result.


class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.length() == 1 && s.equals("0"))
		return 0;
	if (s.length() == 1 && s.equals("1"))
		return 1;
        if (s.charAt(0) == '0')
            return 0;
	int [] dp = new int [s.length() + 1];
	dp[0] = 1;
	dp[1] = s.charAt(0) != 0 ? 1 : 0;
	for (int i=2; i<=s.length(); i++) {
		// take the first and second letter
		int first = Integer.valueOf(s.substring(i-1, i));
		int second = Integer.valueOf(s.substring(i-2, i));
		// check first between 1-9
		if (first > 0 && first < 10)
			dp[i] += dp[i-1];
		// check for the 2 digit combination
		if (second > 9 && second < 27)
			dp[i] += dp[i-2];
	}
	return dp[s.length()];
    }
}
