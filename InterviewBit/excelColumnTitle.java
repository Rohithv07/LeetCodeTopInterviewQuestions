public class Solution {
    public String convertToTitle(int A) {
        return A == 0 ? "" : convertToTitle(--A/26) + (char)('A' + (A%26));
    }
}

