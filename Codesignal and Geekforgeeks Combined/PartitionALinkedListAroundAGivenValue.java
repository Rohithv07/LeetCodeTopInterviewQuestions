Given a linked list and a value x, partition it such that all nodes less than x come first, then all nodes with value equal to x and finally nodes with value greater than or equal to x. The original relative order of the nodes in each of the three partitions should be preserved. The partition must work in-place.
 
Example 1:
Input:
1->4->3->2->5->2->3,
x = 3
Output:
1->2->2->3->3->4->5
Explanation: 
Nodes with value less than 3 come first, 
then equal to 3 and then greater than 3.
Example 2:
Input:
1->4->2->10 
x = 3
Output: 
1->2->4->10
Explanation:
Nodes with value less than 3 come first,
then equal to 3 and then greater than 3.
Your task:
You don't need to read input or print anything. Your task is to complete the function partition() which takes the head of the inked list and an integer x as input, and returns the head of the modified linked list after arranging the values according to x.
 
Expected time complexity : O(n)
Expected Auxiliary Space: O(n)
 
Constraints:
1 <= N <= 105
1 <= k <= 105



// User function Template for Java

/*class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node partition(Node node, int x) {
        // Your code here
        if (node == null) {
            return null;
        }
        Node smaller = new Node(-1);
        Node equal = new Node(-1);
        Node greater = new Node(-1);
        Node smallerPointer = smaller;
        Node equalPointer = equal;
        Node greaterPointer = greater;
        Node current = node;
        while (current != null) {
            int currentValue = current.data;
            if (currentValue < x) {
                smallerPointer.next = new Node(currentValue);
                smallerPointer = smallerPointer.next;
            }
            else if (currentValue > x) {
                greaterPointer.next = new Node(currentValue);
                greaterPointer = greaterPointer.next;
            }
            else {
                equalPointer.next = new Node(currentValue);
                equalPointer = equalPointer.next;
            }
            current = current.next;
        }
        // we must handle to check whether there is element next of equal, if no element we should move to next of greater
        smallerPointer.next = equal.next == null && greater.next != null ? greater.next : equal.next;
        equalPointer.next = greater.next;
        node = null;
        node = smaller.next;
        return node;
    }
}