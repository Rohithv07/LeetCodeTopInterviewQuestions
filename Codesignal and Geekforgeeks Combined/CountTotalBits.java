You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).

Example 1:

Input: N = 4
Output: 5
Explanation:
For numbers from 1 to 4.
For 1: 0 0 1 = 1 set bits
For 2: 0 1 0 = 1 set bits
For 3: 0 1 1 = 2 set bits
For 4: 1 0 0 = 1 set bits
Therefore, the total set bits is 5.
Example 2:

Input: N = 17
Output: 35
Explanation: From numbers 1 to 17(both inclusive), 
the total number of set bits is 35.

Your Task: The task is to complete the function countSetBits() that takes n as a parameter and returns the count of all bits.

Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 108


class Solution{
    public:
    // n: input to count the number of set bits
    //Function to return sum of count of set bits in the integers from 1 to n.
    int countSetBits(int n)
    {
        // Your logic here
        /*
        If we observe bits from rightmost side at distance i 
        than bits get inverted after 2^i position in vertical sequence. 
        for example n = 5; 
        0 = 0000 
        1 = 0001 
        2 = 0010 
        3 = 0011 
        4 = 0100 
        5 = 0101
        Observe the right most bit (i = 0) the bits get flipped after (2^0 = 1) 
        Observe the 3rd rightmost bit (i = 2) the bits get flipped after (2^2 = 4) 
        So, We can count bits in vertical fashion such that at iâth right most 
        position bits will be get flipped after 2^i iteration;
        */
        
        int ans = 0;
        for(int i = 0; i < 31; i++){
            
            int units = (1<<i)*((n + 1)/(1<<(i + 1)));
            //units = no of ones in a complete cycle * number of complete cycles
            int rems = max(0, ((n + 1) % (1<<(i + 1))) - (1<<i));
            // rems = length of the incomplete cycle - number of zeros in a cycle
            ans += units + rems;
        }
        
        return ans;
    }
};