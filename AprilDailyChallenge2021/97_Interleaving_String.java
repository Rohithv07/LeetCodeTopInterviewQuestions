class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int length1 = s1.length();
        int length2 = s2.length();
        int length3 = s3.length();
        if (length1 + length2 != length3)
            return false;
        boolean [][] invalid = new boolean[length1 + 1][length2 + 1];
        return dfs(s1, s2, s3, 0, 0, 0, invalid);
    }
    
    public boolean dfs(String s1, String s2, String s3, int i, int j, int k, boolean [][] invalid) {
        if (invalid[i][j])
            return false;
        if (k == s3.length())
            return true;
        // either s1.charAt(i) == s3.charAt(k) so continue recursion with i + 1 and k + 1
        // but there can also be the other case that is s2.charAt(j) == s3.charAt(k) so continue recursion with j + 1 and k + 1
        // we stop if we reach k = s3.length or already had an invalid result
        boolean isThereValid = i < s1.length() && s1.charAt(i) == s3.charAt(k) && dfs(s1, s2, s3, i+1, j, k + 1, invalid) || j < s2.length() && s2.charAt(j) == s3.charAt(k) && dfs(s1, s2, s3, i, j+1, k+1, invalid);
        if (!isThereValid)
            invalid[i][j] = true;
        return isThereValid;
    }
}
