Given a Binary Tree of size N, extract all its leaf nodes to form a Doubly Link List starting from the left most leaf. Modify the original tree to make the DLL thus removing the leaf nodes from the tree. Consider the left and right pointers of the tree to be the previous and next pointer of the DLL respectively.

Example 1:

Input :
        1
      /   \
     2     3
    / \   / \
   4   5 6   7    

Output: 
Modified Tree :
        1
      /   \
     2     3

Doubly Link List :
4 <-> 5 <-> 6 <-> 7

Explanation:
The leaf nodes are modified to form the DLL 
in-place. Thus their links are removed from 
the tree.
Example 2:

Input :
        1
      /   \
     2     3
    / \   
   4   5 

Output: 
Modified Tree :
        1
      /   
     2    

Doubly Link List :
4 <-> 5 <-> 3

Your Task:  
You dont need to read input or print anything. Complete the function convertToDLL() which takes root of the given tree as input parameter and returns the head of the doubly link list.

Note:
The generated output will contain the inorder traversal of the modified tree, the DLL from left to right and the DLL from right to left.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(height of tree)


Constraints:
1 ≤ N ≤ 10^4




bool leaf(Node *node){
   if(node==NULL) return false;
   if(node->left==NULL) if(node->right==NULL) return true;
   return false;
}

void method(Node *prev, Node *node, vector<int> &v){
   if(node==NULL) return;
   if(leaf(node)) {
       v.push_back(node->data); 
       if(prev->left==node) prev->left=NULL;
       else prev->right=NULL;
   }
   method(node, node->left, v);
   method(node, node->right, v);
}

Node * convertToDLL(Node *root){
   vector<int> v;
   method(NULL, root, v);
   Node *head = new Node(v[0]);
   Node *temp = head, *prev;
   for(int i=1;i<v.size();i++){
       Node *node = new Node(v[i]);
       temp->right = node;
       node->left = temp;
       prev = temp;
       temp = node;
   }
   return head;
}