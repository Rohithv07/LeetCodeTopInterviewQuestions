public class Solution {
    int resultLength;
    int resultStart;
    public String longestPalindrome(String A) {
        int length = A.length();
        if (length < 2)
            return A;
        for (int start = 0; start < length - 1; start++) {
            helperFunction(A, start, start);
            helperFunction(A, start, start + 1);
        }
        return A.substring(resultStart, resultStart + resultLength);
    }
    
    public void helperFunction(String A, int i, int j) {
        while (i >= 0 && j < A.length() && A.charAt(i) == A.charAt(j)) {
            i -= 1;
            j += 1;
        }
        if (resultLength < j - i - 1) {
            resultLength = j - i - 1;
            resultStart = i + 1;
        }
    }
}

