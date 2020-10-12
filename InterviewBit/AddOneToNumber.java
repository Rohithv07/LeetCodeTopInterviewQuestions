Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.

 NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
For example, for this problem, following are some good questions to ask :
Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.


public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int reminder = 0;
        // to remove the very first 0
        while (A.size() > 1 && A.get(0) == 0)
            A.remove(0);
        for (int i=A.size()-1; i>=0; i--) {
            int number = A.get(i);
            if (number == 9) {
                A.remove(i);
                A.add(i, 0);
                reminder = 1;
            }
            else {
                A.remove(i);
                A.add(i, number+1);
                reminder = 0;
                break;
            }
        }
        if (reminder == 1) {
            A.add(0, 1);
        }
        return A;
    }
}

