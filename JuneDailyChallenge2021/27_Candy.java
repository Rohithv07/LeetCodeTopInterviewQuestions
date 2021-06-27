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
        int [] result = new int [length];
        int sum = 0;
        //The first loop makes sure children with a higher rating get more candy than its left neighbor; the second loop makes sure children with a higher rating get more candy than its right neighbor.
        for (int i=1; i<length; i++) {
            if (ratings[i] > ratings[i - 1])
                result[i] = result[i - 1] + 1;
        }
        for (int i=length-2; i>=0; i--) {
            if (ratings[i] > ratings[i + 1])
                result[i] = Math.max(result[i], result[i + 1] + 1);
            sum += result[i];
        }
        for (int number : result) {
            System.out.println(number);
        }
        return sum + length + result[length - 1];
    }
}
/*
[1, 0, 2]
result = [0, 0, 0]

for i=1 to n:
    i = 1 => ratings[1] > ratings[0] = 0 > 1 = false
    i = 2 => ratings[2] > ratings[1] = 2 > 0 = true.therefore ratings[i] = 0 + 1 = 1
result[0, 0, 1]

for i = length - 2 to 0:
    i = 1 => ratings[1] > ratings[2] = 0 > 2 = false, sum += result[1] = 0
    i = 0 => ratings[0] > ratings[1] = 1 > 2 = true.therfore ratings[0] = max(result[0], result[0 + 1] + 1) = (0, 1 +_1) = (0, 2) = 1 sum += result[0] = 1
    
result[1, 0, 1]
    
answer = 1 + 1 + 3 = 5
*/
