https://www.hackerrank.com/challenges/self-balancing-tree/problem




	/* Class node is defined as :
    class Node 
    	int val;	//Value
    	int ht;		//Height
    	Node left;	//Left child
    	Node right;	//Right child

	*/
    /*
    a) y is left child of z and x is left child of y (Left Left Case)
    b) y is left child of z and x is right child of y (Left Right Case)
    c) y is right child of z and x is right child of y (Right Right Case)
    d) y is right child of z and x is left child of y (Right Left Case)
    */
    /*
    4) If balance factor is greater than 1, then the current node is unbalanced and we are either   in Left Left case or left Right case. To check whether it is left left case or not, compare the     newly inserted key with the key in left subtree root.
5) If balance factor is less than -1, then the current node is unbalanced and we are either in      Right Right case or Right-Left case. To check whether it is Right Right case or not, compare    the newly inserted key with the key in right subtree root.
    */
    static int height(Node node) {
        if (node == null)
            return -1;
        return node.ht;
    }
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }
    // considering the right rotation
    static Node rightRotate(Node root) {
        Node newRoot = root.left;
       root.left = newRoot.right;
       newRoot.right = root;
       root.ht = setHeight(root);
       newRoot.ht = setHeight(newRoot);
       return newRoot;
    }
    // considering the left rotation
    static Node leftRotate(Node root) {
        Node newRoot = root.right;
       root.right = newRoot.left;
       newRoot.left = root;
       root.ht = setHeight(root);
       newRoot.ht = setHeight(newRoot);
       return newRoot;
    }
    // we need to check for the height balance too [-1, 0, 1]
    private static int setHeight(Node root) {
       if(root == null) {
           return -1;
       } 
       else {
           return 1 + Math.max(height(root.left), height(root.right));
       }
   }
	static Node insert(Node root,int val)
    {
    	 if(root == null) {
           root = new Node();
           root.val = val;
           root.ht = height(root);
           return root;
       }
        if (root.val <= val)
            root.right = insert(root.right, val);
        else if (root.val > val)
            root.left = insert(root.left, val);
        root.ht = max(height(root.left), height(root.right)) + 1;
        int balance = height(root.left) - height(root.right);
        // 1. right rotation
        if (balance > 1 && height(root.left.left) >= height(root.left.right))
            return rightRotate(root);
        // 2. left rotation
        if (balance < -1 && height(root.right.right) >= height(root.right.left))
            return leftRotate(root);
        // 3. left rotate then right rotate
        if (balance > 1 && height(root.left.left) < height(root.left.right)) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // 4. right rotate then left rotate
        if (balance < -1 && height(root.right.right) < height(root.right.left)) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }
// Time complexity will be O(height). Sice it will be balance height so O(logn)
