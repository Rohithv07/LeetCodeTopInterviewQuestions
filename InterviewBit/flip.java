You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised. If you don’t want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

Notes:

Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
For example,

S = 010

Pair of [L, R] | Final string
_______________|_____________
[1 1]          | 110
[1 2]          | 100
[1 3]          | 101
[2 2]          | 000
[2 3]          | 001

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
Another example,

If S = 111

No operation can give us more than three 1s in final string. So, we return empty array [].



// here we need to treat 0's as +1 and 1's as -1
// then go through this count array and check whether the currentSum > maxSum
// if true, then just make maxSum = currentSum, end = i, start = pointer.
// also check whether the currentSum < 0, if yes update currentSum = 0, pointer = i+1
// now after exiting from the loop, check whther the maxSUm we got is negative, if yes return empty.
// otherwise store the start+1 and end+1 into an array and return the result.

public class Solution {
    public int[] flip(String A) {
        char [] array = A.toCharArray();
        int [] count = new int [A.length()];
        // treat 0's as 1 and 1's as -1 store it in an array
        for (int i=0; i<A.length(); i++) {
            if (array[i] == '0')
                count[i] = 1;
            else
                count[i] = -1;
        }
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int pointer = 0;
        for (int i=0; i<count.length; i++) {
            currentSum += count[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                end = i;
                start = pointer;
            }
            if (currentSum < 0) {
                currentSum = 0;
                pointer = i + 1;
            }
        }
        int [] output = new int [2];
        if (maxSum < 0)
            return new int [0];
        output[0] = start+1;
        output[1] = end+1;
        return output;
    }
}

