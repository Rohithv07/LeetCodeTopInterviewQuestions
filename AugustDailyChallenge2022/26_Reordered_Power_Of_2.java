You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.

Return true if and only if we can do this so that the resulting number is a power of two.

 

Example 1:

Input: n = 1
Output: true
Example 2:

Input: n = 10
Output: false
 

Constraints:

1 <= n <= 109



class Solution {
    public boolean reorderedPowerOf2(int N) {
        int [] inputFreq = findFreq(N);
        for (int i=0; i<31; i++) {
            int currentPower = (int) Math.pow(2, i);
            int [] currentFreq = findFreq(currentPower);
            if (checkForEqualityOfArrays(inputFreq, currentFreq))
                return true;
        }
        return false;
    }
    
    public int [] findFreq(int number) {
        int [] result = new int [10];
        while (number > 0) {
            result[number % 10] += 1;
            number /= 10;
        }
        return result;
    }
    
    public boolean checkForEqualityOfArrays(int [] inputFreq, int [] currentFreq) {
        for (int i=0; i<10; i++) {
            if (inputFreq[i] != currentFreq[i])
                return false;
        }
        return true;
    }
}