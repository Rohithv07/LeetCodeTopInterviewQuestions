Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Given s = "Hello World",

return 5 as length("World") = 5.





public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lengthOfLastWord(final String A) {
        if (A == " ")
            return 0;
        
        String [] array = A.split(" ");
        if (array.length == 0)
            return 0;
        return array[array.length - 1].length();
        
        
        // another method
        int length = 0;
        String newA = A.trim();
        for (int i=newA.length() - 1; i>=0; i--) {
            if (newA.charAt(i) == ' ')
                return length;
            length += 1;
        }
        return length;
    }
}

