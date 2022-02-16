Geek has developed an effective vaccine for Corona virus and he wants each of the N houses in Geek Land to have access to it. Given a binary tree where each node represents a house in Geek Land, find the minimum number of houses that should be supplied with the vaccine kit if one vaccine kit is sufficient for that house, its parent house and it's immediate child nodes.  

 

Example 1:

Input:
    1
   / \
  2   3 
        \
         4
          \
           5
            \
             6

Output:
2
Explanation:
The vaccine kits should be 
supplied to house numbers 1 and 5. 
Example 2:

Input:
    1
   / \
  2   3 
Output:
1
Explanation:
The vaccine kits should be 
supplied to house number 1.

Your Task:
You don't need to read input or print anything. Complete the function supplyVaccine() which takes the root of the housing tree as input parameter and returns the minimum number of houses that should be supplied with the vaccine kit.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 105


class Solution{
public:
int count = 0;
// -1 is for need of camera because not covered by any camera or not have its own camera
// 0 is for having a camera
// 1 is for covered by other camera
int solve(Node* root)
    {
        if(root==NULL)
        {
            return 1;
        }
        int left = solve(root->left);
        int right = solve(root->right);
        // kya left child ko camere ki need hai ya right child ko hai
        // kisi ko bhi hogi toh humko camera lagana padega
        if(left==-1 || right ==-1)
        {
            count++;
            return 0;
        }
        // agar left ya right kisi ke bhi paas camera hai toh parent toh parent cover ho hi jayega aram se
        if(left==0 || right == 0)
        {
            return 1;
        }
        //last not the least
        // agar mere dono child ke paas camera nahi hai
        // but vo cover ho rakhe hai toh mujhe parent pe toh camera chahiye hi hoga
        return -1;
    }
    int supplyVaccine(Node* root){
        // Your code goes here
        if(solve(root)==-1)
        {
            count++;
        }
        return count;
        
    }
};