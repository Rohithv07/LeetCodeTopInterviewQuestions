//User function Template for Java

Geek lives in a special city where houses are arranged in a hierarchial manner. Starting from house number 1, each house leads to two more houses.  
1 leads to 2 and 3. 
2 leads to 4 and 5. 
3 leads to 6 and 7. and so on. 
Given the house numbers on two houses x and y, find the length of the shortest path between them. 


Example 1:

Input:
x = 2, y = 6
Output: 3
Explanation:
              1
          /      \
        /          \
       2             3
     /   \         /   \
    4     5       6     7         
   / \   / \     / \   / \
  8  9  10 11   12 13 14 15

The length of the shortest path between 2 
and 6 is 3. ie 2-> 1-> 3-> 6.

Example 2:

Input:
x = 8, y = 10
Output: 4
Explanation: 8-> 4-> 2-> 5-> 10
The length of the shortest path between 8 
and 10 is 4. 

Your Task:
You don't need to read input or print anything. Complete the function shortestPath() which takes integers x and y as input parameters and returns the length of the shortest path from x to y.


Expected Time Complexity: O(log(max(x,y)))
Expected Auxiliary Space: O(1)


Constraints: 
1 <= x,y <= 109

class Solution { 
    int shortestPath( int x, int y){ 
        // code here
        int count = 0;
        while (x != y) {
            if (x > y) {
                x /= 2;
            }
            else {
                y /= 2;
            }
            count++;
        }
        return count;
    }
}