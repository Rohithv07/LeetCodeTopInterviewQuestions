This post is a compilation of some level order traversal questions.

Binary Tree Level Order Traversal
Binary Tree Level Order Traversal II
Binary Tree Zigzag Level Order Traversal
Average of Levels in Binary Tree
Binary Tree Right Side View
Find Largest Value in Each Tree Row
Populating Next Right Pointers in Each Node

1. Binary Tree Level Order Traversal:
https://leetcode.com/problems/binary-tree-level-order-traversal/description/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        compute(ans,root,0);
        return ans;
    }
    
    public void compute(List<List<Integer>> ans,TreeNode curr,int level)
    {
        if(curr==null) return;
        
        if(ans.size()==level) 
            ans.add(new ArrayList<Integer>());
        
        ans.get(level).add(curr.val);
        
        compute(ans,curr.left,level+1);
        compute(ans,curr.right,level+1);
    }
}

2. Binary Tree Level Order Traversal II
https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        compute(ans,root,0);
        return ans;
    }
    
    public void compute(List<List<Integer>> ans,TreeNode curr,int level)
    {
        if(curr==null) return;
        
        if(ans.size()==level) 
            ans.add(0,new ArrayList<Integer>());
        
        ans.get(ans.size()-level-1).add(curr.val);
        
        compute(ans,curr.left,level+1);
        compute(ans,curr.right,level+1);
    }
}

3. Binary Tree Zigzag Level Order Traversal
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

class Solution {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        compute(root, ans, 0);
        return ans;
    }

    private static void compute(TreeNode curr, List<List<Integer>> ans, int level) {
        if (curr == null) return;

        if (ans.size() == level) 
            ans.add(new ArrayList<Integer>());

        if (level % 2 == 0) 
            ans.get(level).add(curr.val);
        else 
            ans.get(level).add(0, curr.val);

        compute(curr.left, ans, level + 1);
        compute(curr.right, ans, level + 1);
    }
}

4. Average of Levels in Binary Tree
https://leetcode.com/problems/average-of-levels-in-binary-tree/description/

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        //Sum stores the sum of each level
        //Count stores the number of nodes at each level
        List<Double> sum=new ArrayList<>();
        List<Double> count=new ArrayList<>();
        compute(sum,count,root,0);
        for(int i=0;i<sum.size();i++)
            sum.set(i,sum.get(i)/count.get(i));
        return sum;
        
    }
    
    public void compute(List<Double> sum,List<Double> count,TreeNode curr,int level)
    {
        if(curr==null) return;
        
        if(sum.size()==level) 
        {
            sum.add(0.0);
            count.add(0.0);
        }   
        
        sum.set(level,sum.get(level)+(double)curr.val);
        count.set(level,count.get(level)+1);
        
        compute(sum,count,curr.left,level+1);
        compute(sum,count,curr.right,level+1);
    }
}

5. Binary Tree Right Side View
https://leetcode.com/problems/binary-tree-right-side-view/description/


public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        compute(root, ans, 0);
        return ans;
    }
    
    public void compute(TreeNode curr, List<Integer> ans, int level){
        if(curr == null) return;
      
        if(ans.size()==level)
            ans.add(curr.val);
        
        compute(curr.right, ans, level + 1);
        compute(curr.left, ans, level + 1);
        
    }
}

6. Find Largest Value in Each Tree Row
https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        compute(root,ans,0);
        return ans;
    }
    
    public void compute(TreeNode curr,List<Integer> ans,int level)
    {
        if(curr==null) return;
        
        if(ans.size()==level)
            ans.add(curr.val);
        
        if(curr.val>ans.get(level))
            ans.set(level,curr.val);
        
        compute(curr.left,ans,level+1);
        compute(curr.right,ans,level+1);
    }
}

7. Populating Next Right Pointers in Each Node
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/

public class Solution {
    public void connect(TreeLinkNode root) {
        compute(root);
    }
    
    public void compute(TreeLinkNode curr)
    {
        if(curr==null || curr.left==null) return;
        
        curr.left.next=curr.right;
        if(curr.next!=null)
            curr.right.next=curr.next.left;
        
        compute(curr.left);
        compute(curr.right);
    }
}
