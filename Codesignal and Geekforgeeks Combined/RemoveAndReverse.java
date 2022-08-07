// https://practice.geeksforgeeks.org/contest/interview-series-62/problems/#

// https://www.youtube.com/watch?v=Ngfzp9d6YYk&t=480s



/*
1. We will be making use of 2 pointers approach here.
2. We also maintain a flag to know whether we are processing from the back or from the front
   This is because when we do the reversal, we actually don't want to reverse the
   string everytime, we just switch between the traversal from left or right.
3. We start from the left most, we check whether the leftchar is repeared by making
   use of a frequency array, if yes, we mark it as # to say its deleted and move 
   our attention to right pointer as the next traversal will happen after reversing, that means
   traversal starts from the back
4. We use the boolean flag as a switcher and atlast we build the final string.
*/
class Solution 
{ 
    String removeReverse(String s) 
    { 
        // code here
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int length = s.length();
        int left = 0;
        int right = length - 1;
        int [] frequency = new int [26];
        for (char ch : s.toCharArray()) {
            frequency[ch - 'a']++;
        }
        boolean fromReverse = false;
        char [] sArray = s.toCharArray();
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (!fromReverse && frequency[leftChar - 'a'] > 1) {
                frequency[leftChar - 'a']--;
                sArray[left] = '#';
                left++;
                fromReverse = true;
            }
            else if (fromReverse && frequency[rightChar - 'a'] > 1) {
                frequency[rightChar - 'a']--;
                sArray[right] = '#';
                right--;
                fromReverse = false;
            }
            else if (!fromReverse) {
                
                left++;
            }
            else if (fromReverse) {
            
                right--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : sArray) {
            if (ch != '#') {
                sb.append(ch);
            }
        }
        if (fromReverse) {
            return sb.reverse().toString();
        }
        return sb.toString();
    }
} 



