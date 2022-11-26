Construct a binary tree from a string consisting of parenthesis and integers. The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the roots value and a pair of parenthesis contains a child binary tree with the same structure. Always start to construct the left child node of the parent first if it exists.

Example 1:

Input: "1(2)(3)" 
Output: 2 1 3
Explanation:
           1
          / \
         2   3
Explanation: first pair of parenthesis contains 
left subtree and second one contains the right 
subtree. Inorder of above tree is "2 1 3".
Example 2:

Input: "4(2(3)(1))(6(5))"
Output: 3 2 1 4 5 6
Explanation:
           4
         /   \
        2     6
       / \   / 
      3   1 5   
Your Task:
You don't need to read input or print anything. Your task is to complete the function treeFromString() which takes a string str as input parameter and returns the root node of the tree.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 <= |str| <= 105



class Pair{

    

    Node node;

    int state;

    

    Pair( Node node , int state){

        this.node = node;

        this.state = state;

    }

}

 

class Solution {

    public static Node treeFromString(String s) {

        // code here

        

        if( s.length() == 0 ){

            return null;

        }

        

        Stack<Pair> stack  = new Stack<>();

        

        int index=0;

        String number="";

        while( index<s.length() && (s.charAt(index)!='(' && s.charAt(index)!= ')')){

            number+=s.charAt(index);

            index+=1;

        }

        Node root = new Node( Integer.parseInt(number));

        stack.push( new Pair( root , 0));

        

        while( index<s.length() ){

            

            char ch = s.charAt(index);

            

            if(ch=='('){

                stack.peek().state+=1;

                stack.push(null); // storing to handle empty brackets case..like 1()(2)..but these cases are not included in this test cases

            }else if( ch == ')' ){

                stack.pop();

            }else{

                

                stack.pop(); // remove null; because we have added it to avoid empty bracekts

                

                String digit="";

                while( index<s.length() && (s.charAt(index)!='(' && s.charAt(index)!= ')')){

                    digit+=s.charAt(index);

                    index+=1;

                }

                index-=1; // because it would get incresed at last

                Node node = new Node(Integer.parseInt(digit) );

                

                Pair top = stack.peek();

                

                if( top.state == 1){ /*can be attached to the left side */

                    top.node.left = node;

                }else if( top.state == 2 ){

                    top.node.right = node;

                }

                

                stack.push( new Pair(node , 0 ));

            }

            

            index+=1;

        }

        

        

        return stack.peek().node;

    }

}