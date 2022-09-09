Given n balls . All of them are initially  uncolored . You have to color the balls with two colors RED and BLUE such that there can be atmost 2 positions where a RED ball is touching BLUE ball or vice versa. You have to color all the balls.Find the number of ways in which balls can be colored.

Example 1:

Input: n = 1
Output: 2
Explanation: Possible ways to color are {{R},{B}}. 
So the answer is 2 .

Example 2:

Input: n = 2
Output: 4
Explanation: Possible ways to color are 
{{RB},{BR},{RR},{BB}}.So the answer is 4.

Your Task:  
You dont need to read input or print anything. Complete the function noOfWays() which takes n as input parameter and returns  the number of ways in which balls can be colored.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1<= n <=105



//User function Template for Java
class Solution {
    static long noOfWays(long n){
        // code here
        return 2 + n * (n - 1);
    }
}