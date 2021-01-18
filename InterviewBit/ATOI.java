There are certain questions where the interviewer would intentionally frame the question vague.
The expectation is that you will ask the correct set of clarifications or state your assumptions before you jump into coding.

Implement atoi to convert a string to an integer.

Example :

Input : "9 2704"
Output : 9
Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.

 Questions: Q1. Does string contain whitespace characters before the number?
A. Yes Q2. Can the string have garbage characters after the number?
A. Yes. Ignore it. Q3. If no numeric character is found before encountering garbage characters, what should I do?
A. Return 0. Q4. What if the integer overflows?
A. Return INT_MAX if the number is positive, INT_MIN otherwise. 
Warning : DO NOT USE LIBRARY FUNCTION FOR ATOI.
If you do, we will disqualify your submission retroactively and give you penalty points.




public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int atoi(final String A) {
        long result = 0;
        int sign = 1;
        int i = 0;
        if(A.charAt(0) == '-')
        {
            sign = -1;
            i++;
        }
        if(A.charAt(0) == '+')
        {
            sign = 1;
            i++;
        }
        for(; i<A.length(); i++)
        {
            if((A.charAt(i) - '0' > 9) || (A.charAt(i) - '0' < 0))
            {
                break;
            }
            result = result*10 + A.charAt(i) - '0';
            
            if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            {
                if(sign == 1)
                {
                    return Integer.MAX_VALUE;
                }
                else
                {
                    return Integer.MIN_VALUE;
                }
                
            }
            
        }
        return (int) result*sign;
        
    }
}

