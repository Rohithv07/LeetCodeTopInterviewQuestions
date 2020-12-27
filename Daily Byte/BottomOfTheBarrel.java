/*
Given a binary tree, return the bottom-left most value.
Note: You may assume each value in the tree is unique.
Ex: Given the following binary tree…

      1
     / \
    2   3
   /
  4 
return 4.
Ex: Given the following binary tree…

      8
     / \
    1   4
       /
      2 
return 2.
*/
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) {
    this.val = val;
  }
  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}


class BottomOfTheBarrel {

    static int height = 0;
    static int answer = 0;

    public static int bottomLeftValue(TreeNode root){
      if (root == null)
        return 0;
      dfsHelper(root, 1);
      return answer;
    }

    public static void dfsHelper(TreeNode node, int depth) {
      if (height < depth) {
        height = depth;
        answer = node.val;
      }
      if (node.left != null)
        dfsHelper(node.left, depth + 1);
      if (node.right != null)
        dfsHelper(node.right, depth + 1);
    }

    public static void main(String [] args) {
      TreeNode node1 = new TreeNode(1);
      node1.left = new TreeNode(2);
      node1.right = new TreeNode(3);
      node1.left.left = new TreeNode(4);
      System.out.println(bottomLeftValue(node1));
      TreeNode node2 = new TreeNode(8);
      node2.left = new TreeNode(1);
      node2.right = new TreeNode(4);
      node2.right.left = new TreeNode(2);
      System.out.println(bottomLeftValue(node2));
    }
}
