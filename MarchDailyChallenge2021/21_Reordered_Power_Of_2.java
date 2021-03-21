Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.

Return true if and only if we can do this in a way such that the resulting number is a power of 2.

 

Example 1:

Input: 1
Output: true
Example 2:

Input: 10
Output: false
Example 3:

Input: 16
Output: true
Example 4:

Input: 24
Output: false
Example 5:

Input: 46
Output: true
 

Note:

1 <= N <= 10^9




// we can just check whether NN has the same digits as any of the possibilities.

class Solution {
    public boolean reorderedPowerOf2(int N) {
        // current numbers freq array
        int [] inputFreq = findFreq(N);
        for (int i=0; i<31; i++) {
            // current iteration power
            int currentPower = (int) Math.pow(2, i);
            // current power of 2 freq
            int [] currentFreq = findFreq(currentPower);
            // comparing with the input frequency array
            if (checkForEqualityOfArrays(inputFreq, currentFreq))
                return true;
        }
        return false;
    }
    
    /**
    *Helper function to find the frequency of the digits of numbers
    **/
    
    public int [] findFreq(int number) {
        int [] result = new int [10];
        while (number > 0) {
            result[number % 10] += 1;
            number /= 10;
        }
        return result;
    }
    
    /**
    *Helper function to check for the equality of arrays
    **/
    public boolean checkForEqualityOfArrays(int [] inputFreq, int [] currentFreq) {
        for (int i=0; i<10; i++) {
            if (inputFreq[i] != currentFreq[i])
                return false;
        }
        return true;
    }
}




