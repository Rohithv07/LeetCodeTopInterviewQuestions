There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

 

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 

Constraints:

n == ratings.length
1 <= n <= 2 * 104
0 <= ratings[i] <= 2 * 104


class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;
        int length = ratings.length;
        int sum = 0;
        int [] result = new int [length];
        for (int i=1; i<length; i++) {
            if (ratings[i] > ratings[i - 1])
                result[i] = result[i - 1] + 1;
        }
        for (int i=length-2; i>=0; i--) {
            if (ratings[i] > ratings[i+1]) {
               result[i] = Math.max(result[i], result[i + 1] + 1); 
            }
            sum += result[i];
        }
        return sum + length + result[length - 1];
    }
}