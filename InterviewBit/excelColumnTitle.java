public class Solution {
    public String convertToTitle(int A) {
        return A == 0 ? "" : convertToTitle(--A/26) + (char)('A' + (A%26));
    }
}



public class Solution {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n-->0) {
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }
        return result.toString();
    }
}

