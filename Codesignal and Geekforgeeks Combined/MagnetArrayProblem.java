Given N Magnets which are placed linearly, with each magnet to be considered as of point object. Each magnet suffers force from its left sided magnets such that they repel it to the right and vice versa. All forces are repulsive. The force being equal to the distance (1/d , d being the distance). Now given the positions of the magnets, the task to find all the points along the linear line where net force is ZERO. 

More Formally, Magnets are placed on X axis, the coordinates of which are given, you are asked to find out the X-co-ordinates of all the equilibrium points (i.e. the point where net force is zero). You notice the point each magnet repels each other, it means the polarity of the magnet is such that exerts +ve force in its right side and -ve force in left side, (here +ve is considered in +ve direction of x-axis). And that forces are inversely proportional to the distance, thus there lies an equilibrium point between every two magnetic points. Thus there will be total of N-1 equllibrium points. You have to find those N-1 points.
Note: Array M[] is sorted and distance have to be calculated with precision of 2 decimal places.

 

Example 1:

Input:
N = 2
M[] = {1, 2}
Output:
1.50
Explanation:
The mid point of two points will have 
net force zero, thus answer = 1.50
 

Example 2:

Input:
N = 4
M[] = {0, 10, 20, 30}
Output:
3.82, 15.00, 26.18
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function nullPoints() which takes the array M[], its size N as inputs and an answer array getAnswer[] to store the points having net force zero till precised two decimal places.


Expected Time Complexity: O(N2 * Log(N))
Expected Auxiliary Space: O(1)

 

Constraints:
2 ≤ N ≤ 105
0 ≤  M[1] < ....M[i] < M[i+1] < ....M[N] ≤ 106


//User function Template for Java

class Solution {
    
    public void nullPoints(int n, double magnets[], double getAnswer[])
    {
        // Your code goes here 
        for (int i = 0; i < n - 1; i++) {
            getAnswer[i] = binarySearch(magnets[i], magnets[i + 1], magnets, n);
        }
    }
    
    private double binarySearch(double low, double high, double [] magnets, int n) {
        double diff = 1 / (1e12);
        double middle = (low + high) / 2;
        double equi = 0.0;
        for (int i = 0; i < n; i++) {
            equi += 1 / (middle - magnets[i]);
        }
        if ((-diff) < equi && equi < diff) {
            return middle;
        }
        if (equi > 0) {
            return binarySearch(middle, high, magnets, n);
        }
        return binarySearch(low, middle, magnets, n);
        
    }
}


