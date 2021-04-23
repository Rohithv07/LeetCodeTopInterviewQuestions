class Solution {
    public int countBinarySubstrings(String s) {
        int length = s.length();
        int answer = 0;
        int current = 1;
        int previous = 0;
        for (int i=1; i<length; i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                answer += Math.min(previous, current);
                previous = current;
                current = 1;
            }
            else {
                current += 1;
            }
        }
        return answer + Math.min(current, previous);
    }
}
