Given Preorder, Inorder and Postorder traversals of some tree of size N. The task is to check if they are all of the same tree or not.

Example 1:

Input:
N = 5
preorder[] = {1, 2, 4, 5, 3}
inorder[] = {4, 2, 5, 1, 3}
postorder[] = {4, 5, 2, 3, 1}
Output: Yes
Explanation: 
All of the above three traversals 
are of the same tree.
           1
         /   \
        2     3
      /   \
     4     5
Example 2:

Input:
N = 5
preorder[] = {1, 5, 4, 2, 3}
inorder[] = {4, 2, 5, 1, 3}
postorder[] = {4, 1, 2, 3, 5}
Output: No
Explanation: The three traversals can 
not be of the same tree.

Your Task:
You don't need to read input or print anything. Complete the function checktree() which takes the array preorder[ ], inorder[ ], postorder[ ] and integer N as input parameters and returns true if the three traversals are of the same tree or not. 

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 103
Node values are unique.


"""
Search for the first element of preorder array in the inorder array and store it’s index as idx, if it doesn’t exist then return False. Also, check if that element present in the postorder array or not. If it is not then return False.
Everything from 0th index for inorder and postorder and from 1st index for preorder of length idx becomes left subtree for first element of the preorder array.
Everything from position idx+1 for inorder and preorder and from idx for postorder of length (length-idx-1) becomes right subtree for first element of preorder array.
Repeat the steps 1 to 3 recursively until length of arrays become either 0 (in which case we 
return true) or 1 (in which case we return True only if all three arrays are equal, else False).
"""

class Solution:
    def checktree(self, preorder, inorder, postorder, N): 
	
    	# if the array lengths are 0, then all of them are obviously equal 
    	if N == 0: 
    		return 1
    		
    	# if array lengths are 1, then check if all of them are equal 
    	if N == 1: 
    		return (preorder[0] == inorder[0]) and (inorder[0] == postorder[0]); 
    
    	# search for first element of preorder in inorder array 
    	idx = -1; 
    	
    	for i in range(N): 
    		if inorder[i] == preorder[0]: 
    			idx = i 
    			break
    	
    	if idx == -1: 
    		return 0;
    	
    	# matching element in postorder array
    	if preorder[0] != postorder[N-1]:
    	    return 0;
    	
    	# check for the left subtree 
    	ret1 = self.checktree(preorder[1:], inorder, postorder, idx); 
    	
    	# check for the right subtree	 
    	ret2 = self.checktree(preorder[idx + 1:], inorder[idx + 1:], 
    						postorder[idx:], N-idx-1); 
    	
    	# return 1 only if both of them are correct else 0 
    	return (ret1 and ret2)
    	
# preorder - root left right
# postorder - left right root
# inorder - left root right