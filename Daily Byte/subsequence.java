This question is asked by Google. Given two strings s and t return whether or not s is a subsequence of t.
Note: You may assume both s and t only consist of lowercase characters and both have a length of at least one.

Ex: Given the following strings s and t…

s = "abc", t = "aabbcc", return true.
Ex: Given the following strings s and t…

s = "cpu", t = "computer", return true.
Ex: Given the following strings s and t…

s = "xyz", t = "axbyc", return false.


class Solution {
    public boolean isSubsequence(String s, String t) {
        // 1 Method Pointer method
        if (s.length() == 0)
            return true;
        int sPointer = 0;
        int tPointer = 0;
        while (tPointer < t.length()) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) 
                sPointer += 1;
            if (sPointer == s.length())
                return true;
            tPointer += 1;
        }
        return false;
        
        // 2 Method using indexOf()
        if (s.length() == 0)
            return true;
        int index = -1;
        for (char c: s.toCharArray()) {
            index = t.indexOf(c, index+1);
            if (index == -1)
                return false;
        }
        return true;
        
    }
}
