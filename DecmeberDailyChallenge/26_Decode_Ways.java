class Solution {
    public int numDecodings(String s) {
        int [] dp = new int[s.length() + 1];
        // if the length == 0, there is actually no way to decode it.
        // so the number of ways to decode nothing is doing nothing. So 1 way, ie. actually doing nothing.
        dp[0] = 1;
        // dp[1] depends upon the first character.
        // if we have a 0 at first character, then 0 decode ways
        // else we have a decod way
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i=2; i<=s.length(); i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if (first > 0 && first <= 9)
                dp[i] += dp[i-1];
            if (second > 9 && second <= 26)
                dp[i] += dp[i-2];
        }
        return dp[s.length()];
    }
}
