Given a number num, our task is to find the closest Palindrome number whose absolute difference with given number is minimum. If 2 Palindome numbers have same absolute difference from the given number, then find the smaller one.
 

Example 1:

Input: num = 9
Output: 9
Explanation: 9 itself is a palindrome
number.
Example 2:

Input: num = 489
Output: 494
Expnataion: closest palindrome numbers from
489 are 484 and 494. Absolute difference between
489 and 494 is equal to the absolute difference
between 484 and 489 but 484 is smaller than 494.
 

Your Task:
You don't need to read or print anyhting. Your task is to complete the function closestPalindrome() which takes num as input parameter and returns the closest palindrome.
 

Expected Time Complexity: O(log10num)
Expected Space Complexity: O(1)
 

Constraints:
1 <= num <= 1014


class Solution
{
    public long closestPalindrome(long num)
    {
        // Code here
        if (num < 10) {
            return num;
        }
        String n = String.valueOf(num);
        int len = n.length();
        int i = len % 2 == 0 ? len / 2 - 1: len / 2;
        long left = Long.parseLong(n.substring(0, i+1));
        
        // input: n 12345
        List<Long> candidate = new ArrayList<>();
        candidate.add(getPalindrome(left, len % 2 == 0)); // 12321
        candidate.add(getPalindrome(left+1, len % 2 == 0)); // 12421
        candidate.add(getPalindrome(left-1, len % 2 == 0)); // 12221
        candidate.add((long)Math.pow(10, len-1) - 1); // 9999
        candidate.add((long)Math.pow(10, len + 1) + 1); // 100001
        
        long diff = Long.MAX_VALUE, res = 0, nl = Long.parseLong(n);
        for (long cand : candidate) {
            if (Math.abs(cand - nl) < diff) {
                diff = Math.abs(cand - nl);
                res = cand;
            } else if (Math.abs(cand - nl) == diff) {
                res = Math.min(res, cand);
            }
        }
        
        return res;
    }
    
    private long getPalindrome(long left, boolean even) {
        long res = left;
        if (!even) left = left / 10;
        while (left > 0) {
            res = res * 10 + left % 10;
            left /= 10;
        }
        return res;
    }
}