class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int length = s.length();
        int start = 0;
        int [] position = new int [256];
        int result = 0;
        for (int end=0; end<length; end++) {
            char current = s.charAt(end);
            if (position[current] > 0) {
                start = Math.max(start, position[current]);
            }
            position[current] = end + 1;
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
}