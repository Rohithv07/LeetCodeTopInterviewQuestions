Given a linked list and positions m and n. Reverse the linked list from position m to n.

Example 1:

Input :
N = 10
Linked List = 1->7->5->3->9->8->10
                      ->2->2->5->NULL
m = 1, n = 8
Output : 2 10 8 9 3 5 7 1 2 5 
Explanation :
The nodes from position 1 to 8 
are reversed, resulting in 
2 10 8 9 3 5 7 1 2 5.

Example 2:

Input:
N = 6
Linked List = 1->2->3->4->5->6->NULL
m = 2, n = 4
Output: 1 4 3 2 5 6
Explanation:
Nodes from position 2 to 4 
are reversed resulting in
1 4 3 2 5 6.
Your task :
You don't need to read input or print anything. Your task is to complete the function reverseBetween() which takes the head of the linked list and two integers m and n as input and returns the head of the new linked list after reversing the nodes from position m to n.
 
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
 
Constraints:
1<=N<=10^5


//User function Template for Java

/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
    
    // this uses extra space
class Solution
{
    public static Node reverseBetween(Node head, int m, int n)
    {
        //code here
        Node firstPart = new Node(0);
        Node firstPartPointer = firstPart;
        Node lastPart = new Node(0);
        Node lastPartPointer = lastPart;
        Node fromMToN = new Node(0);
        Node fromMToNPointer = fromMToN;
        Node current = head;
        int counter = 1;
        while (counter != m) {
            firstPartPointer.next = new Node(current.data);
            firstPartPointer = firstPartPointer.next;
            current = current.next;
            counter += 1;
        }
        while (counter != n + 1) {
            //System.out.println(counter);
            fromMToNPointer.next = new Node(current.data);
            fromMToNPointer = fromMToNPointer.next;
            current = current.next;
            counter++;
        }
        while (current != null) {
            lastPartPointer.next = new Node(current.data);
            lastPartPointer = lastPartPointer.next;
            current = current.next;
        }
        Node reverse = reverseNode(fromMToN.next);
        Node reversePointer = reverse;
        while (reversePointer.next != null) {
            reversePointer = reversePointer.next;
        }
        reversePointer.next = lastPart.next;
        firstPartPointer.next = reverse;
        return firstPart.next;
        
    }
    
    
    public static Node reverseNode(Node node) {
        if (node == null) {
            return null;
        }
        Node current = node;
        Node previous = null;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}