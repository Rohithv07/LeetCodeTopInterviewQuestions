Write a program to perform insertions and deletions on a Binary Search Tree.

Perform Q operations of the form:

i x : Insert x in the BST.
d x : Delete x from the BST.

Each element is assigned a value based on its position when it was inserted into the BST. The position of an element is calculated as follows:

The position of the root node is 1.
If the position of a node is p, the positions of its left and right children are (2∗p) and (2∗p+1), respectively.
Note that the positions of the elements may change after some operations, but their values don't.

For each of the Q queries, output the value that is associated with that element in the BST. It is guaranteed that there will be no duplicates in the BST, and a delete operation on an element shall only be called if it's present in the BST.

INPUT:
The first line contains Q, the number of operations to be performed.
Each of the next Q lines contain either i x or d x, as described above.
OUTPUT:
For each query, print the value associated with this element after it was inserted into, or before it was deleted from the BST, based on the query.

CONSTRAINTS:
1≤Q≤103
−109≤x≤109
1≤ position(x) ≤232−1
It is guaranteed that there will be no duplicates in the BST.
A delete operation on an element will only be called if it's present in the BST.
SAMPLE INPUT:
5
i 1
i 2
i 0
d 2
i 3
SAMPLE OUTPUT:
1
3
2
3
3
EXPLANATION:
On inserting 1,

1

On inserting 2:

1
 \
  2

On inserting 0:

   1
  / \
 0   2

After deleting 2:

  1
 /
0

On inserting 3:

   1
  / \
 0   3


import java.util.*;
import java.io.*;
public class Main {
    class Node {
        int key, index;

        Node left, right;

        public Node(int data ,int pos ) {
            key = data;
            index = pos ;
            left = right = null;
        }

    }

    Node root;

    Main() {
        root=null;

    }

    void deleteKey(int key,boolean flag) {
        root=deleteRec(root,key,flag);

    }

    Node deleteRec(Node root,int key,boolean flag) {
        int a=1;
        if (root==null) {
            return root;

        }
        if (key<root.key) {
            root.left=deleteRec(root.left,key,flag);

        } else if(key>root.key) {
            root.right=deleteRec(root.right,key,flag);

        } else {
            if (flag) {
                System.out.println(root.index);

            }
            if (root.left==null)
                return root.right;
            else if (root.right==null)
                return root.left;


            root.key=minValue(root.right);
            root.right=deleteRec(root.right, root.key, false);

        }
        return root;
    }

    int minValue(Node root) {
        int min_value = root.key;
        while (root.left != null) {
            min_value = root.left.key;
            root = root.left;

        }
        return min_value;

    }
void insert(int key,int index ){
        root = insertRec(root,key,index);
}
Node insertRec(Node root,int key,int index){
         if(root == null ) {
             root = new Node(key, index);
             System.out.println(index);
             return root;
         }
         if(key<root.key){
             root.left=insertRec(root.left,key,2*index);

         }
         else if(key>root.key){
             root.right=insertRec(root.right,key,2*index+1);
         }
         return root ;


}

    public static void main(String[] args) throws java.lang.Exception {
        try{
            Main tree = new Main();
            Scanner sc = new Scanner(System.in);
            int quaries = sc.nextInt();
            while(quaries-->0){
                char o =sc.next().charAt(0);
                int v= sc.nextInt();

                if(o == 'i'){
                    tree.insert(v,1);

                }
                else if(o == 'd'){
                tree.deleteKey(v,true );
                }

            }
        }
        catch (Exception e ){
            return ;

        }
    }


}



