Given an unsigned integer N. The task is to swap all odd bits with even bits. For example, if the given number is 23 (00010111), it should be converted to 43(00101011). Here, every even position bit is swapped with adjacent bit on the right side(even position bits are highlighted in the binary representation of 23), and every odd position bit is swapped with an adjacent on the left side.

Example 1:

Input: N = 23
Output: 43
Explanation: 
Binary representation of the given number 
is 00010111 after swapping 
00101011 = 43 in decimal.
Example 2:

Input: N = 2
Output: 1
Explanation: 
Binary representation of the given number 
is 10 after swapping 01 = 1 in decimal.

Your Task: Your task is to complete the function swapBits() which takes an integer and returns an integer with all the odd and even bits swapped.


Expected Time Complexity: O(1).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 109


class Solution
{
    //Function to swap odd and even bits.
    public static int swapBits(int n) 
    {
	    // Your code
	    int remainder1 = 0;
	    int remainder2 = 0;
	    int sum = 0;
	    int h = 1;
	    int d = 0;
	    while (n != 0) {
	        remainder1 = n % 2;
	        n /= 2;
	        remainder2 = n % 2;
	        n /= 2;
	        sum += remainder2 * Math.pow(2, d);
	        sum += remainder1 * Math.pow(2, h);
	        d += 2;
	        h += 2;
	    }
	    return sum;
	}
    
}