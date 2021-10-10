// https://youtu.be/vgPXgu8z9wo

//Structure of node
/*struct Node {
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};*/
class Solution {
  public:
    //Function to return maximum path product from any node in a tree.
    long long findMaxScore(Node* root)
    {
        // Your code goes here
        long long result = 1;
        findMaxProduct(root, result, root->data);
        return result;
    }
    
    void findMaxProduct(Node * root, long long &result, long long currentProduct) {
        if (root -> left == NULL && root -> right == NULL) {
            result = max(result, currentProduct);
            return;
        }
        if (root -> left != NULL) {
            findMaxProduct(root -> left, result, currentProduct * root -> left -> data);
        }
        if (root -> right != NULL) {
            findMaxProduct(root -> right, result, currentProduct * root -> right -> data);
        }
    }
};